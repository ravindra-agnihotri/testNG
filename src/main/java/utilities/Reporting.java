package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Reporting implements ITestListener {
    ExtentReports extentReports;
    ExtentTest extentTest;
    ExtentSparkReporter extentSparkReporter;
    @Override
    public void onTestStart(ITestResult result) {
        String reportPath="E:\\projects\\testng.project\\src\\main\\resources\\aa.html";
        extentSparkReporter= new ExtentSparkReporter(reportPath);
        extentReports= new ExtentReports();

        extentTest= extentReports.createTest("one try");



    }


    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,"pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        extentTest.log(Status.INFO,"test started");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentTest.log(Status.INFO,"test finished");
        extentReports.attachReporter(extentSparkReporter);
        extentReports.flush();


    }
}


