package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
}
