package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='b-toolbar__btn js-shortcut']")
    private WebElement createNewEmailButton;

    @FindBy(xpath = "//i[@id='PH_user-email' and contains(text(),'arttest123@mail.ru')]")
    private WebElement userMail;

    public InboxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MailPage goToNewEmailPage() {
        createNewEmailButton.click();
        System.out.println("Navigate to Mail page");
        return new MailPage(getWebDriver());
    }

    public boolean isDisplayed() {
        return userMail.isDisplayed();
    }
}
