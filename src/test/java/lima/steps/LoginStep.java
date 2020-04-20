package lima.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureConstants;
import io.qameta.allure.Step;
import lima.page.HomePage;
import lima.page.LoginPage;
import lima.util.DriverUtil;
import org.junit.Assert;

import static lima.steps.BaseStep.saveScreenshot;
import static org.junit.Assert.assertEquals;

public class LoginStep {

    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setup() {

        loginPage = DriverUtil.createClass(LoginPage.class);
        homePage = DriverUtil.createClass(HomePage.class);

    }


    @Given("^Merchant is on the Login Page$")
    public void catalogUserIsOnTheLoginPage() throws Throwable {
        loginPage.navigateToLogin();
        loginPage.takeScreenShot("Login url is visited...");

    }

    @When("^Merchant login with \"([^\"]*)\" username, \"([^\"]*)\" password$")
    public void merchantLoginWithUsernamePassword(String username, String password) throws Throwable {
        loginPage.login(username, password);
        loginPage.takeScreenShot("merchantLoginWithUsernamePassword");
    }

    @Then("^Merchant should see Access Denied Message$")
    public void merchantShouldSeeAccessDeniedMessage() throws Throwable {
        Assert.assertTrue("Hatalı giriş", loginPage.checkLoginWithWrongCrediantialsToast());
    }

    @When("^Merchant should see \"([^\"]*)\" username as on Home Page$")
    public void merchantShouldSeeUsernameAsOnHomePage(String username) throws Throwable {
        homePage.hoverMerchantName();
        assertEquals("Wrong merchant name", username, homePage.getMerchantName());
    }

}
