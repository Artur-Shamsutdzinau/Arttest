package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftsPage extends AbstractPage {
    @FindBy(className = "b-datalist__item__subj__snippet")
    private List<WebElement> emailBodies;

    public DraftsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MailPage openEmailByBody(String body) {
        for (WebElement email : emailBodies) {
            if (email.getText().equals(body)) {
                email.click();
                System.out.println("Navigate to Mail page");
                break;
            }
        }
        return new MailPage(getWebDriver());
    }
}
