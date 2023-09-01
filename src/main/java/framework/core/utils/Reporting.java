package framework.core.utils;

import framework.core.base.DriverInvoker;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Reporting implements ITestListener {
   public static WebDriver driver= DriverInvoker.getDriverInstance();

   ITestResult iTestResult;



    ExtentSparkReporter extentSparkReporter;

    ExtentReports extentReports;

    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
      //  extentSparkReporter= new ExtentSparkReporter(ConstantData.REPORT_PATH + result.getMethod().getMethodName());
        extentReports= new ExtentReports();
        extentTest=extentReports.createTest("Test Started");
    }

    public void mm(FailRetry failRetry){
        failRetry.mmm();
    }

    public static void main(String[] args) {
        Reporting reporting= new Reporting();
        reporting.mm(new FailRetry());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (result.isSuccess()){
            extentTest.log(Status.PASS,"Test Passed");
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot takesScreenshot= ((TakesScreenshot)driver);
       File file= takesScreenshot.getScreenshotAs(OutputType.FILE);
       File file1= new File(ConstantData.SCREENSHOT_PATH + result.getMethod().getMethodName() + ".png");
        try {
            FileUtils.copyFile(file,file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.log(Status.FAIL,"Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP,"Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.attachReporter(extentSparkReporter);
        extentReports.flush();
    }
}


