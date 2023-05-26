package day01_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_NavigateMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver_mac64");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // amazona git
        driver.navigate().to("http://amazon.com");
        //ebay sayfasina git
        Thread.sleep(3000);//uc sn bekler
        driver.navigate().to("http://ebay.com");
        //Tekrar amazon sayfasina git
        Thread.sleep(3000);
        driver.navigate().back();
        //Tekrar ebay sayfasina gider
        Thread.sleep(3000);
        driver.navigate().forward();
        //Son sayfada sayfayi yeniler
        driver.navigate().refresh();
        //Ve sayfayi kapatalim
        driver.close();
        //not*****
        //get ilede oluyor navigate ilede adrese gidilir.(fark yoktur.)
    }
}
