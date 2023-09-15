package pageHaloOglasi;

import baseHaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HaloOglasiRegistracijaJeUspelaPage extends BaseTest {

    public HaloOglasiRegistracijaJeUspelaPage () {
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "regsitration-success")
    WebElement registracijaJeUspelaMessage;

    //treba da napisemi dve metode: 1 da vraca info da li je element prikazan, a druga da vrati unutrasnji tekt elementa naredbom getText().

    public boolean registracijaJeUspelaMessageIsDisplayed () {
        wdWait.until(ExpectedConditions.visibilityOf(registracijaJeUspelaMessage));
        return registracijaJeUspelaMessage.isDisplayed();
    }

    public String registracijaJeUspelaMessageGetText(){
        wdWait.until(ExpectedConditions.visibilityOf(registracijaJeUspelaMessage));
        return registracijaJeUspelaMessage.getText();
    }

}
