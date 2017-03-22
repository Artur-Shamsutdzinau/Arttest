package framework.patterns.singleton;

import framework.patterns.decorator.CustomWebDriverDecorator;
import framework.patterns.factorymethod.ChromeWebDriverCreator;
import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {
    private static WebDriver webDriver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance() {
        if (webDriver == null) {
            webDriver = new ChromeWebDriverCreator().factoryMethod();
            webDriver = new CustomWebDriverDecorator(webDriver);
        }
        return webDriver;
    }
}
