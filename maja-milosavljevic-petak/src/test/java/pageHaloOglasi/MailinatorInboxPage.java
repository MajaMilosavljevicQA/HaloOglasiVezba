package pageHaloOglasi;

import baseHaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorInboxPage extends BaseTest {

    public MailinatorInboxPage () {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[contains(text(),'Molimo aktivirajte Vaš Halo oglasi nalog')]")
    WebElement haloOglasiEmail;

    public void haloOglasiEmailClick(){
        wdWait.until(ExpectedConditions.visibilityOf(haloOglasiEmail)).click();
    }
}
