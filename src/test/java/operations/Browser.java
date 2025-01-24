package operations;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utils.Log;

public class Browser {

    private WebDriver driver;
    private WaitFactory waitFactory;
    public Browser(WebDriver driver){
        this.driver=driver;
        waitFactory = new WaitFactory(driver);

    }
    public WebElement findElement (By locator) {
        try {
            WebElement element = waitFactory.waitForPresenceOfElementLocated(locator);
            return element;
        } catch (NoSuchElementException e) {
            Log.info("Element beklendi ancak bulunamadı !");
            throw e;
        }
    }

    public Alert switchToAlertandClickOKButton(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return alert;
    }

    public boolean elementIsDisplayed (By locator) {
        return findElement(locator).isDisplayed();
    }

    public Browser click(By locator) {
        try {
            WebElement element = waitFactory.waitForElementIsClickable(locator);
            element.click();
            return this;
        } catch (StaleElementReferenceException exception) {
            Log.error("Elemen DOM uzernde bulunamadı");
            throw exception;
        } catch (ElementNotInteractableException exception) {
            Log.error("Element Dom uzerinde ancak gorunur halde degil");
            throw exception;
        }
    }
    public Browser clickByJSExecutor(By locator) {
        try {
            WebElement element = waitFactory.waitForPresenceOfElementLocated(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            return this;
        } catch (JavascriptException exception) {
            Log.error("Java script ile tiklanamadi ");
            throw exception;
        }
    }
    public void navigateTo(String url){
        driver.get(url);
        Log.info(url+ " adresine gidildi");
    }

    public Browser sendKeys(By locator, String keysToSend) {
        try {
            WebElement element = waitFactory.waitForElementIsTextTypable(locator);
            element.sendKeys(keysToSend);
            Log.info(keysToSend + " texti ilgili yere yazildi.");
            return this;
        } catch (WebDriverException exception) {
            Log.error("Text elemente yazilamadi ");
            throw exception;
        }
    }

    public Browser clear(By locator) {
        try {
            WebElement element = waitFactory.waitForElementVisible(locator);
            element.clear();
            return this;
        } catch (WebDriverException exception) {
            Log.error("Ilgili textbox temizlenirken bir hata ile karsilasildi ");
            throw exception;
        }
    }

    public String getText(By locator) {
        try {
            WebElement element = waitFactory.waitForElementVisible(locator);
            return element.getText();
        } catch (WebDriverException exception) {
            Log.error("Elementin texti alinirkan bir hata ile karsilasildi" );
            throw exception;
        }
    }

    public Browser selectOptionByValue(By locator, String value) {
        Select dropdown = waitFactory.waitForElementToBeSelectable(locator);
        dropdown.selectByVisibleText(value);
        Log.info("ComboBoxtan "+value + "değeri seçildi !");
        return this;
    }

    public void scrollToBottom(){

    }
}
