package lima.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lima.page.GalleryPage;
import lima.page.HomePage;
import lima.util.DriverUtil;

public class HomePageStep {

    private HomePage homePage;

    @Before
    public void GalleryStep() {
        homePage = DriverUtil.createClass(HomePage.class);
    }

    @And("Merchant click gallery process button")
    public void merchantClickGalleryProcessButton() {
        homePage.clickElementGalleryProcess();
    }

    @When("^Merchant click product process button$")
    public void iClickProductProcessButton() throws Throwable {
        homePage.clickElementProductProcess();
    }
}
