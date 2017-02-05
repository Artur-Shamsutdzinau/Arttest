package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//a[@class='b-toolbar__btn js-shortcut']")
    private WebElement createNewEmailButton;

    @FindBy(xpath = "//i[@id='PH_user-email' and contains(text(),'arttest123@mail.ru')]")
    private WebElement userMail;

    public InboxPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public MailPage goToNewEmailPage() {
        createNewEmailButton.click();
        System.out.println("Navigate to Mail page");
        return new MailPage(webDriver);
    }

    public boolean isDisplayed() {
        return userMail.isDisplayed();
    }
}
