package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
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
                        Log.info(" *********  "+browser + " *******  ayağa kalkıyor .. !");
                        break;
                    case "firefox" : driver.set(driverCapabilities.getFireFox());
                        Log.info(" *********  "+browser + " *******  ayağa kalkıyor .. !");
                        break;
                    case "remote" :
                        try{
                            driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), driverCapabilities.selenoidOpt()));
                            Log.info(" **************  SELENOID - CHROME ile testler koşuyor ************");
                        }catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    default: driver.set(driverCapabilities.getChrome());
                        Log.info("**** Browser tercih edilmediği için default olarak CHROME driver ayağa kalkıyor ****");
            }

            driver.get().manage().window().maximize();
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
