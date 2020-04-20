package lima.steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lima.base.BasePage;
import lima.page.LoginPage;
import lima.util.DriverUtil;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;

public class BaseStep {

    @Before(order = Integer.MIN_VALUE)
    public void setup() {
        DriverUtil.setUp();

        Allure.addAttachment("Browser is up...", new ByteArrayInputStream(((TakesScreenshot) DriverUtil.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(WebDriver webDriver) {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            Allure.addAttachment("Scenario is failed...", new ByteArrayInputStream(((TakesScreenshot) DriverUtil.getDriver()).getScreenshotAs(OutputType.BYTES)));
            Allure.addAttachment("Scenario error: ", scenario.getName());
        }
        DriverUtil.closeDriver();
    }


}
