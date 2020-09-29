package lima.page;

import lima.base.BasePage;
import org.openqa.selenium.WebDriver;

import static lima.constants.Constants.HomePage.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void hoverMerchantName() throws InterruptedException {
        hover(merchantUsernameImage);
    }

    public String getMerchantName() {
        return getDriver().findElement(merchantTooltip).getText();
    }

    public void clickElementProductProcess() {
        click(productProcess);
    }

    public void clickElementGalleryProcess() {
        click(galleryProcessButton);
    }
}
