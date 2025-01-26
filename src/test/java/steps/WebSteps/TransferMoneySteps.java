package steps.WebSteps;

import io.cucumber.java.en.Given;
import operations.WaitFactory;
import org.testng.Assert;
import pageobjects.locators.Home;
import pageobjects.locators.Login;
import pageobjects.locators.TransferMoney;
import pageobjects.pages.BasePageManager;
import utils.GeneralVariables;
import utils.Log;

public class TransferMoneySteps extends BasePageManager {

    @Given("Transfer Money Butonuna tiklanir")
    public void transfer_money_butonuna_tiklanir() {
        browser.click(Home.transferMoneyButton);
    }

    @Given("Receiver account olarak {string} secilir")
    public void receiver_account_olarak_secilir(String value) {
        browser.selectOptionByValue(TransferMoney.receiverAccountComboBox,value);
        GeneralVariables.saveValue("receiverAccount",value);
        browser.switchToAlertandClickOKButton();
    }

    @Given("Amount olarak {string} degeri girilir")
    public void amount_olarak_degeri_girilir(String amount) {
        browser.sendKeys(TransferMoney.amountTextBox,amount);
        GeneralVariables.saveValue("amount",amount);
    }
    @Given("Send butonuna tiklanir")
    public void send_butonuna_tiklanir() {
        browser.click(TransferMoney.sendButton);
    }
    @Given("Transactions ekraninda yapilan islemin goruntulendigi dogrulanir")
    public void transactions_ekraninda_yapilan_islemin_goruntulendigi_dogrulanir() {
        try {
            WaitFactory.hardWait(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(browser.getText(Home.transactionsLastReceiverLabel),
                GeneralVariables.getValue("receiverAccount")," Islem yapilan son hesap goruntulenemedi !");
    }


}
