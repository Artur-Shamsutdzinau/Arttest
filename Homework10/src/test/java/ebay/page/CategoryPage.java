package ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Artur_Shamsutdzinau on 3/22/2017.
 */
public class CategoryPage extends AbstractPage {
    public CategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//ul[@id='ListViewInner']//li[1]//h3[@class='lvtitle']/a")
    private WebElement linkFirstResultOfSearch;

    public ProductPage chooseProduct() {
        linkFirstResultOfSearch.click();
        return new ProductPage(getWebDriver());
    }
}
