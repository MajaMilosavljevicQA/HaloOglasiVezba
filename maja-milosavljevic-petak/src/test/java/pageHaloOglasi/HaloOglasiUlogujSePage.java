package pageHaloOglasi;

import baseHaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloOglasiUlogujSePage extends BaseTest {

    public HaloOglasiUlogujSePage () {  //konstruktor
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "no-account-reg-link")  //lokacija elementa
    WebElement registrujteSeLink;

    public void registrujteSeLink () {  //interakcija sa elementom
        wdWait.until(ExpectedConditions.elementToBeClickable(registrujteSeLink)).click();
    }
}
