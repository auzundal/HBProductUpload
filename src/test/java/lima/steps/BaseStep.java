package lima.steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import lima.util.DriverUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;

public class BaseStep {

    @Before(order = Integer.MIN_VALUE)
    public void setup() {
        DriverUtil.setUp();
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
