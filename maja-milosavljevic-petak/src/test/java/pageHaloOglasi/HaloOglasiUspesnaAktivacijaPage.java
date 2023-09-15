package pageHaloOglasi;

import baseHaloOglasi.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HaloOglasiUspesnaAktivacijaPage extends BaseTest {

    public HaloOglasiUspesnaAktivacijaPage(){
        PageFactory.initElements (driver, this);
    }

    @FindBy(className = "regsitration-success")
    WebElement nalogUspesnoAktiviranMessage;

    public boolean nalogUspesnoAktiviranMessageIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(nalogUspesnoAktiviranMessage));
        return nalogUspesnoAktiviranMessage.isDisplayed();
    }
    public String nalogUspesnoAktiviranMessageGetText(){
        wdWait.until(ExpectedConditions.visibilityOf(nalogUspesnoAktiviranMessage));
        return nalogUspesnoAktiviranMessage.getText();
        }


    }

