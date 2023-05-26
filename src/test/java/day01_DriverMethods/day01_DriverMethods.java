package day01_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day01_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver_mac64");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();//bos bir browser acmak
        driver.get("http://www.amazon.com");//ilk olarak gitmek istenilen sayfa belirtme
        System.out.println("Sayfa Basligi : "+driver.getTitle());
        System.out.println("Sayfa Url'i : " +driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());
        System.out.println(driver.getWindowHandle());// Bize  o windw a ait degerini verir Biz bu hash degerlerini
                                                     // bir string e atayip pencereler arasi gecis yapabiliriz




    }
}
