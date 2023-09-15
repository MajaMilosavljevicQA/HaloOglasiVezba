package pageHaloOglasi;

import baseHaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloOglasiRegistracijaPage extends BaseTest {


        public HaloOglasiRegistracijaPage () {  //konstruktor
            PageFactory.initElements(driver, this);
        }

@FindBy(css = "[value=\"person\"]")
    WebElement fizickogLicaRadioButton;

@FindBy(id = "UserName")
    WebElement korisnickoImeInputField;

@FindBy(id ="Email")
    WebElement emailInputField;

@FindBy(id="Password")
    WebElement lozinkaInputField;

    @FindBy(id = "ConfirmPassword")
    WebElement ponoviLozinkuInputField;

    @FindBy(id = "HasAgreedToGetFiscalReceiptByEmail")
    WebElement saglasanSamCheckbox;

    @FindBy(css ="[class=\"button-reg save save-entity person-face btn-main\"]")
    WebElement registrujSeButton;

    public void fizickogLicaRadioButtonAlwaysSelected () {

       /* wdWait.until(ExpectedConditions.visibilityOf(fizickogLicaRadioButton));
        boolean selectState = fizickogLicaRadioButton.isSelected();

        System.out.println("Radio Button `Fizickog lica` is SELECTED? " + selectState);
        if (!selectState)
            fizickogLicaRadioButton.click();*/  // Miroslavljev kod

        wdWait.until(ExpectedConditions.elementToBeClickable(fizickogLicaRadioButton));

        if (fizickogLicaRadioButton.isSelected() == false)

            fizickogLicaRadioButton.click();

    }

    public void korisnickoImeInputFieldSendKeys(String korisnickoIme){
        wdWait.until(ExpectedConditions.visibilityOf(korisnickoImeInputField)).clear();
        korisnickoImeInputField.sendKeys(korisnickoIme);
    }

    public void emailInputFieldSendKeys(String email){
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField)).clear();
        emailInputField.sendKeys(email);
    }

    public void lozinkaInputFieldSendKeys(String lozinka){
        wdWait.until(ExpectedConditions.visibilityOf(lozinkaInputField)).clear();
        lozinkaInputField.sendKeys(lozinka);
    }

    public void ponoviLozinkuInputFieldSendKeys(String ponoviLozinku){
        wdWait.until(ExpectedConditions.visibilityOf(ponoviLozinkuInputField)).clear();
        ponoviLozinkuInputField.sendKeys(ponoviLozinku);
    }

    public void saglasanSamCheckboxClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(saglasanSamCheckbox)).click();
    }

    public void registrujSeButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(registrujSeButton)).click();
    }
}
