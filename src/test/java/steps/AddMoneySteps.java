package steps;

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
        browser.click(Home.addMoneyButton);
        Log.info("Add Money Butonuna tiklandi");
    }

    @Given("Card Number alanina {string} kart numarasi yazilir")
    public void card_number_alanina_kart_numarasi_yazilir(String kartNo) {
        browser.sendKeys(AddMoney.cardNumberTextBox,kartNo);
    }

    @Given("Card Holder alanina {string} texti yazilir")
    public void card_holder_alanina_texti_yazilir(String cardHolder) {
        browser.sendKeys(AddMoney.cardHolderTextBox, cardHolder);
        GeneralVariables.saveValue("cardHolder",cardHolder);
    }
    @Given("Expiry Date alanina {string} degeri yazilir")
    public void expiry_date_alanina_degeri_yazilir(String expiryDate) {
        browser.sendKeys(AddMoney.expiryDateTextBox,expiryDate);
    }
    @Given("CVV alanina {string} degeri yazilir")
    public void cvv_alanina_degeri_yazilir(String cvv) {
        browser.sendKeys(AddMoney.cvvTextBox,cvv);
    }
    @Given("Add butonuna tiklanir")
    public void add_butonuna_tiklanir() {
        browser.click(AddMoney.addButton);
        Log.info("Add butonuna tiklandi");
    }

    @Given("Transactions ekraninda para yatirma isleminin goruntulendigi dogrulanir")
    public void transactions_ekranindaki_para_yatirma() {
        try {
            WaitFactory.hardWait(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(browser.getText(Home.transactionsLastSenderLabel),
                GeneralVariables.getValue("cardHolder")," Islem yapilan son hesap goruntulenemedi !");
    }
}
