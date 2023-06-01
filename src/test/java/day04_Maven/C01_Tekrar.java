package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Tekrar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//-Amazon sayfasina gidiniz
 driver.get("https://www.amazon.com");
//-Arama kutusunu locate edinidiz
        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholders""
        class="nav-input nav-progressive-attribute" dir="outo" tabindex="g" aria-lobel="Search" spellcheck="false"»
*/
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox"));
//-Arama kutusunun tagName inin input oldugunu test ediniz
        String actualTagname = aramaKutusu.getTagName();
        String expectedTagname= "input";
         if (actualTagname.equals(expectedTagname)){
             System.out.println("Tagname Testi Passed" +actualTagname);
         }else System.out.println("Tagname Testi Failed" +actualTagname);
//-Arama kutusunun name atributo'nun degerinin field-keywords oldugunu test ediniz
        String name;
        String actualAttributeName = aramaKutusu.getAttribute("name") ;
        String expectedAttributeName = "field-Keywords";
        if (actualAttributeName.equals(expectedAttributeName)) {
            System.out.println("Atribute TESTI PASSED");
        }else System.out.println("Atribute TESTI FAILED");
//-Sayfaya kapatiniz
        driver.close();
    }
}
