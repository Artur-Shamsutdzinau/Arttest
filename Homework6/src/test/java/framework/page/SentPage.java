package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SentPage {
    private WebDriver webDriver;

    public SentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public boolean isElementPresent(By locator) {
        return webDriver.findElements(locator).size() > 0;
    }
}
