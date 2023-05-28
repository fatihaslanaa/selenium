package day03_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static jdk.internal.javac.PreviewFeature.Feature.TEST;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver_mac64-2");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //Add Element butonuna basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        //Delete butonu nun  gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//*[@onclick='deleteElement()']"));
        if (deleteButonu.isDisplayed()) { //bir webelementin gorunur olup olmadigini isDisplayed() methodu ile bakariz.
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");
        //Delete tusuna basin
        Thread.sleep(3000);
        deleteButonu.click();
        //"Add/Remove Elements" yazisinin  gorunur oldugunu test edin
        WebElement addRemove = driver.findElement(By.xpath("//h3"));
        if (addRemove.isDisplayed()) {
            System.out.println("test PASSED");
        } else System.out.println("test FAILED");
    }


}
