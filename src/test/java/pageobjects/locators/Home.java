package pageobjects.locators;

import org.openqa.selenium.By;

public class Home {
    public static final By transferMoneyButton = By.xpath("//div[text()='Transfer money']");
    public static final By addMoneyButton = By.xpath("//div[text()='Add money']");
    public static final By editAccountButton = By.xpath("//div[text()='Edit account']");
    public static final By accountNameLabel = By.xpath("//div[text()='Account name']/following::div[1]");

    public static final By accountBalance = By.xpath("(//div[normalize-space(text())='Amount'])[1]/following::div[1]");
    public static final By transactionsLastSenderLabel = By.xpath("(//div[normalize-space(text())='Sender:'])[1]/following::div[1]");
    public static final By transactionsLastReceiverLabel = By.xpath("(//div[normalize-space(text())='Receiver:'])[1]/following::div[1]");
    public static final By transactionsLastTimeLabel = By.xpath("(//div[normalize-space(text())='Time:'])[1]/following::div[1]");
    public static final By transactionsLastAmountLabel = By.xpath("(//div[normalize-space(text())='Amount:'])[1]/following::div[1]");
}
