//package listeners;
//
//import com.aventstack.extentreports.*;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.*;
//
//public class ExtentTestListener implements ITestListener {
//
//    private static ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//
//    @Override
//    public void onStart(ITestContext context) {
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
//        htmlReporter.config().setDocumentTitle("API Test Report");
//        htmlReporter.config().setReportName("JSONPlaceholder API Tests");
//        htmlReporter.config().setTheme(Theme.STANDARD);
//
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//        extent.setSystemInfo("Tester", "Your Name");
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
//        test.set(extentTest);
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.get().pass("Test Passed");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.get().fail(result.getThrowable());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        test.get().skip(result.getThrowable());
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        extent.flush();
//    }
//}
