package lima;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/lima/",
        glue = "lima",
        plugin = { "pretty", "json:target/cucumber-report.json","io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "html:target/html/"}
)
public class TestRunner {

}