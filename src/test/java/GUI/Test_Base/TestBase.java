package GUI.Test_Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Object LOCK = new Object();
    private static boolean wdmInit = false;

    static {
        // 🚨 CRITICAL FIX FOR "public" NumberFormatException
        System.setProperty("wdm.chromeDriverCfT", "false");
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            createDriver();
        }
        return driver.get();
    }

    public static void createDriver() {
        synchronized (LOCK) {

            if (!wdmInit) {

                WebDriverManager.chromedriver()
                        .avoidBrowserDetection()
                        .setup();

                WebDriverManager.firefoxdriver()
                        .avoidBrowserDetection()
                        .setup();

                wdmInit = true;
            }
        }
    }




    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
