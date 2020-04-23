package lima.page;

import lima.base.BasePage;
import lima.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static lima.constants.Constants.HomePage.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void hoverMerchantName() throws InterruptedException {
        Thread.sleep(4000);
        hover(merchantTooltip);


    }

    public String getMerchantName() {
        return getDriver().findElement(By.id("toolTip-merchant")).getText();
    }
}
