package testclasses;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.FailRetry;
import utilities.Reporting;

public class ClassOne {
static WebDriver driver= Reporting.driver;
    public static int i=0;



    @Test
    public void id(){

        driver.get("https://www.google.com");
        Assert.assertEquals(
                "dsfdsf","asafhbdshf");

    }
}
