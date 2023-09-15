package pageHaloOglasi;

import baseHaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class MailinatorAktivacioniEmailPage extends BaseTest {

    public  MailinatorAktivacioniEmailPage (){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//strong[contains(text(),'Aktiviraj nalog')]")
    WebElement aktivirajNalogButton;

    @FindBy(id = "html_msg_body")
    WebElement iframe;

    public void aktivirajNalogButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(aktivirajNalogButton)).click();
    }

    public void switchFocusToIframe(){
        wdWait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);
    }

    public void switchFocusToDefaultHtml(){
        //povratak fokusa na originalni (spoljni) html
        driver.switchTo().defaultContent();
    }



    public void switchFocusToNewTab(){
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
