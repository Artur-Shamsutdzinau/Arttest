package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Artur_Shamsutdzinau on 1/25/2017.
 */
public class BaseTest {

    protected static WebDriver driver;


    @BeforeClass(groups = "config")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void login(String url, String login, String password) {
        driver.get(url);
        driver.findElement(Mailru.INPUT_LOGIN_LOCATOR).sendKeys(login);
        driver.findElement(Mailru.INPUT_PASSWORD_LOCATOR).sendKeys(password);
        driver.findElement(Mailru.BUTTON_SUBMIT_LOCATOR).click();
    }

    public static void createDraftEmail(String addressee, String subject, String emailBody){
        driver.findElement(Mailru.NEW_MAIL__BUTTON_LOCATOR).click();
        driver.findElement(Mailru.ADDRESSEE_LOCATOR).sendKeys(addressee);
        driver.findElement(Mailru.SUBJECT_LOCATOR).sendKeys(subject);
        String bodyIframeId = driver.findElement(By.xpath("//iframe[contains(@id,'composeEditor_ifr')]"))
                .getAttribute("id");
        driver.switchTo().frame(bodyIframeId);
        driver.findElement(Mailru.EMAIL_BODY_LOCATOR).sendKeys(emailBody);
        driver.switchTo().defaultContent();
        driver.findElement(Mailru.SAVE_AS_DRAFT_LOCATOR).click();
        customWait(Mailru.SAVE_AS_DRAFT_DISABLED_LOCATOR);
    }

    public static void customWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }



    public static boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
