package framework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DraftEmailTest extends BaseTest {

    @BeforeClass(description = "Login to Mailbox")
    public void loginToMailbox() {
        login(Mailru.MAILRU_START_PAGE, Mailru.LOGIN, Mailru.PASSWORD);
    }

    @Test(description = "Draft email creating")
    public void testCreateDraftEmail() throws InterruptedException {
        Long currentTime = System.currentTimeMillis();
        String emailBody = Mailru.EMAIL_BODY + currentTime.toString();
        createDraftEmail(Mailru.ADDRESSEE, Mailru.SUBJECT, emailBody);
        driver.findElement(Mailru.DRAFT_MAILS__BUTTON_LOCATOR).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='" + emailBody + "']")), emailBody);
    }
}
