package pageobjects.locators;

import org.openqa.selenium.By;

public class Login {
    //username =input[placeholder='Username']
    //password = input[placeholder='Password']

    //Login Button = //div[text()='Login']

    // Open MOney Transfer = //div[text()='Open Money Transfer']
    //logout = //div[text()='Logout']
    public static final By usernameTextBox = By.cssSelector("input[placeholder='Username']");
    public static final By passwordTextBox = By.cssSelector("input[placeholder='Password']");
    public static final By loginButton = By.xpath("//div[text()='Login']");
    public static final By openMoneyTransferButton = By.xpath("//div[text()='Open Money Transfer']");
    public static final By logoutButton = By.xpath("//div[text()='Logout']");
    public static final By errorMessage = By.xpath("//div[text()='Username or Password Invalid!']");
}
