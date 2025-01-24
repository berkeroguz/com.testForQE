package pageobjects.pages;

import operations.Browser;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class BasePageManager {
    protected final Browser browser;
    public BasePageManager(){
        this.browser=new Browser(DriverManager.getDriver());
    }

    private AddMoneyPage addMoneyPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private TransferMoneyPage transferMoneyPage;
    private EditAccountPage editAccountPage;

    public AddMoneyPage getAddMoneyPage() {
        if(addMoneyPage==null){
            addMoneyPage= new AddMoneyPage();
        }
        return addMoneyPage;
    }

    public HomePage getHomePage() {
        if(homePage==null){
            homePage=new HomePage();
        }
        return homePage;
    }

    public LoginPage getLoginPage() {
        if(loginPage==null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public TransferMoneyPage getTransferMoneyPage() {
        if(transferMoneyPage==null){
            transferMoneyPage = new TransferMoneyPage();
        }
        return transferMoneyPage;
    }

    public EditAccountPage getEditAccountPage() {
        if(editAccountPage==null){
            editAccountPage = new EditAccountPage();
        }
        return editAccountPage;
    }
}
