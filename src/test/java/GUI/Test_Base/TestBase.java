package GUI.Test_Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver() {
        if (driver.get() == null) {
            setup();
        }
        return driver.get();
    }

    public static void setup() {

        if (Global_Constant.BROWSER.equalsIgnoreCase("chrome")) {

            if (driver.get() == null) {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                driver.get().get(Global_Constant.URL);
                driver.get().manage().window().maximize();
            }

        } else if (Global_Constant.BROWSER.equalsIgnoreCase("firefox")) {

            if (driver.get() == null) {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                driver.get().get(Global_Constant.URL);
                driver.get().manage().window().maximize();
            }
        }
    }
        public static void quitdriver () {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
            }
        }
    }


