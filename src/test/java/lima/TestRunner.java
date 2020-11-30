package lima;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/lima/Login.feature",
        glue = "lima",
        plugin = { "pretty", "json:target/cucumber-reports/cucumber.json","io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "html:target/cucumber-html-report","junit:target/cucumber-reports/cucumber.xml"}
)
public class TestRunner {

}