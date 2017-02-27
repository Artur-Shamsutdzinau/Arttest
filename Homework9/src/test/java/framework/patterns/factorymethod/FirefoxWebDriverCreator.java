package framework.patterns.factorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxWebDriverCreator extends WebDriverCreator{
    private WebDriver webDriver;

    public WebDriver factoryMethod() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/driver/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        webDriver = new FirefoxDriver(capabilities);
        return webDriver;
    }
}
