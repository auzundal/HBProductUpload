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

    private Actions actions;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
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

    protected boolean isElementExists(By locator) {
        return getDriver().findElements(locator).size() == 1;
    }

    protected void click(By by) {
        waitUntilVisibleByLocator(by);
        WebElement element = getDriver().findElement(by);
        element.click();

    }


    public void hover(By webElement) {
        WebElement hover = driver.findElement(webElement);
        actions.moveToElement(hover).build().perform();
    }

    public void clickAfterWaitForElement(By element) {
        waitUntilVisibleByLocator(element);
        click(element);
    }

    protected void uploadFile(By input, String path) {
        waitUntilVisibleByLocator(input).sendKeys(path);
    }

}


