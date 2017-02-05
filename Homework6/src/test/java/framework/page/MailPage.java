package framework.page;

import framework.model.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MailPage {

    private WebDriver webDriver;
    private Email email;

    @FindBy(xpath = "//textarea[@data-original-name='To']")
    private WebElement emailAddressee;

    @FindBy(xpath = "//input[@class='b-input' and @name='Subject']")
    private WebElement emailSubject;

    @FindBy(xpath = "//iframe[contains(@id,'composeEditor_ifr')]")
    private WebElement frame;

    @FindBy(xpath = "//body[@id='tinymce']")
    private WebElement emailBody;

    @FindBy(xpath = "//div[@data-name='saveDraft']")
    private WebElement saveAsDraft;

    @FindBy(xpath = "//a[@href='/messages/drafts/']")
    private WebElement draftEmailLink;

    @FindBy(xpath = "//div[@data-name='send']")
    private WebElement sendEmailButton;

    public static final By SAVE_AS_DRAFT_DISABLED_LOCATOR = By.xpath("//div[@data-name='saveDraft'][@aria-disabled='disabled']");

    public MailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public MailPage composeEmail(Email email) {
        this.email = email;
        emailAddressee.sendKeys(email.getAddressee());
        emailSubject.sendKeys(email.getSubject());
        webDriver.switchTo().frame(frame);
        emailBody.sendKeys(email.getBody());
        webDriver.switchTo().defaultContent();
        System.out.println("Email was composed");
        return this;
    }

    public DraftsPage saveEmailAsDraft() {
        saveAsDraft.click();
        customWait(SAVE_AS_DRAFT_DISABLED_LOCATOR);
        webDriver.navigate().refresh();
        draftEmailLink.click();
        System.out.println("Navigate to drafts page");
        return new DraftsPage(webDriver);
    }

    public AfterSendingEmailPage sendDraftEmail(Email email) {
        customWait(By.xpath("//div[@data-name='send']"));
        sendEmailButton.click();
        System.out.println("Click send email button");
        return new AfterSendingEmailPage(webDriver);
    }

    private void customWait(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
