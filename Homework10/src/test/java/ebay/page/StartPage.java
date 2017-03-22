package ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Artur_Shamsutdzinau on 3/22/2017.
 */
public class StartPage extends AbstractPage {

    public StartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "gh-ac")
    private WebElement searchInput;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    public CategoryPage doSearch(String searchRequest) {
        searchInput.sendKeys(searchRequest);
        searchButton.click();
        return new CategoryPage(getWebDriver());
    }
}
