package lima.page;

import lima.base.BasePage;
import lima.util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleProductPage extends BasePage {
    public SingleProductPage(WebDriver driver) {
        super(driver);
    }


    public void navigateToProductPage() {
        getDriver().get(DriverUtil.getBaseUrl() + "/v2/products/add");
    }

    public void clickSingleProductTab() {
        clickAfterWaitForElement(By.id("fileUploadModal-tab-single"));
    }
}













