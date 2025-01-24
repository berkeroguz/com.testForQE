package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initializeDriver(){
        if(driver.get()==null){
            driver.set(new ChromeDriver());
            driver.get().manage().window().fullscreen();
        }
    }

    public static void quitDriver(){
        if(driver.get()!=null)
        {
            getDriver().quit();
            driver.remove();
            Log.info("Driver closed !");
        }
    }

}
