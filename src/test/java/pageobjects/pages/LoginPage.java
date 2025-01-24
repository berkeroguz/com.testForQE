package pageobjects.pages;

import operations.Browser;
import pageobjects.locators.Login;
import utils.Log;

public class LoginPage extends BasePageManager{

    public void loginWithGivenInfo(String username, String password){
        browser.sendKeys(Login.usernameTextBox,username);
        Log.info(username + " username textbox'ına yazildi");
        browser.sendKeys(Login.passwordTextBox,password);
        Log.info(password + " password textbox'ına yazildi");
        browser.click(Login.loginButton);
        Log.info("Login butonuna tiklandi");
    }
}
