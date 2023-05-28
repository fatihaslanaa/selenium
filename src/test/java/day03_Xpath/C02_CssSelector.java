package day03_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_CssSelector {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");
        //Sayfayi "refresh" yapin
        driver.navigate().refresh();
        //Sayfa basliginin "Spend less" icerdigini test edin.
        String actualTitle = driver.getTitle();
        String arananKelime = "Spend less";
        if (actualTitle.contains(arananKelime)){
            System.out.println("Title Test PASSED");
        }else System.out.println("Title Test FAILED");
        //Gift cards sekmesine basin
        driver.findElement(By.cssSelector("a[href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc']")).click();
        //Birthday butonuna bakin
        driver.findElement(By.cssSelector("img[alt='Birthday']"));
        //Best Seller bolumunden ilk urunu tiklayin 9-Gift card details'den 25$ 'i secin
        List<WebElement> bestSellerB = driver.findElements(By.cssSelector("img[alt='Amazon.com eGift Card']"));
        bestSellerB.get(0).click();
        driver.findElement(By.cssSelector("span[id='a-autoid-28']")).click();
        //Urun ucretinin 25$ oldugunu test edin
        WebElement urunucreti = driver.findElement(By.cssSelector("span[id='gc-live-preview-amaount']"));
        if(urunucreti.getText().equals("$25.00")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");
        //Sayfayi kapatin
        driver.close();


    }
}

