package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AfterSendingEmailPage {
    private WebDriver webDriver;
    private final String CURRENT_URL = "sendmsgok";

    @FindBy(xpath = "//a[@href='/messages/sent/']")
    private WebElement sentEmailsLink;

    public AfterSendingEmailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public SentPage goToSentEmailsPage() {
        customWait();
        sentEmailsLink.click();
        System.out.println("Navigate to Sent page");
        return new SentPage(webDriver);
    }

    private void customWait() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.urlContains(CURRENT_URL));
    }
}
