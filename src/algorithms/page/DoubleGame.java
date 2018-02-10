package algorithms.page;

import DataStructures.Graphs.Node;
import algorithms.DateInfo;
import algorithms.DateInfo;
import algorithms.math.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class DoubleGame {
    public static int gameNumber = 0;

    public static String[] getNumberInfo(WebDriver driver) throws Exception{
        String tagName = "";
        WebElement page = driver.findElement(By.xpath("html/body"));
        tagName = page.getText();
        String[] lines = tagName.split("\n");
        String[] round = new String[6];
        for(int i = 0;  i < 6; i++){
            round[i] = lines[8+i];
            System.out.println(round[i]);
        }
        return round;
    }

    public static Node newNumber(String[] numberInfo){
        Node node = new Node();
        int number = Integer.parseInt(numberInfo[2]);
        node.setNumber(number);
        node.setColor(color(number));
        node.setGame(numberInfo[0].split(" ")[1].substring(1));
        node.setDate(DateInfo.getDate());
        node.setHashSalt(numberInfo[4].split(" ")[2]);
        node.setRoundHash(numberInfo[3].split(" ")[2]);
        node.setRoundNumber(Double.parseDouble(numberInfo[5].split(" ")[2]));
        return node;
    }

    private static String color(int number){
        if(number == 0){
            return "Green";
        }
        else if(number < 8){
            return "Red";
        }
        else{
            return "Black";
        }
    }



}
