package GUI.ReportSection;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    // Thread-safe nodes
    public static ThreadLocal<ExtentTest> feature = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> scenario = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> step = new ThreadLocal<>();

    private ExtentManager() {
        // prevent instantiation
    }

    /**
     * @param featureName name of the feature (without .feature)
     */
    public static ExtentReports getExtent(String featureName) throws IOException {

        if (extent == null) {

            // Timestamp (optional but recommended)
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                    .format(new Date());

            // Feature-based folder
            String reportFolderPath =
                    System.getProperty("user.dir")
                            + "/ExtentReports/"
                            + featureName
                            + "/Run_" + timestamp;

            new File(reportFolderPath).mkdirs();

            String reportPath = reportFolderPath + "/ExtentReport.html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            // Load custom CSS from resources
            InputStream is = ExtentManager.class
                    .getClassLoader()
                    .getResourceAsStream("extent-custom.css");

            if (is != null) {
                String css = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                spark.config().setCss(css);
            }

            // Theme
            spark.config().setTheme(Theme.STANDARD);

            // Titles
            spark.config().setReportName(featureName + " Automation Report");
            spark.config().setDocumentTitle("Execution Dashboard");

            // Views
            spark.viewConfigurer().viewOrder()
                    .as(new ViewName[]{
                            ViewName.TEST,
                            ViewName.DASHBOARD,
                            ViewName.CATEGORY,
                            ViewName.EXCEPTION
                    })
                    .apply();

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
            extent = null; // important for next feature
        }
    }
}
