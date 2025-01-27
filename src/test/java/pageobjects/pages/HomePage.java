package pageobjects.pages;

import operations.Browser;
import pageobjects.locators.Home;
import utils.Log;

public class HomePage extends BasePageManager{

    public void clickToAddMoneyButton(){
        browser.click(Home.addMoneyButton);
        Log.info("Add Money Butonuna tiklandi");
    }
}
