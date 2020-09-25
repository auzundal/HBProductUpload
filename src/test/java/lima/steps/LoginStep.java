package lima.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lima.page.HomePage;
import lima.page.LoginPage;
import lima.util.DriverUtil;
import org.junit.Assert;
import static lima.util.DriverUtil.*;

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
    public void catalogUserIsOnTheLoginPage() {
        loginPage.navigateToLogin();
        takeScreenShot("Login url is visited...");
    }

    @When("^Merchant login with \"([^\"]*)\" username, \"([^\"]*)\" password$")
    public void merchantLoginWithUsernamePassword(String username, String password) {
        loginPage.login(username, password);
        takeScreenShot("merchantLoginWithUsernamePassword");
    }

    @Then("^Merchant should see Access Denied Message$")
    public void merchantShouldSeeAccessDeniedMessage() {
        Assert.assertTrue("Hatalı giriş", loginPage.checkLoginWithWrongCrediantialsToast());
    }

    @Then("^Merchant should see username as \"([^\"]*)\" on Home Page$")
    public void merchantShouldSeeUsernameAsOnHomePage(String username) throws Throwable {
        homePage.hoverMerchantName();
        assertEquals("Wrong merchant name", username, homePage.getMerchantName());
    }
}