package ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Artur_Shamsutdzinau on 3/22/2017.
 */
public class ProductPage extends AbstractPage {
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "isCartBtn_btn")
    private WebElement addToCartButton;

    public CartPage addToCart() {
        addToCartButton.click();
        return new CartPage(getWebDriver());
    }

}
