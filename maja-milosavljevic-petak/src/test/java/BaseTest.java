import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.ClientStats;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class BaseTest {

    //ovde smo deklarisali našu promenljivu driver
    public static WebDriver driver;
    // ovde deklarišemo promenljivu wdWait koji nam sluzi za cekanje
    public static WebDriverWait wdWait;

    // ovde deklarišemo promenljivu actionskao sto su HOVER i SCROLL, dupli klik, drag&drop itd.
    public static Actions actions;



    //ovo je Junit anotacija koja govori kompajleru da će se metoda koja sledi izvršiti pre svih testova

    @Before
    public void setUp() {
        // ovo automatski skida/usklađuje odgovarajuću verziju drajvera i pretraživača
       // WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();

        // Ovde smo našoj promenljivoj driver dodelili objekat klase Chromedriver


        //driver = new FirefoxDriver();
      //  wdWait = new WebDriverWait(driver, Duration.ofSeconds(15));
      //  actions = new Actions(driver);


        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver ( co );
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
    }

    // Ovo je Junit anotacija koja govori kompajleru da će metoda koja sledi da se izvrši NAKON  svih testova.
    @After
    //Ova metoda cije ime dajemo proizvoljno, ali po konvenciji nazivamo je tearDown ili cleanUp
    public void tearDown() {
        //Zakomentarisani su sledeći drajveri dok učimo. Inače treba da budu otvoreni. Posebno quit
        //  driver.quit(); // ovo zatvara ceo Browser
        // driver.close(); // ovo zatvara tab koji je trenutno u fokusu
    }

    @Test  // za imenovanja na netu pogledajte "Camel case"
    public void firstTestOnTheCourseWhichShowsFirstStepsOfAutomatiozation() {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void secondTest() {
        driver.get("https://www.google.com/");
        driver.get("https://www.yahoo.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().fullscreen();
        driver.close();
    }

    @Test
    public void lokatoriTest() {
        driver.get("https>//www.google.com/");
        driver.findElement(By.id("SIvCob"));
        driver.findElement(By.name("q")); // Ovako lociram Google Search polje preko atributa "name"
        driver.findElement(By.className("gLFyf")); // Ovako lociram GS polje preko imena proste klase  --> SLOŽENA klasa npr Zeka Peka će se tražiti --> .Zeka.Peka  (uz pomoć tačaka ispred i umesto svakog spejsa)
        driver.findElement(By.cssSelector("[maxlenght=\"2048\"]")); // Ovako lociram GS polje preko CSS selektora koriateći bilo koji atribut
        String s = "//input";
        // driver.findElement(By.xpath(xpathExpression://input@));


//APSOLUTNI XPATH NE KORISTIMO! ZABRANJENO JE!
        // Relativni XPATH koristimo
        // String imeSkole = "Osnovna skola \"Petar Petrović Njegoš\"";
    }

    @Test
    public void ctShopSuccessfulRegistration() {
        driver.manage().window().maximize();
        driver.get("https://www.ctshop.rs/customer/account/create");
        driver.findElement(By.xpath("//button[text() = 'Prihvatam']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Miroslav");
        driver.findElement(By.id("lastname")).sendKeys("Culic");
        driver.findElement(By.id("email_address")).sendKeys("nde4k98d55sa@gde.tu");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.id("password")).sendKeys("lozinka");
        driver.findElement(By.id("confirmation")).sendKeys("lozinka");
        driver.findElement(By.xpath("//span[text()= 'Pošalji']")).click();
        driver.findElement(By.cssSelector(".alert.alert-success"));


        String expected = "Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.";
        String actual = driver.findElement(By.cssSelector(".alert.alert-success")).getText();

        // Assert.assertEquals( expected , actual ) ;
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void ctShopSuccessfulRegistrationWithWaitsExample() {
        driver.manage().window().maximize();
        driver.get("https://www.ctshop.rs/customer/account/create");

        // ovde prikayujem dve vrste cekanja> 1. cekanje na element na koji se klikce - dugme, checkbox, 2. Cekanje na ostale elemente:
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']")));
// 2. Cekanje na ostale elemente:
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));  // cekanje na polje firstname
    }

    @Test
    public void ctShopSuccessfulRegistrationWithWaits() {
        driver.manage().window().maximize();
        driver.get("https://www.ctshop.rs/customer/account/create");


        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']")));
        driver.findElement(By.xpath("//button[text() = 'Prihvatam']")).click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Miroslav");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname")));
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("Culic");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address")));
        driver.findElement(By.id("email_address")).clear();
        driver.findElement(By.id("email_address")).sendKeys("nde4k98d55sa@gde.tu");


        driver.findElement(By.id("is_subscribed")).click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("lozinka");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation")));
        driver.findElement(By.id("confirmation")).clear();
        driver.findElement(By.id("confirmation")).sendKeys("lozinka");

        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'Pošalji']")));
        driver.findElement(By.xpath("//span[text()= 'Pošalji']")).click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-success")));
        driver.findElement(By.cssSelector(".alert.alert-success"));

        String expected = "Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.";
        String actual = driver.findElement(By.cssSelector(".alert.alert-success")).getText();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void ctShopSuccessfulRegistrationWithWaits2Shorter() {
        driver.manage().window().maximize();
        driver.get("https://www.ctshop.rs/customer/account/create");


        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).clear();
        driver.findElement(By.id("firstname")).sendKeys("Marko");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastname"))).clear();
        driver.findElement(By.id("lastname")).sendKeys("Maric");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email_address"))).clear();
        driver.findElement(By.id("email_address")).sendKeys("sega@drt.tu");


        driver.findElement(By.id("is_subscribed")).click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).clear();
        driver.findElement(By.id("password")).sendKeys("lozinka");

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmation"))).clear();
        driver.findElement(By.id("confirmation")).sendKeys("lozinka");

        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'Pošalji']"))).click();

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-success")));

        Assert.assertTrue(driver.findElement(By.cssSelector(".alert.alert-success")).isDisplayed());

        String expected = "Hvala na registraciji. Molimo proverite email i aktivirajte Vaš nalog.";
        String actual = driver.findElement(By.cssSelector(".alert.alert-success")).getText();





    }

    @Test
    public void naredbeZaHoverIScroll(){
        /*WebElement posaljiDugme =  driver.findElement(By.xpath("//span[text()= 'Pošalji']"));
       // actions.moveToElement(posaljiDugme);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()= 'Pošalji']"))).perform();
       actions.scrollByAmount(0, 300).perform(); //skrolovanje nula po x osi i 300 piksela po vertikali*/

        // kad imamo hover u testu , ne smemo pomerati misa.
        actions.moveToElement(driver.findElement(By.xpath("//span[text()= 'Pošalji']"))).perform();
        actions.scrollByAmount(0, 300).perform();   // skrolovanje nula po x osi i 300 piksela po vertikali
    }

    @Test
    public void ctShopSporetiTestGorenjeModelGK5A11WGBojaSporeta () {
        driver.manage().window().maximize();
        driver.get("https://www.ctshop.rs");
       // Ovom akcijom kliknemo na Prihvatam dugme za Uslove koriscenja
         wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Prihvatam']"))).click();

        // Ovom akcijom hoverujemo SVI PROIZVODI i ocekuje se da se lista ispod pokaze
        actions.moveToElement(driver.findElement(By.xpath("//span[text()= 'SVI PROIZVODI']"))).perform();

        // Ovom akcijom hoverujemo Bela tehnika i ocekuje se da se lista desno pokaze
        actions.moveToElement(driver.findElement(By.xpath("//a[text()= 'Bela tehnika']"))).perform();

       // Ovom akcijom kliknemo na opciju Šporeti iz tog menija sa desne strane koji se pojavi
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()= 'Šporeti']"))).click();

        // Ovom akcijom kliknemo na opciju Kombinovani šporeti na stranici koja se otovrila
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()= 'Kombinovani šporeti']"))).click();

        // filter_data_brend_142 ID po kome treba cekirati filter za Gorenje
        // wdWait.until(ExpectedConditions.elementToBeClickable(By.id("filter_data_brend_142"))).click();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()= 'Gorenje']"))).click();

        actions.scrollByAmount(0, 450).perform();   // skrolovanje nula po x osi i 450 piksela po vertikali
        driver.findElement(By.xpath("//img[@alt='Gorenje GK5A11WG kombinovani šporet']")).click();  // Pronađi Gorenje GK5A11WG kombinovani šporet i klikni na njega preko Selectros Hub xpatha

        actions.scrollByAmount(0, 550).perform();   // skrolovanje nula po x osi i 550 piksela po vertikali


        //Proveravamo da li je prikazan tekst:
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='specifikacija']//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//i[1]")).isDisplayed());

        String expected = "Belo";  // Ovo je tekst koji piše na strani koju korisnik vidi - Boja proizvoda - Belo
        String actual = driver.findElement(By.xpath("//div[@id='specifikacija']//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//i[1]")).getText(); //Ovde proveravamo da li ZAISTA PIŠE ono što smo naveli u Stringu expected, preko Selectros Hub xpatha

        Assert.assertEquals(expected, actual);  // Proveravamo da li su expected i actual jednaki.
        //Pogledaj pisanje sa 9. časa da prepraviš kod. Dobar je, ali može bolje.
    }





}