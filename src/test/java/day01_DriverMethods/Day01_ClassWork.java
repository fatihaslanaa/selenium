package day01_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_ClassWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver_mac64");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Amazon sayfasina gidelim
        driver.get("http://www.amazon.com");
        //Sayfa basligini(title)yazdirin
        System.out.println("Sayfa basligi :" +driver.getTitle());
        //Sayfa basliginin "Amazon icerdigini test edin
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Amazon")){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");
        //SAYFA URL'ININ "Amazon" icerdigini test edin.
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains("amazon")){
            System.out.println("Url Testi PASSED");
        }else System.out.println("Url Testi FAILED");
        //Sayfa Handle degerini yazdirin
        System.out.println("Window Handle Degeri : "+driver.getWindowHandle());
        //Sayfa  HTML kodlarinda "Gateway" kelimesi gectini test edin
        String sayfaKodlari = driver.getPageSource();
        if(sayfaKodlari.contains("Gateway")){
            System.out.println("Source Code Testi PASSED");
        }else System.out.println("Source Code Testi FAILED");
        //Sayfayi kapatin.
        driver.close(); //Sayfayi kapatmak  icin close()methodu kullaniriz




    }
}

