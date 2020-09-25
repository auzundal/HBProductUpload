package lima.page;

import lima.base.BasePage;
import lima.util.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static lima.constants.Constants.SingleProductPage.*;

public class SingleProductPage extends BasePage {
    public SingleProductPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToProductPage() {
        getDriver().get(DriverUtil.getBaseUrl() + addProductPageLink);
    }

    public void clickSingleProductTab() {
        clickAfterWaitForElement(singleProductTabButton);
    }

    public boolean checkSingleProductModal() {
        return isElementExists(singleProductModalTab);
    }

    public void setProductCategory(String category) {
        setDropdownList(category, productCategoryCombobox, productCategoryComboItem);
    }

    public void setBrand(String brand) {
        clickAndWrite(brandText,brand);
    }

    public void setProductName(String product) {
        clickAndWrite(productNameText,product);
    }

    public void setBarcode(String barcode) {
        clickAndWrite(barcodeText,barcode);
    }

    public void setMerchantStockCode(String merchantStockCode) {
        clickAndWrite(merchantStockCodeText, merchantStockCode);
    }

    public void setProductColor(String color) {
        clickAfterWaitForElement(colorCombobox);
        clickAndWrite(colorText, color);
        clickAfterWaitForElement(colorComboItem);
    }

    public void uploadProductImage(String image) {
        WebElement fileInput = findElement(uploadImageFile);
        fileInput.sendKeys(imageUploadTempPath + image);
    }

    public void setNumberVariant(String numberVariant) {
        clickAfterWaitForElement(variantText);
        clickAndWrite(variantText, numberVariant);
    }

    public void clickNextStep() {
        waitUntilEnableByLocator(continueButton);
        click(continueButton);
    }

    public void checkProductFeaturePage() {
        isElementExists(productFeaturePageStep);
    }

    public void setWarrantyLength(String warrantyLength) throws InterruptedException {
        Thread.sleep(2000);
        clickAndWrite(warrantyText, warrantyLength);
    }

    public void setTaxPercentage(String taxPercentage) {
        setDropdownList(taxPercentage, taxPercentageCombobox, taxPercentageComboItem);
    }

    public void setDesi(String desi) {
        clickAndWrite(desiTextbox, desi);
    }

    public void setSizeProperty(String size) {
        setDropdownList(size, sizeCombobox, sizeComboboxItem);
    }

    public void setDescription(String description) {
        new Actions(getDriver()).moveToElement(getDriver().findElement(descriptionButton)).click().perform();
        clickAndWrite(descriptionText, description);
        clickAndWrite(descriptionText, description);
    }

    public void clickApprovalofAddSingleProduct() {
        waitUntilEnableByLocator(continueButton);
        click(continueButton);
    }

    public void checkProductDescriptionPage() {
        isElementExists(descriptionPageStepLabel);
    }

    public void checkSuccessfulMessage() {
        String actualMessage = getText(successfulMessageLabel);
        assertEquals(addProductFailMessage, successfulMessage, actualMessage);
    }
    public String getTitle() {
        return getText(addProductPageViewTitle);
    }
}