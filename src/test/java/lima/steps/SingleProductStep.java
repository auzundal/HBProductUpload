package lima.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lima.page.SingleProductPage;
import lima.util.DriverUtil;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static lima.constants.Constants.Generic.dateFormat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SingleProductStep {

    private SingleProductPage singleproductpage;

    @Before
    public void Setup() {
        singleproductpage = DriverUtil.createClass(SingleProductPage.class);
    }

    @And("^Merchant go to add product page$")
    public void navigateToGallery() {
        singleproductpage.navigateToProductPage();
    }

    @And("^Merchant click add single product tab$")
    public void merchantClickAddSingleProductTab() {
        singleproductpage.clickSingleProductTab();
    }

    @Then("^Merchant should see add product modal$")
    public void checkSingleProductModal() {
        boolean isExist = singleproductpage.checkSingleProductModal();
        Assert.assertTrue(isExist);
    }

    @When("^Merchant should select a category which name is \"(.*?)\"$")
    public void setProductCategory(String category) {
        singleproductpage.setProductCategory(category);
    }

    @And("^Merchant should set a random brand name")
    public void setProductBrand() {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String brand = "Test-" + format.format(new Date());
        singleproductpage.setBrand(brand);
    }

    @And("^Merchant should set a random product name")
    public void setProductName() {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String product = "Test-" + format.format(new Date());
        singleproductpage.setProductName(product);
    }

    @And("^Merchant should write a random barcode")
    public void setBarcode() {
        singleproductpage.setBarcode(UUID.randomUUID().toString());
    }

    @And("^Merchant should write a random merchant stock code")
    public void setMerchantStockCode() {
        singleproductpage.setMerchantStockCode(UUID.randomUUID().toString());
    }

    @And("^Merchant should select a color which name is \"(.*?)\"$")
    public void setProductColor(String color) {
        singleproductpage.setProductColor(color);
    }

    @And("^Merchant should select a number which value is \"(.*?)\"$")
    public void setNumberVariant(String numberVariant) {
        singleproductpage.setNumberVariant(numberVariant);
    }

    @And("^Merchant should insert images \"(.*?)\"$")
    public void uploadProductImage(String image) {
        singleproductpage.uploadProductImage(image);
    }

    @And("^Merchant should click the next step button")
    public void clickNextStep() {
        singleproductpage.clickNextStep();
    }

    @Then("^Merchant should see product feature page")
    public void checkProductFeaturePage() {
        singleproductpage.checkProductFeaturePage();
    }

    @When("^Merchant should write a warrant length is \"(.*?)\"$")
    public void setWarrantyLength(String warranty) throws Throwable {
        singleproductpage.setWarrantyLength(warranty);
    }

    @And("^Merchant should write a tax percentage is \"(.*?)\"$")
    public void setTaxPercentage(String taxPercentage) {
        singleproductpage.setTaxPercentage(taxPercentage);
    }

    @And("^Merchant should write a desi is \"(.*?)\"$")
    public void setDesi(String desi) {
        singleproductpage.setDesi(desi);
    }

    @And("^Merchant should write size property is \"(.*?)\"$")
    public void setSizeProperty(String size) {
        singleproductpage.setSizeProperty(size);
    }

    @When("^Merchant should write description \"(.*?)\"$")
    public void setDescription(String description) throws Throwable {
        Thread.sleep(1000);
        singleproductpage.setDescription(description);
    }

    @And("^Merchant should click approval of add single product button")
    public void clickApprovalofAddSingleProduct() {
        singleproductpage.clickApprovalofAddSingleProduct();
    }

    @Then("^Merchant should see product description page")
    public void checkProductDescriptionPage() {
        singleproductpage.checkProductDescriptionPage();
    }

    @Then("^Merchant should see successful message")
    public void checkSuccessfulMessage() {
        singleproductpage.checkSuccessfulMessage();
    }

    @Then("^Merchant should see title as \"([^\"]*)\" in Single Product Page$")
    public void merchantShouldSeeTitleAsInGalleryPage(String title) throws Throwable {
        assertThat(singleproductpage.getTitle(), is(title));
    }
}