package GUI.TestListener;

import GUI.Test_Base.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST PASSED : " + result.getName());
        TestBase.quitDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED : " + result.getName());
        TestBase.quitDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED : " + result.getName());
        TestBase.quitDriver();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("ALL TESTS FINISHED");
    }
}
