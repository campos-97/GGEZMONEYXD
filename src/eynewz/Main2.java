package eynewz;
import DataStructures.Graphs.Graph;
import DataStructures.Graphs.Node;
import algorithms.math.Percentage;
import algorithms.page.Chrome;
import algorithms.page.DoubleGame;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.lang.Thread.sleep;


public class Main2 extends Application {

    private static final int MAX_DATA_POINTS = 50;
    private int xSeriesData = 0;
    private XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
    private XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
    private XYChart.Series<Number, Number> series3 = new XYChart.Series<>();
    private ExecutorService executor;
    private ConcurrentLinkedQueue<Number> dataQ1 = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<Number> dataQ2 = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<Number> dataQ3 = new ConcurrentLinkedQueue<>();

    private NumberAxis xAxis;

    public static WebDriver driver;
    public static Graph graph;
    public static int[] colors;
    public static int a;
    public static List<Node> nodes;

    private void init(Stage primaryStage) {

        xAxis = new NumberAxis(0, 100, 10);
        xAxis.setForceZeroInRange(false);
        xAxis.setAutoRanging(true);
        xAxis.setTickLabelsVisible(true);
        xAxis.setTickMarkVisible(false);
        xAxis.setMinorTickVisible(false);

        NumberAxis yAxis = new NumberAxis();

        // Create a LineChart
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis) {
            // Override to remove symbols on each data point
            @Override
            protected void dataItemAdded(Series<Number, Number> series, int itemIndex, Data<Number, Number> item) {
            }
        };

        lineChart.setAnimated(false);
        lineChart.setTitle("Animated Line Chart");
        lineChart.setHorizontalGridLinesVisible(true);

        // Set Name for Series
        series1.setName("Series 1");
        series2.setName("Series 2");
        series3.setName("Series 3");

        // Add Chart Series
        lineChart.getData().addAll(series1, series2, series3);

        primaryStage.setScene(new Scene(lineChart));
    }


    @Override
    public void start(Stage stage) {
        stage.setTitle("Animated Line Chart Sample");
        init(stage);
        stage.show();


        executor = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });

        AddToQueue addToQueue = new AddToQueue();
        executor.execute(addToQueue);
        //-- Prepare Timeline
        prepareTimeline();
    }

    private class AddToQueue implements Runnable {
        public void run() {
            String[] round;
            try {
                // add a item of random data to queue
                driver.navigate().refresh();
                sleep(5000);
                round = DoubleGame.getNumberInfo(driver);
                int num = Integer.parseInt(round[2]);
                Node node = DoubleGame.newNumber(round);
                graph.addNode(node);
                nodes.add(node);
                node.printNode();
                if(num == 0){
                    colors[2] += 1;
                }
                else if(num < 8){
                    colors[0] += 1;
                }
                else{
                    colors[1] += 1;
                }
                System.out.println("Green: " + "\n" + colors[2] + "\n"  + Percentage.getPercentage(colors, 2) + "%\n"
                        + "Red: " + "\n" + colors[0] + "\n"  + Percentage.getPercentage(colors, 0) + "%\n"
                        + "Black: " + "\n" + colors[1] + "\n"  + Percentage.getPercentage(colors, 1) + "%\n");
                a = 0;

                dataQ1.add(num);
                //dataQ2.add(Math.random());
                //dataQ3.add(Math.random());
                //Thread.sleep(100);
                Thread.sleep(42500 - 5000*a);
                executor.execute(this);
            } catch (Exception ex) {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a += 1;
                ex.printStackTrace();
            }
        }
    }

    //-- Timeline gets called in the JavaFX Main thread
    private void prepareTimeline() {
        // Every frame to take any data from queue and add to chart
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                addDataToSeries();
            }
        }.start();
    }

    private void addDataToSeries() {
        for (int i = 0; i < 20; i++) { //-- add 20 numbers to the plot+
            if (dataQ1.isEmpty()) break;
            series1.getData().add(new XYChart.Data<>(xSeriesData++, dataQ1.remove()));
            series2.getData().add(new XYChart.Data<>(xSeriesData++, dataQ2.remove()));
            series3.getData().add(new XYChart.Data<>(xSeriesData++, dataQ3.remove()));
        }
        // remove points to keep us at no more than MAX_DATA_POINTS
        if (series1.getData().size() > MAX_DATA_POINTS) {
            series1.getData().remove(0, series1.getData().size() - MAX_DATA_POINTS);
        }
        if (series2.getData().size() > MAX_DATA_POINTS) {
            series2.getData().remove(0, series2.getData().size() - MAX_DATA_POINTS);
        }
        if (series3.getData().size() > MAX_DATA_POINTS) {
            series3.getData().remove(0, series3.getData().size() - MAX_DATA_POINTS);
        }
        // update
        xAxis.setLowerBound(xSeriesData - MAX_DATA_POINTS);
        xAxis.setUpperBound(xSeriesData - 1);
    }

    public static void main(String[] args) {
        driver = Chrome.getDriver("https://csgofast.com/#history/double/all");
        graph = new Graph();
        colors = new int[3];
        a = 0;
        nodes = new LinkedList<Node>();
        launch(args);
    }
}