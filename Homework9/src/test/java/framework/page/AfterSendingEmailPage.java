package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterSendingEmailPage extends AbstractPage {
    private final String CURRENT_URL = "sendmsgok";

    @FindBy(xpath = "//a[@href='/messages/sent/']")
    private WebElement sentEmailsLink;

    public AfterSendingEmailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SentPage goToSentEmailsPage() {
        customWait(CURRENT_URL);
        sentEmailsLink.click();
        System.out.println("Navigate to Sent page");
        return new SentPage(getWebDriver());
    }
}
