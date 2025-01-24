package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;

public class WaitFactory {
    private final WebDriverWait wait;

    public WaitFactory(WebDriver driver) {
        wait = new WebDriverWait(driver,(Duration.ofSeconds(20)) );
    }

    public WebElement waitForPresenceOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementVisible(By locator) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitForElementIsClickable(By locator) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public Select waitForElementToBeSelectable(By locator) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        Select select = new Select(element);
        return select;
    }

    public WebElement waitForElementIsTextTypable(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementContainsText(By locator, String partialText) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(ExpectedConditions.textToBePresentInElement(element, partialText));
    }

    public static void hardWait(int second) throws InterruptedException {
        try{
            Thread.sleep(second*1000);
            Log.info(String.valueOf(second) + " HardWait ile bekleniyor");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
