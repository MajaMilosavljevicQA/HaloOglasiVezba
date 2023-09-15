package testHaloOglasi;

import baseHaloOglasi.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageHaloOglasi.*;

import java.util.UUID;

public class HaloOglasiTests extends BaseTest {

    HaloOglasiHomePage haloOglasiHomePage;
    HaloOglasiRegistracijaPage haloOglasiRegistracijaPage;
    HaloOglasiUspesnaAktivacijaPage haloOglasiUspesnaAktivacijaPage;
    HaloOglasiRegistracijaJeUspelaPage haloOglasiRegistracijaJeUspelaPage;
    HaloOglasiUlogujSePage haloOglasiUlogujSePage;
    MailinatorHomePage mailinatorHomePage;
    MailinatorInboxPage mailinatorInboxPage;
    MailinatorAktivacioniEmailPage mailinatorAktivacioniEmailPage;

    @Before
    public void setUpHaloOglasiInicijalizacijaStranica(){
        haloOglasiHomePage = new HaloOglasiHomePage();
        haloOglasiRegistracijaPage = new HaloOglasiRegistracijaPage();
        haloOglasiUspesnaAktivacijaPage = new HaloOglasiUspesnaAktivacijaPage();
        haloOglasiRegistracijaJeUspelaPage = new HaloOglasiRegistracijaJeUspelaPage();
        haloOglasiUlogujSePage = new HaloOglasiUlogujSePage();
        mailinatorHomePage = new MailinatorHomePage();
        mailinatorAktivacioniEmailPage = new MailinatorAktivacioniEmailPage();
        mailinatorInboxPage = new MailinatorInboxPage();
    }

    @Test
    public void haloOglasiTestUspesneRegistracijeIAktivacijeFizickogLica(){

        //pogledajte i faker biblioteku na internetu kako se koristi - kreiranje laznih naloga

        String korisnik = "peraLozac" + UUID.randomUUID().toString().substring(0,5);
        String korisnikEmail = korisnik + "@mailinator.com";

        haloOglasiHomePage.uReduButtonClick();
        haloOglasiHomePage.ulogujSeLinkClick();
        haloOglasiUlogujSePage.registrujteSeLink();
        haloOglasiRegistracijaPage.fizickogLicaRadioButtonAlwaysSelected();
        haloOglasiRegistracijaPage.korisnickoImeInputFieldSendKeys(korisnik);
        haloOglasiRegistracijaPage.emailInputFieldSendKeys(korisnik + "@mailinator.com");
        haloOglasiRegistracijaPage.lozinkaInputFieldSendKeys("123456789");
        haloOglasiRegistracijaPage.ponoviLozinkuInputFieldSendKeys("123456789");
        haloOglasiRegistracijaPage.saglasanSamCheckboxClick();
        haloOglasiRegistracijaPage.registrujSeButtonClick();
        Assert.assertTrue(haloOglasiRegistracijaJeUspelaPage.registracijaJeUspelaMessageIsDisplayed());
        Assert.assertEquals("Registracija je uspela!\n" +
                "Kako bi Vaš nalog postao aktivan, neophodno je da kliknite na link u mejlu koji Vam je poslat na : " + korisnikEmail  +" !", haloOglasiRegistracijaJeUspelaPage.registracijaJeUspelaMessageGetText());

        // Registracija je uspela!
        //
        //Kako bi Vaš nalog postao aktivan, neophodno je da kliknite na link u mejlu koji Vam je poslat na : peralozac12h3o5@mailinator.com !

        driver.get("https://www.mailinator.com");
        mailinatorHomePage.publicMailinatorInboxInputFieldSendKeysPlusPressEnter(korisnikEmail);
        mailinatorInboxPage.haloOglasiEmailClick();
      mailinatorAktivacioniEmailPage.switchFocusToIframe(); //dodajemo da bi driveru postao vidljiv aktiviraj nalog button
       mailinatorAktivacioniEmailPage.aktivirajNalogButtonClick();
       mailinatorAktivacioniEmailPage.switchFocusToNewTab();
        Assert.assertTrue(haloOglasiUspesnaAktivacijaPage.nalogUspesnoAktiviranMessageIsDisplayed()
        );

        Assert.assertEquals("Vaš nalog je uspešno aktiviran!\n" +
                "Produžite na stranicu za logovanje kako biste pristupili našem portalu. Prijava"
                , haloOglasiUspesnaAktivacijaPage.nalogUspesnoAktiviranMessageGetText());



    }


}
