package pageobjects.pages;

import operations.Browser;
import org.testng.Assert;
import pageobjects.locators.AddMoney;
import pageobjects.locators.Home;
import utils.GeneralVariables;
import utils.Log;

public class AddMoneyPage extends BasePageManager{

    public void sendKeysToCardNumber(String kartNo){
        browser.sendKeys(AddMoney.cardNumberTextBox,kartNo);
        Log.info(kartNo + " değeri CardNumber alanina yazildi !");
    }
    public void sendKeysToCardHolder(String cardHolder){
        browser.sendKeys(AddMoney.cardNumberTextBox,cardHolder);
        GeneralVariables.saveValue("cardHolder",cardHolder);
        Log.info(cardHolder + " değeri Cardholder alanina yazildi !");
    }

    public void sendKeysToCardExpiryDate(String expiryDate){
        browser.sendKeys(AddMoney.expiryDateTextBox,expiryDate);
        Log.info(expiryDate + " değeri ExpiryDate alanina yazildi !");
    }

    public void sendKeysToCardCVV(String cvv){
        browser.sendKeys(AddMoney.cvvTextBox,cvv);
        Log.info(cvv + "  değeri CVV alanina yazildi !");
    }

    public void clickToaddButton(){
        browser.click(AddMoney.addButton);
        Log.info("Add butonuna tiklandi");
    }

    public void verifyTransactions(){
        browser.hardWait(2);
        Assert.assertEquals(browser.getText(Home.transactionsLastSenderLabel),
                GeneralVariables.getValue("cardHolder"),
                " Islem yapilan son hesap goruntulenemedi !");
    }

}
