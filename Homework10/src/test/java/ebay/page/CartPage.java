package ebay.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Artur_Shamsutdzinau on 3/22/2017.
 */
public class CartPage extends AbstractPage {
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "ptcBtnRight")
    private WebElement makePurchaseButton;

    /*@FindBy(xpath = "//a[@disabled = 'disabled']")
    private WebElement disabledMakePurchaseButton;*/

    @FindBy(xpath = "//a[@class='action actionLink']")
    private WebElement removeProductFromCartButton;

    public boolean isEnabledMakePurchaseButton() {
        return makePurchaseButton.getAttribute("disabled") == null;
    }

    public CartPage removeProductFromCart() {
        removeProductFromCartButton.click();
        return new CartPage(getWebDriver());
    }

}
