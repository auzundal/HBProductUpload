package lima.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lima.page.MultipleProductPage;
import lima.util.DriverUtil;

import static lima.util.DriverUtil.takeScreenShot;

public class MultipleProductStep {
    private MultipleProductPage multipleproductpage;

    @Before
    public void MultipleProductPage() {
        multipleproductpage = DriverUtil.createClass(MultipleProductPage.class);
    }

    @Given("^Merchant go to add multiple page$")
    public void  navigateToAddProductPage() {
        multipleproductpage.navigateToProductPage();
        takeScreenShot("Add Product url is visited...");
    }

    @When("^Merchant \"([^\"]*)\" excel file upload from pc$")
    public void fileUploadPc(String filename)  {
        multipleproductpage.fileUploadFromPc(filename);
    }

    @When("^Merchant I would like to upload successfully icon$")
    public void waitUploadSuccessIcon()  {
        multipleproductpage.waitUpload();
    }

    @When("^Merchant I would like going to upload history$")
    public void goToUploadHistory(){
        multipleproductpage.goToUploadHistory();
    }

    @Then("^Merchant I would like to check successfully upload \"([^\"]*)\" file$")
    public void checkUnSuccessfullyUploadFile(String expectedFileName){
        multipleproductpage.uploadedFileName(expectedFileName);
    }
}
