package steps;

import io.cucumber.java.en.Given;
import org.testng.Assert;
import pageobjects.locators.Home;
import pageobjects.locators.Login;
import pageobjects.pages.BasePageManager;
import utils.PropertyUtils;

public class BaseSteps extends BasePageManager{

    @Given("Uygulama sayfasina gidilir")
    public void uygulama_sayfasina_gidilir() {
        browser.navigateTo(PropertyUtils.getProperty("url"));
    }

    @Given("{string} ve {string} bilgileri ile sisteme login olunur")
    public void ve_bilgileri_ile_sisteme_login_olunur(String username, String password) {
        getLoginPage().loginWithGivenInfo(username,password);
    }

    @Given("Open Money Transfer butonuna tiklanir")
    public void open_money_transfer_butonuna_tiklanir() {
        browser.click(Login.openMoneyTransferButton);
    }

    @Given("Account Name alaninin {string} oldugu dogrulanir")
    public void account_name_alaninin_oldugu_dogrulanir(String accountName) {
        Assert.assertEquals(accountName,browser.getText(Home.accountNameLabel),"Beklenen hesap ismi ile sistemde gozuken hesap ismi ayni degil!");
    }

    @Given("{string} hata mesajı ekranda gorunmeli")
    public void hata_mesajı_ekranda_gorunmeli(String message) {
        Assert.assertTrue(browser.elementIsDisplayed(Login.errorMessage),message+" - Hatası görüntülenmedi !");
    }



}
