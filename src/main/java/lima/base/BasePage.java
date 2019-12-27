package lima.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;

    private WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);


    }


    protected WebDriver getDriver() {
        return driver;
    }

    protected void clickAndWrite(By by, String value) {
        WebElement element = getDriver().findElement(by);
        element.click();
        element.sendKeys(value);

    }

    protected WebElement waitUntilVisibleByLocator(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    protected void click(By by) {
        WebElement element = getDriver().findElement(by);
        element.click();

    }

    public WebElement getUsernameField() {
        return waitUntilVisibleByLocator(By.id("home-button-username")).findElement(By.tagName("span"));
    }

    public void hover(By webElement) {
        Actions action = new Actions(driver);
        WebElement hover = driver.findElement(webElement);
        action.moveToElement(hover).build().perform();

    }

}


