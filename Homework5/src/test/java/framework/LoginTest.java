package framework;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(priority = 2, description = "Login with valid credentials")
    public void testLogin_valid() {
        login(Mailru.MAILRU_START_PAGE, Mailru.LOGIN, Mailru.PASSWORD);
        String actualResult = driver.findElement(Mailru.MAILRU_VALID_LOGIN).getText();
        Assert.assertEquals(actualResult, Mailru.FULL_USER_NAME);
    }

    @Test(priority = 1, description = "Login with invalid credentials")
    public void testLogin_invalid() {
        login(Mailru.MAILRU_START_PAGE, "InvalidLogin", "InvalidPassword");
        Assert.assertTrue(isElementPresent(Mailru.MAILRU_INVALID_LOGIN));
    }

}
