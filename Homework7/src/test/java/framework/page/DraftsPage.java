package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DraftsPage {
    private WebDriver webDriver;

    @FindBy(className = "b-datalist__item__subj__snippet")
    private List<WebElement> emailBodies;

    public DraftsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);

    }

    public MailPage openEmailByBody(String body) {
        for (WebElement email : emailBodies) {
            if (email.getText().equals(body)) {
                email.click();
                System.out.println("Navigate to Mail page");
                break;
            }
        }
        return new MailPage(webDriver);
    }

    public boolean isElementPresent(By locator) {
        return webDriver.findElements(locator).size() > 0;
    }


}
