package GUI.ReportSection;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {

    public static String takeScreenshotBase64(WebDriver driver) {

        if (driver == null) {
            System.out.println("❌ Driver is NULL. Screenshot not taken.");
            return null;
        }

        try {
            return ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            System.out.println("❌ Screenshot failed: " + e.getMessage());
            return null;
        }
    }
}

