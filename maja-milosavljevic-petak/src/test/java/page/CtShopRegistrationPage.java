package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CtShopRegistrationPage extends BaseTest {
    // naredba extends - nasleđujemo neku klasu --> u ovom slučaju BaseTest klasu

    public CtShopRegistrationPage(){
        PageFactory.initElements(driver,  this);
    }  // ovo je konstruktor metoda ili krace KONSTRUKTOR

    @FindBy (id = "firstname")
    WebElement imeInputField;

    @FindBy (xpath = "//span[text() = `Pošalji`]")
    WebElement posaljiButton;

    public void ImeInputFieldSendKeys() {
        wdWait.until(ExpectedConditions.visibilityOf(imeInputField)).clear();
        imeInputField.sendKeys("Pera");
    }

public void posaljiButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(posaljiButton)).click();
}




}
