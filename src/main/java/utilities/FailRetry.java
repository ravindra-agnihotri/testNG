package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailRetry implements IRetryAnalyzer {

    int maxRetryCount=3;
    int retryCount=0;
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxRetryCount)
        {
            retryCount++;
            System.out.println("Retrying Test method : "+iTestResult.getName() + " for " + retryCount +" times. ");
            return true;
        }
        return false;
    }

}
