package framework.patterns.factorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeWebDriverCreator extends WebDriverCreator {
    private WebDriver webDriver;

    public WebDriver factoryMethod() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        webDriver = new ChromeDriver(capabilities);
        return webDriver;
    }
}

