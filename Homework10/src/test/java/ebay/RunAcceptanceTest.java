package ebay;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import ebay.selenium.BaseSelenium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by Artur_Shamsutdzinau on 3/22/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        }
)
public class RunAcceptanceTest {

    @BeforeClass
    public static void initSelenium() {
        BaseSelenium.initWebDriver();
   }

    @AfterClass
    public static void closeSelenium() {
        BaseSelenium.close();
    }
}
