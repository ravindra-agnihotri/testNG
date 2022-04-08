package utilities;

import base.BaseClass;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Reporting implements ITestListener {
   public static WebDriver driver= BaseClass.getDriver();
    String reportPath="E:\\projects\\testNG\\src\\main\\resources\\xyz.html";
    ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter(reportPath);
    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        extentReports= new ExtentReports();
        extentTest=extentReports.createTest("Madam logo ka test");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (result.isSuccess()){
            extentTest.log(Status.PASS,"your testcase is pass");
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot takesScreenshot= ((TakesScreenshot)driver);
        System.out.println("aalofdgfdg");
       File file= takesScreenshot.getScreenshotAs(OutputType.FILE);
       File file1= new File("E:\\projects\\testNG\\src\\main\\resources\\aaa.png");
        try {
            FileUtils.copyFile(file,file1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        extentTest.log(Status.FAIL,"your testcase is failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP,"your testcase is skipped");
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


