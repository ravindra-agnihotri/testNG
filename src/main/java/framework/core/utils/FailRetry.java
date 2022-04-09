package framework.core.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailRetry implements IRetryAnalyzer {

    int maxCount=3;
    int startCount=0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        while (maxCount>startCount) {
            if (iTestResult.isSuccess()) {
                return true;
            }
            startCount++;
        }
        return false;
    }

    public FailRetry mmm(){
        System.out.println("dbvhjdfgbfdg");
        return new FailRetry();
    }
}
