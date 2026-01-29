package GUI.StepDefination;

import GUI.ReportSection.ExtentManager;
import GUI.Test_Base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Hooks extends TestBase {

    private static ExtentReports extent;

    // One feature node per feature (parallel-safe)
    private static Map<String, ExtentTest> featureMap = new ConcurrentHashMap<>();

    @Before
    public void beforeScenario(Scenario scenario) throws IOException {

        String featureName = Paths.get(scenario.getUri())
                .getFileName()
                .toString()
                .replace(".feature", "");

        // Initialize Extent lazily
        if (extent == null) {
            extent = ExtentManager.getExtent(featureName);
        }

        // Create feature node only once
        ExtentTest featureNode = featureMap.computeIfAbsent(
                featureName,
                name -> extent.createTest(name)
        );

        ExtentTest scenarioNode =
                featureNode.createNode(scenario.getName());

        ExtentManager.feature.set(featureNode);
        ExtentManager.scenario.set(scenarioNode);
    }

    @After
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            ExtentManager.scenario.get().fail("Scenario Failed ❌");
        } else {
            ExtentManager.scenario.get().pass("Scenario Passed ✅");
        }
    }

    @AfterAll
    public static void afterAll() {
        if (extent != null) {
            extent.flush();
        }
    }
}
