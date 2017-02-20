package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Artur_Shamsutdzinau on 2/16/2017.
 */
public abstract class AbstractPage {
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void customWait(By locator) {
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void customWait(final String url) {
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.urlContains(url));
    }

    public boolean isElementPresent(By locator) {
        return webDriver.findElements(locator).size() > 0;
    }
}
