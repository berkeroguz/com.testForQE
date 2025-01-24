package pageobjects.locators;

import org.openqa.selenium.By;

public class AddMoney {
    public static final By cardNumberTextBox= By.xpath("//div[normalize-space(text())='Card number']/following::input[1]");
    public static final By cardHolderTextBox= By.xpath("//div[normalize-space(text())='Card holder']/following::input[1]");
    public static final By expiryDateTextBox= By.xpath("//div[normalize-space(text())='Expiry date']/following::input[1]");
    public static final By cvvTextBox= By.xpath("//div[normalize-space(text())='CVV']/following::input[1]");
    public static final By amountTextBox= By.xpath("(//div[normalize-space(text())='Amount'])[2]/following::input[1]");
    public static final By addButton= By.xpath("//div[text()='Add']");
}
