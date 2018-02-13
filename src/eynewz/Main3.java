package eynewz;

import DataStructures.Graphs.Graph;
import DataStructures.Graphs.Node;
import algorithms.math.Percentage;
import algorithms.page.Chrome;
import algorithms.page.DoubleGame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Main3 {
    static int roundNumber = 0;
    static int low1 = 0;
    static int high1 = 0;
    static int low2 = 0;
    static int high2 = 0;
    static int low3 = 0;
    static int high3 = 0;
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Chrome.getDriver("https://csgofast.com/#history/crash/all");


        String[] round;
        int game = 0;
        while(true){
            try {
                driver.navigate().refresh();
                sleep(5000);
                String tagName = "";
                WebElement page = driver.findElement(By.xpath("html/body"));
                tagName = page.getText();
                String[] lines = tagName.split("\n");
                round = new String[2];
                round[0] = lines[7];
                round[1] = lines[12];
                //System.out.println(round[0]);
                int a = Integer.parseInt(round[0].split(" ")[1].substring(1));
                if(a != roundNumber){
                    roundNumber = a;
                    if(Double.parseDouble(round[1].substring(0, round[1].length()-1)) >= 1.15){
                        high1++;
                    }
                    else{
                        low1++;
                    }
                    if(Double.parseDouble(round[1].substring(0, round[1].length()-1)) >= 1.21){
                        high2++;
                    }
                    else{
                        low2++;
                    }
                    if(Double.parseDouble(round[1].substring(0, round[1].length()-1)) >= 1.23){
                        high3++;
                    }
                    else{
                        low3++;
                    }
                    System.out.println("Juego: " + a + "\nMultiplicador: " + round[1]);
                    System.out.println("Alto al 1.15: " + high1 + ", alto al 1.21: " + high2 + ", alto al 1.23: " + high3);
                    System.out.println("Bajo al 1.15: " + low1 + ", bajo al 1.21: " + low2 + ", bajo al 1.23: " + low3);
                    System.out.println("Ganancia al 1.15 : " + (high1*2 - low1*10) + ", ganancia al 1.21 : " + (high2*4 - low2*17) + ", ganancia al 1.23 : " + (high3*6 - low3*24) + "\n");
                }


            } catch (Exception e) {
                sleep(5000);
                //a += 1;
            }
        }
    }
}
