package GUI.ReportSection;

import GUI.Test_Base.TestBase;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ExtentLogger {

    private ExtentLogger() {
        // Utility class – prevent instantiation
    }

    public static void createNode(String message) {
        ExtentTest step =
                ExtentManager.scenario.get().createNode(message);
       ExtentManager.step.set(step);
    }

    public static void pass(String message) {
        ExtentManager.step.get().pass(message);
    }

    public static void fail(String message, Throwable e) {
        ExtentManager.step.get().fail(message);
        throw new RuntimeException(message, e);
    }

    public static void attachScreenshotBase64() {
        String base64 =
                ScreenshotUtil.takeScreenshotBase64(TestBase.getDriver());

        if (base64 != null) {
           ExtentManager.step.get().info(
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(base64)
                            .build()
            );
        } else {
            ExtentManager.step.get()
                    .info("Screenshot not available");
        }
    }

    public static ExtentTest getStep() {
        return ExtentManager.step.get();
    }
}
