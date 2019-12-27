package lima.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lima.page.HomePage;
import lima.page.LoginPage;
import lima.util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStep {


    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriver driver;


    @Before
    public void setup() {
        driver = DriverUtil.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }


    @Given("^Merchant is on the Login Page$")
    public void catalogUserIsOnTheLoginPage() throws Throwable {
        loginPage.navigateToLogin();
    }


    @When("^Merchant login with \"([^\"]*)\" username, \"([^\"]*)\" password$")
    public void merchantLoginWithUsernamePassword(String username, String password) throws Throwable {
        loginPage.login(username, password);

    }


    @Then("^Merchant should see username as on Home Page$")
    public void merchantShouldSeeUsernameAsOnHomePage() throws Throwable {
        homePage.hoverMerchantName();
        assertEquals("Wrong merchant name", "TEST-MPOP", homePage.getMerchantName());
    }

    @Then("^Merchant should see Access Denied Message$")
    public void merchantShouldSeeAccessDeniedMessage() throws Throwable {
        Thread.sleep(3000);
        assertTrue("Hatalı giriş", driver.findElement(By.cssSelector(".toast.toast-error")).isDisplayed());
    }


    @After
    public void tearDown() {
        DriverUtil.closeDriver(driver);
    }


}
