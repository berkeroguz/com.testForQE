package pageobjects.locators;

import org.openqa.selenium.By;

public class TransferMoney {
    public static final By senderAccountComboBox = By.xpath("//div[normalize-space(text())='Sender account']/following::select[1]");
    public static final By receiverAccountComboBox = By.xpath("//div[text()='Receiver account']/following::select[1]");
    public static final By amountTextBox= By.xpath("(//div[normalize-space(text())='Amount'])[2]/following::input[1]");
    public static final By sendButton= By.xpath("//div[text()='Send']");
}
