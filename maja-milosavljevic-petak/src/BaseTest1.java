package baseHaloOglasi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wdWait;
    public static Actions actions;


    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver( co );
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(125));
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.halooglasi.com/");
    }

    @After
    public void tearDown() {
        //TODO kad zavrsis pisanje svih testova, otkometarisi ispod ovu quit komandu  --> pomoćna komanda da nas podseća sta treba jos da uradimo ---> postoji opcija pod istim imenom u futeru Intelijeja
       // driver.quit(); // ovo zatvara ceo Browser
       // driver.close(); // ovo zatvara tab koji je trenutno u fokusu
    }


}
