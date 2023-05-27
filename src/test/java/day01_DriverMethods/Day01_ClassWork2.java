package day01_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day01_ClassWork2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver_mac64");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//Bu method sayfadaki herbir web element icin
                                                                          //max. bekleme suresini belirler

        //ChromeDriver kullanarak, facebook sayfasing gigin ve sayfa basliginin (title) "facebook" //oldugunu dogrutayin (verify), degilse dogru bastigi yazdirin.
        driver.get("http:/facebook.com");
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("facebook")){
            System.out.println("Title Test PASSED");
        }else System.out.println("Title Test FAILED"+actualTitle);

        //Sayfo URL'inin "facebook" kelimesi icerdigini dogrulayin, icermiyorsa "actual" URL'1 //yazdirin.
        String actualUrl= driver.getCurrentUrl();
        if (actualUrl.contains("facebook")){
            System.out.println("Url Test PASSED");
        }else System.out.println("Url Test FAILED"+ actualUrl);

        //https://www.walmart.com/ sayfasino gidin.
        driver.get("http:/walmart.com/");
       //Sayfa basliginin "Walmart.com" icerdigini dogrulayin.
        String actualWalmartTitle = driver.getTitle();
        String expectedWalmartTitle = "Walmart.com";
        if(actualWalmartTitle.contains(expectedWalmartTitle)){
            System.out.println("Title Testi PASSED");
        }else System.out.println("Title Testi FAILED");

        // Tekrar "facebook" sayfasina donun
        driver.navigate().back();
       //Sayfayi genileyin
        driver.navigate().refresh();
      //  Browser i kapatin
        driver.close();
    }

}
