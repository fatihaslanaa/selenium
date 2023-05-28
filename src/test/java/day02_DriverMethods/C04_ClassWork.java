package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_ClassWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver_mac64");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Web sayfasina gidin
        driver.get("http://www.amazon.com");

        //Search "city bike"
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

        //Amazonda goruntulenen ilgili sonuclarin sayisini yazdirin

        List<WebElement> aramaSonucYazisi = driver.findElements(By.className("sg-col-inner"));
        System.out.println("Aarama Sonuc Yazisi"+aramaSonucYazisi.get(0).getText());
        //Sonra karsisina cikan ilk sonucun resmini tiklayin.


        //Arama sonuc sayisini konsola yazdiriniz

        String [] sonucSayisi = aramaSonucYazisi.get(0).getText().split(" ");
        System.out.println("Sonuc Sayisi: "+ sonucSayisi[2]) ;


        //Sonra karsiniza cikan ilk sonucun resmini tiklayin

        List<WebElement> ilkWE = driver.findElements(By.className("s-image"));
        ilkWE.get(0).click();



    }

}
