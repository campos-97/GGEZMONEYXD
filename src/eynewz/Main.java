package eynewz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://csgofast.com/#history/double/all";
        String tagName = "";

        driver.get(baseUrl);
        tagName = driver.findElement(By.tagName("body")).getText(); ;
        System.out.println(tagName);
        driver.close();
        System.exit(0);
    }
}
