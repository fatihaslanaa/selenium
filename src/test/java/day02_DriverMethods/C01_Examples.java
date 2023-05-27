package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Examples {
    static WebDriver driver;
    public static void main(String[] args) {
        /*
      Ilk once browser i maximize yapalim sonra tum sayfa icin max bekleme suresi olarak 15 saniye belirtelim
      Sirasiyla Amazon Facebook ve Youtube sayfasina gidelim
      Amazon sayfasina tekrar donelim
      Amazon sayfasinin url inin http://www.amazon.com/ adresine esit oldugunu test edelim
      Ve sayfayi kapatalim

     */
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver_mac64");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //IlK once browser i maximize yapalim song tüm sayfo için max bekleme süresi olarak 15 saniye belirtelim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Sarasayla amazon, facebook ve youtube soyfalaring gidelim.
        driver.get("http://www.amazon.com");
        driver.get("http://www.facebook.com");
        driver.get("http://www.youtube.com");


        //Amazon sayfasana tekrar donelim.
        driver.navigate().back();
        driver.navigate().back();


        //Amazon sayfasanan Url'inin https://www.amazon.com/ adresine sit oldugunu test edelim

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://www.amazon.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Url Testi PASSED");
        }else System.out.println("Url Testi FAILED");


        //Sayfanin konumunu ve size'ina yazdaralim
        System.out.println("Sayfanin size i :"+driver.manage().window().getSize());
        System.out.println("Sayfanin konumu  :"+driver.manage().window().getPosition());



        //Sayfanin konumunu ve size'ina istedigimiz sekilde ayarliyalim
        driver.manage().window().setSize(new Dimension(600,600));
        driver.manage().window().setPosition(new Point(50,50));
        System.out.println("Sayfanin yeni size i: "+driver.manage().window().getSize());
        System.out.println("Sayfanin yeni konumu: i"+driver.manage().window().getPosition());

       //Ve istedigimiz sekilde oldugunu test edelim
      Dimension actualNewSize = driver.manage().window().getSize();

      if (actualNewSize.getWidth()==600 && actualNewSize.getHeight()==600){
          System.out.println("Size TESTI PASSET");
      }else System.out.println("Size TESTI FAILED");

      Point actualNewLocation = driver.manage().window().getPosition();
      if(actualNewLocation.getX()==50 && actualNewLocation.getY()==50){
          System.out.println("Location Test PASSED");
      }else System.out.println("Location Test FAILED");

        // ve sayfay1 kapatalim
        driver.close();





    }
}
