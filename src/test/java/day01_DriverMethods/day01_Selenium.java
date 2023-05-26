package day01_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day01_Selenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver_mac64");
        /*
        En temel haliyle  otomasyon yapmak icin class imiza otomasyon icin gerekli olan webdriver in yerini gostermeniz
        gerekir. Bunun icin java kutuphanesinden System.setProperty()
        methodundan icine ilk olarak driver i yazariz. Ikinci olarak driver in fiziki yolunu kopyalariz

         */


        WebDriver driver = new ChromeDriver();

        driver.get("http//www.amazon.com");



    }
}
