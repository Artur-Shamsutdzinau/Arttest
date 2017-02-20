package framework.page;

import framework.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "mailbox__login")
    private WebElement loginInput;

    @FindBy(id = "mailbox__password")
    private WebElement passwordInput;

    @FindBy(id = "mailbox__auth__button")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public InboxPage doLogin(User user) {
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
        System.out.println("Navigate to Inbox page");
        return new InboxPage(getWebDriver());
    }
}
