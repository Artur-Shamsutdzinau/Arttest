package ebay.selenium;

import framework.patterns.singleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by Artur_Shamsutdzinau on 3/22/2017.
 */
public class BaseSelenium {
    public static WebDriver webDriver;

    public static void initWebDriver() {
        webDriver = WebDriverSingleton.getWebDriverInstance();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    public static void close() {
        webDriver.quit();
    }
}
