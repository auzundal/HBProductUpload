package lima.page;

import io.qameta.allure.Step;
import lima.base.BasePage;
import lima.util.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static lima.constants.Constants.MultipleProduct.*;
public class MultipleProductPage extends BasePage {
    private String excelPath = System.getProperty("user.dir")+"\\data\\sample\\excelUpload\\";

    public MultipleProductPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public void navigateToProductPage() {
        getDriver().get(DriverUtil.getBaseUrl() + "/v2/products/add");
    }

    public void fileUploadFromPc(String filename) {
        uploadMedia(inputUploadFromPc,excelPath.concat(filename));
    }

    public void waitUpload(){
        waitUntilInvisibleByLocator(uploadProgressBar,120);
    }

    public void goToUploadHistory(){
        clickAfterWaitForElement(showAllOfThem);
        clickAfterWaitForElement(successfullyTab);
    }

    public void uploadedFileName(String expectedFileName) {
        waitUntilVisibleByLocator(uploadedFileNameInSuccesfullyTab);
        Assert.assertEquals(expectedFileName,getText(uploadedFileNameInSuccesfullyTab));
    }
}
