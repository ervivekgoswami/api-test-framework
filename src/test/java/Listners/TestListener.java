package Listners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentManager;

public class TestListener implements ITestListener {
        ExtentReports extent = ExtentManager.createExtentReports();
        ExtentTest test;

        @Override
        public void onTestStart(ITestResult result) {
            test = extent.createTest(result.getName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            test.log(Status.PASS, "Test Passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            test.log(Status.SKIP, "Test Skipped");
        }

        @Override
        public void onFinish(ITestContext context) {
            extent.flush();
        }
}
