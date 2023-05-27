package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_WebElementsVelocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver_mac64");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         // Amazon sayfasana gidelim
        driver.get("http://www.amazon.com");

        // Search bölümünü locate edelim
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));

       // Search bölümünde iphone aratalim
        aramakutusu.sendKeys("iphone", Keys.ENTER);

        /*
 Eger bir webelementi (Web saufasandaki herbir buton vada text/yaza) locate (konumunu belirleme)
etmek istersek once manuel olarak web sayfasana açap sayfa Üzerinde sag click yapap incele'ye tiklaraz.
Karsamaza cikan HTML kodlarindan locater'lardon (konum belirleyiciler) essiz olana seceriz.
Genellikle id Attribute' kullanalar. Sectigimiz attribute degerini findelement) metodu icine
findelement(By.id("atribute degeri")) seklinde yazaraz
         */
        // Amazon sayfasindaki <input> ve <a> taglarinin sayisini yazdirin

        List<WebElement> inputTags = driver.findElements(By.tagName("input"));
        System.out.println("Input Tag Sayisi ="+inputTags.size());

        List<WebElement> linklerList = driver.findElements(By.tagName("a"));
        System.out.println("Link Sayisi = "+linklerList.size());

        //foreach yolu
        for (WebElement w :linklerList) {
            System.out.println(w.getText());



        }









    }

}
