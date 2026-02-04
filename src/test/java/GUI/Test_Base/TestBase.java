//package GUI.Test_Base;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//
//import java.time.Duration;
//
//public class TestBase {
//
//    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    public static WebDriver getDriver() {
//        if (driver.get() == null) {
//            createDriver();
//        }
//        return driver.get();
//    }
//
//    public static void createDriver() {
//
//        String browser = Global_Constant.BROWSER.toLowerCase();
//
//        WebDriver localDriver;
//
//        switch (browser) {
//
//            case "chrome":
//
//                System.setProperty("webdriver.chrome.driver",
//                        "src/test/resources/drivers/chromedriver.exe");
//
//                localDriver = new ChromeDriver();
//                break;
//
//            case "firefox":
//
//                System.setProperty("webdriver.gecko.driver",
//                        "src/test/resources/drivers/geckodriver.exe");
//
//                localDriver = new FirefoxDriver();
//                break;
//
//
//            default:
//                throw new RuntimeException("Invalid Browser Name in Global_Constant: " + browser);
//        }
//
//        localDriver.manage().window().maximize();
//
//
//        driver.set(localDriver);
//    }
//
//
//
//    public static void quitDriver() {
//        if (driver.get() != null) {
//            driver.get().quit();
//            driver.remove();
//        }
//    }
//}

package GUI.Test_Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class TestBase {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            createDriver();
        }
        return driver.get();
    }

    public static void createDriver() {

        String browser = Global_Constant.BROWSER.toLowerCase();

        WebDriver localDriver;

        switch (browser) {

            case "chrome":

//                System.setProperty("webdriver.chrome.driver",
//                        "src/test/resources/drivers/chromedriver.exe");

                localDriver = new ChromeDriver();
                break;

            case "firefox":

//                System.setProperty("webdriver.gecko.driver",
//                        "src/test/resources/drivers/geckodriver.exe");

                localDriver = new FirefoxDriver();
                break;


            default:
                throw new RuntimeException("Invalid Browser Name in Global_Constant: " + browser);
        }

        localDriver.manage().window().maximize();


        driver.set(localDriver);
    }



    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}



