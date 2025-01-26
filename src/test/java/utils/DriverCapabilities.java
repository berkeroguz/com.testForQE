package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import steps.WebSteps.Hooks;

import java.util.ArrayList;
import java.util.HashMap;

public class DriverCapabilities {

    public WebDriver getChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extension");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }

    public WebDriver getFireFox(){
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("dom.webnotifications.enabled", false); // Bildirimleri devre dışı bırakır
        options.addPreference("extensions.logging.enabled", false);   // Eklenti loglarını kapatır
        options.addPreference("browser.privatebrowsing.autostart", true); // Gizli modda başlatır
        options.addPreference("devtools.console.stdout.content", false); // Konsol çıktısını kapatır
        options.addPreference("security.sandbox.content.level", 5);   // Sandbox seviyesi ayarı
        return new FirefoxDriver(options);
    }

    public ChromeOptions selenoidOpt(){
        ChromeOptions options = new ChromeOptions();
        ChromeOptions opt2 = new ChromeOptions();
        opt2.addArguments("start-maximized"); // open Browser in maximized mode
        opt2.addArguments("disable-infobars"); // disabling infobars
        opt2.addArguments("--disable-extensions"); // disabling extensions
        opt2.addArguments("--disable-gpu"); // applicable to windows os only
        opt2.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        opt2.addArguments("--no-sandbox"); // Bypass OS security model
        options.setCapability(ChromeOptions.CAPABILITY, opt2);
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            //* How to add test badge *//**//*
            put("UI Test", "Test badge...");

            //* How to set session timeout *//**//*
            put("sessionTimeout", "15m");

            //* How to set timezone *//**//*
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            //* How to add "trash" button *//**//*
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            //* How to enable video recording *//**//*
            put("enableVideo", true);

            //put("enableLog",true);

            put("videoName", Hooks.scenarioName.get() + ".mp4");
        }});
        return options;
    }
}
