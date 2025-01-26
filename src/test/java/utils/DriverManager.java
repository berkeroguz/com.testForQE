package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initializeDriver(String browser){
        if(driver.get()==null){
            DriverCapabilities driverCapabilities = new DriverCapabilities();

            switch (browser){
                case "chrome" : driver.set(driverCapabilities.getChrome());
                break;
                case "firefox" : driver.set(driverCapabilities.getFireFox());
                break;
                default: driver.set(driverCapabilities.getChrome());
                Log.info("**** Browser tercih edilmediği için default olarak CHROME driver ayağa kalkıyor ****");
            }
            driver.get().manage().window().fullscreen();
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static void quitDriver(){
        if(driver.get()!=null)
        {
            getDriver().quit();
            driver.remove();
            Log.info("Driver kapandi !");
        }
    }

}
