package lima.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lima.page.HomePage;
import lima.page.LoginPage;
import lima.util.DriverUtil;
import org.junit.Assert;

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
    }

    @When("^Merchant login with \"([^\"]*)\" username, \"([^\"]*)\" password$")
    public void merchantLoginWithUsernamePassword(String username, String password) throws Throwable {
        loginPage.login(username, password);

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
