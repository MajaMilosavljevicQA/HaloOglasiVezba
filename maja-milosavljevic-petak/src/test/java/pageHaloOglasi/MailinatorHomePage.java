package pageHaloOglasi;

import baseHaloOglasi.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorHomePage extends BaseTest {

    public MailinatorHomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search")
    WebElement publicMailinatorInboxInputField;

    //@FindBy(css = "["id = \"search\"])
    //WebElement publicMailinatorInboxInputField
    // ovo je nacin da se isti element publicMailinatorInbox pronadje preko css-a, ali koriste'i id atribut

    @FindBy (xpath = "//input[@id='search-mobile']")
    WebElement goButton;

    public void publicMailinatorInboxInputFieldSendKeysPlusPressEnter(String email){
        wdWait.until(ExpectedConditions.visibilityOf(publicMailinatorInboxInputField)).clear();
        publicMailinatorInboxInputField.sendKeys(email);
        publicMailinatorInboxInputField.sendKeys(Keys.ENTER);
        //ovo iznad je najlaksi nacin gde smo u jednoj metodi i poslali nesto u polje i kliknuli Enter dugme

    }

    //sad pisemo dva nacina, tj. dve metode, a samo jednu od njih cemo da pozovemo u testu, svejedno je za ulazak u mailinator inbox

  /*

   klikni na button go -->*/

       public void goButtonClick (){
        wdWait.until(ExpectedConditions.elementToBeClickable(goButton)).click();

    }

    // udariti enter -->

     public void publicMailinatorInboxInputFieldPressEnter (){
     publicMailinatorInboxInputField.sendKeys(Keys.ENTER);
     }

}
