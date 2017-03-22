package framework.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class JSHighlighter {
    public static void highlightElement(WebElement element, String color, WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        String background = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) webDriver);
        js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
        js.executeScript("arguments[0].style.backgroundColor='" + background + "'", element);
    }
}
