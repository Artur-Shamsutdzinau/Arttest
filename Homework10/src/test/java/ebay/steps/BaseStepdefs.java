package ebay.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ebay.page.CartPage;
import ebay.page.CategoryPage;
import ebay.page.StartPage;
import ebay.selenium.BaseSelenium;
import framework.patterns.singleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Artur_Shamsutdzinau on 3/22/2017.
 */
public class BaseStepdefs extends BaseSelenium {
    private WebDriver webDriver = WebDriverSingleton.getWebDriverInstance();

    @Given("^I perform search request with parameter \"([^\"]*)\"$")
    public void iPerformSearchRequestWithParameter(String searchRequest) {
        webDriver.get("http://ebay.com");
        new StartPage(webDriver).doSearch(searchRequest);
    }

    @When("^I add product to cart$")
    public void iAddProductToCart() {
        new CategoryPage(webDriver).chooseProduct().addToCart();
    }

    @Then("^'Оформить покупку' button enabled$")
    public void оформитьПокупкуButtonEnabled() {
        Assert.assertTrue(new CartPage(webDriver).isEnabledMakePurchaseButton());
        new CartPage(webDriver).removeProductFromCart();
    }
}
