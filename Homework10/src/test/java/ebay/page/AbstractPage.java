package ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Artur_Shamsutdzinau on 3/22/2017.
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
}
