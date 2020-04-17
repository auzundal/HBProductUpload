package lima.page;

import lima.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingleProductPage extends BasePage {
    public SingleProductPage(WebDriver driver) {
        super(driver);
    }


    public void navigateToProductPage() {
        getDriver().get("http://192.168.55.112:30011/v2/products/add");
    }

    public void clickSingleProductTab() throws InterruptedException {
        clickAfterWaitForElement(By.id("fileUploadModal-tab-single"));
    }
}













