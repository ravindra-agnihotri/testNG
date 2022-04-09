package framework.core.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInvoker {

   public static WebDriver driver;

   private static DriverInvoker instance= new DriverInvoker();

    private DriverInvoker() {
    }

    public static WebDriver getDriverInstance(){
        if (driver==null){
            return instance.getDriver();
        }else
            return driver;
    }

    public  WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
        return driver;
    }
}
