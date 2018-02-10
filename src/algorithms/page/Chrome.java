package algorithms.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {


    public static WebDriver getDriver(String url){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //String baseUrl = "https://csgofast.com/#history/double/all";
        driver.get(url);
        return driver;
    }
}
