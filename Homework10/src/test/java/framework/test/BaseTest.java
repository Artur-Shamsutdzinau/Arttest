package framework.test;

import framework.patterns.singleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    private WebDriver webDriver;
    private static final String MAILRU_URL = "http://mail.ru";

    @BeforeClass
    public void initWebDriver() {
        webDriver = WebDriverSingleton.getWebDriverInstance();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(MAILRU_URL);
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
}
