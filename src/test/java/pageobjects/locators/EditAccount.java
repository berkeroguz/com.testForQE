package pageobjects.locators;

import org.openqa.selenium.By;

public class EditAccount {
    //account name = //div[normalize-space(text())='Account name']/following::input[1]

    // div update

    public static final By accountNameTextBox = By.xpath("//div[normalize-space(text())='Account name']/following::input[1]");
    public static final By updateButton = By.xpath("//div[text()='Update']");
}
