package steps.WebSteps;

import io.cucumber.java.en.Given;
import operations.WaitFactory;
import org.testng.Assert;
import pageobjects.locators.AddMoney;
import pageobjects.locators.Home;
import pageobjects.pages.BasePageManager;
import utils.GeneralVariables;
import utils.Log;

public class AddMoneySteps extends BasePageManager {
    @Given("Add Money butonuna tiklanir")
    public void add_money_butonuna_tiklanir() {
        getHomePage().clickToAddMoneyButton();
    }

    @Given("Card Number alanina {string} kart numarasi yazilir")
    public void card_number_alanina_kart_numarasi_yazilir(String kartNo) {
        getAddMoneyPage().sendKeysToCardNumber(kartNo);
    }

    @Given("Card Holder alanina {string} texti yazilir")
    public void card_holder_alanina_texti_yazilir(String cardHolder) {
        getAddMoneyPage().sendKeysToCardHolder(cardHolder);
    }

    @Given("Expiry Date alanina {string} degeri yazilir")
    public void expiry_date_alanina_degeri_yazilir(String expiryDate) {
        getAddMoneyPage().sendKeysToCardExpiryDate(expiryDate);
    }
    @Given("CVV alanina {string} degeri yazilir")
    public void cvv_alanina_degeri_yazilir(String cvv) {
        getAddMoneyPage().sendKeysToCardCVV(cvv);
    }
    @Given("Add butonuna tiklanir")
    public void add_butonuna_tiklanir() {
        getAddMoneyPage().clickToaddButton();
    }

    @Given("Transactions ekraninda para yatirma isleminin goruntulendigi dogrulanir")
    public void transactions_ekranindaki_para_yatirma() {
        getAddMoneyPage().verifyTransactions();
    }
}
