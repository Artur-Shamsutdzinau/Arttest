package framework.page;

import framework.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver webDriver;

    @FindBy(id = "mailbox__login")
    private WebElement loginInput;

    @FindBy(id = "mailbox__password")
    private WebElement passwordInput;

    @FindBy(id = "mailbox__auth__button")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public InboxPage doLogin(User user) {
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
        System.out.println("Navigate to Inbox page");
        return new InboxPage(webDriver);
    }


}
