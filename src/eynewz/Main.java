package eynewz;

import DataStructures.Graphs.Graph;
import DataStructures.Graphs.Node;
import algorithms.math.Percentage;
import algorithms.page.DoubleGame;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Graph graph = new Graph();
        String baseUrl = "https://csgofast.com/#history/double/all";
        driver.get(baseUrl);
        int[] colors = new int[3];
        int a = 0;
        List<Node> nodes = new LinkedList<Node>();
        while(true){

            String[] round;
            try {
                driver.navigate().refresh();
                sleep(1000);
                round = DoubleGame.getNumberInfo(driver);
                int num = Integer.parseInt(round[2]);
                Node node = DoubleGame.newNumber(round);
                graph.addNode(node);
                nodes.add(DoubleGame.newNumber(round));
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
                sleep(50000 - 5000*a);
                a = 0;
                node.printNode();
            } catch (Exception e) {
                sleep(5000);
                a += 1;
                e.printStackTrace();
            }
        }
    }
}
