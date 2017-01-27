package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SendEmailTest extends BaseTest {

    @BeforeClass(description = "Login to Mailbox")
    public void loginToMailbox() {
        login(Mailru.MAILRU_START_PAGE, Mailru.LOGIN, Mailru.PASSWORD);
    }

    @Test(description = "Draft Email Sending")
    public void testSendEmail() throws InterruptedException {
        Long currentTime = System.currentTimeMillis();
        String emailBody = Mailru.EMAIL_BODY + currentTime.toString();
        createDraftEmail(Mailru.ADDRESSEE, Mailru.SUBJECT, emailBody);
        driver.findElement(Mailru.DRAFT_MAILS__BUTTON_LOCATOR).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[text()='"+ emailBody+ "']")).click();
        customWait(Mailru.SEND_BUTTON_LOCATOR);
        driver.findElement(Mailru.SEND_BUTTON_LOCATOR).click();
        driver.findElement(Mailru.SENT_MAILS__BUTTON_LOCATOR).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='" + emailBody + "']")));
    }
}


