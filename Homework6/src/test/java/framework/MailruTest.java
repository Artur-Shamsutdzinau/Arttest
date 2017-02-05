package framework;

import framework.model.Email;
import framework.model.User;
import framework.page.DraftsPage;
import framework.page.InboxPage;
import framework.page.LoginPage;
import framework.page.SentPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MailruTest extends BaseTest {
    private static final String LOGIN = "arttest123";
    private static final String PASSWORD = "123blablabla";
    private static final String EMAIL_ADDRESSEE = "Artur_Shamsutdzinau@epam.com";
    private static final String EMAIL_SUBJECT = "TestSubject";
    private static final String EMAIL_BODY = "TestBody";

    private Email email;
    private User user;

    @BeforeClass
    public void setUp() {
        user = new User(LOGIN, PASSWORD);
        Long currentTime = System.currentTimeMillis();
        String emailBody = EMAIL_BODY + currentTime.toString();
        email = new Email(EMAIL_ADDRESSEE, EMAIL_SUBJECT, emailBody);
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
