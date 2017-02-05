package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver webDriver;

    private static final String MAILRU_URL = "http://mail.ru";
    private static final String WEBDRIVER_PATH = "./src/test/resources/chromedriver.exe";

    @BeforeClass
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", WEBDRIVER_PATH);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(MAILRU_URL);
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
}
