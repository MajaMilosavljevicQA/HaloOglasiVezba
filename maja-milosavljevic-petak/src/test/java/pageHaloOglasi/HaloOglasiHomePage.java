package pageHaloOglasi;

import baseHaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloOglasiHomePage extends BaseTest {

    public HaloOglasiHomePage () {
        PageFactory.initElements(driver, this);
    } // konstruktor koji ima isto ime kao klasa i  ima samo jednu naredbu

@FindBy (className = "cookie-policy-btn")
    WebElement uReduButton;

    @FindBy (linkText = "Uloguj se")
    WebElement ulogujSeLink;

    public void  uReduButtonClick () {
        wdWait.until (ExpectedConditions.elementToBeClickable(uReduButton)).click();
    }

    public void ulogujSeLinkClick () {
        wdWait.until (ExpectedConditions.elementToBeClickable(ulogujSeLink)).click();
    }

}
