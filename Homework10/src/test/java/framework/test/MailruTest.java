package framework.test;

import framework.model.Email;
import framework.model.User;
import framework.page.DraftsPage;
import framework.page.InboxPage;
import framework.page.LoginPage;
import framework.page.SentPage;
import framework.patterns.singleton.WebDriverSingleton;
import framework.util.MailFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MailruTest extends BaseTest {
    private static final String LOGIN = "arttest123";
    private static final String PASSWORD = "123blablabla";
    private Email email;
    private User user;
    private WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        user = new User.UserBuilder(LOGIN,PASSWORD)
            .build();

        email = MailFactory.getNewEmail();
        webDriver = WebDriverSingleton.getWebDriverInstance();
    }

    @Test(testName = "login", description = "Successful login verification")
    public void login() {
        InboxPage inboxPage = new LoginPage(webDriver).doLogin(user);
        Assert.assertTrue(inboxPage.isDisplayed());
        System.out.println("User is successfully logged in");
    }

    @Test(dependsOnMethods = "login", description = "Draft Email Creation verification")
    public void createDraftEmail() {
        DraftsPage draftsPage = new InboxPage(webDriver).goToNewEmailPage().composeEmail(email).saveEmailAsDraft();
        Assert.assertTrue(draftsPage.isElementPresent(By.xpath("//*[text()='" + email.getBody() + "']")));
        System.out.println("Email is present in drafts");
    }

    @Test(dependsOnMethods = "createDraftEmail", description = "Sending draft Email verification")
    public void sendDraftEmail() {
        SentPage sentPage = new DraftsPage(webDriver).openEmailByBody(email.getBody()).sendDraftEmail(email).goToSentEmailsPage();
        Assert.assertTrue(sentPage.isElementPresent(By.xpath("//*[text()='" + email.getBody() + "']")));
        System.out.println("Email is present in sent");
    }
}
