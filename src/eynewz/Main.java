package eynewz;

import DataStructures.Graphs.Graph;
import DataStructures.Graphs.Node;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.Thread.sleep;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Graph graph = new Graph();
        while(true){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            ChromeOptions options= new ChromeOptions();
            options.addArguments("--headless  --no-startup-window");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            WebDriver driver = new ChromeDriver();
            String baseUrl = "https://csgofast.com/#history/double/all";
            String tagName = "";
            driver.get(baseUrl);
            WebElement page = driver.findElement(By.xpath("html/body"));
            tagName = page.getText();
            driver.close();
            String[] lines = tagName.split("\n");
            String[] round = new String[6];
            try {
                for(int i = 0;  i < 6; i++){
                    round[i] = lines[8+i];
                    System.out.println(round[i]);
                }
                System.out.println(round[2]);
                Node node = new Node();
                node.setNumber(Integer.parseInt(round[2]));
                graph.addNode(node);
            }catch (Exception e){

            }
            sleep(60000);


        }
    }
}
