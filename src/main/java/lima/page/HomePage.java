package lima.page;

import lima.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void hoverMerchantName() throws InterruptedException {
        Thread.sleep(4000);
        hover(By.cssSelector("[data-for='toolTip-merchant']"));


    }

    public String getMerchantName() {
        return getDriver().findElement(By.id("toolTip-merchant")).getText();
    }


}
