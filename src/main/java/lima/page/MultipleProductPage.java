package lima.page;

import io.qameta.allure.Step;
import lima.base.BasePage;
import lima.util.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void fileUploadFromPc(String filename) throws InterruptedException {
        clickAndWrite(inputUploadFromPc,excelPath.concat(filename));
    }

    public void uploadedFileName(String fileName) {
        waitUntilVisibleByLocator(uploadedExcelFileNames);
        WebElement errorMessageTitleText = getDriver().findElement(uploadedExcelFileNames);
        Assert.assertEquals(fileName,errorMessageTitleText.getText());
    }
    public void waitWithSecond(int second) throws InterruptedException {
        int s = second*1000;
        Thread.sleep(s);
    }

}
