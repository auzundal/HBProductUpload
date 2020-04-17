package lima.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import lima.page.SingleProductPage;
import lima.util.DriverUtil;

public class SingleProductStep {

    private SingleProductPage singleproductpage;

    @Before
    public void SingleProductStep() {
        singleproductpage = DriverUtil.createClass(SingleProductPage.class);
    }


    @Then("^Merchant go to add product page$")
    public void navigateToGallery() {
        singleproductpage.navigateToProductPage();
    }


    @Then("^Merchant click add single product tab$")
    public void merchantClickAddSingleProductTab() throws Throwable {
        singleproductpage.clickSingleProductTab();
    }
}
