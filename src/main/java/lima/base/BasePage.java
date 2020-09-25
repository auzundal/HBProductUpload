package lima.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static lima.constants.Constants.Generic.genericComboBoxText;
import static lima.util.DriverUtil.takeScreenShot;

public class BasePage {

    private WebDriver driver;

    private WebDriverWait wait;

    private Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
        this.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void clickAndWrite(By by, String value) {
        WebElement element = waitUntilVisibleByLocator(by);
        element.click();
        takeScreenShot("Sendkeys");
        element.sendKeys(value);
    }

    protected WebElement waitUntilVisibleByLocator(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean isElementExists(By locator) {
        return getDriver().findElements(locator).size() == 1;
    }

    protected WebElement waitUntilPresenceByLocator(By locator) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement waitUntilClickableByLocator(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void scrollToElement(By locator) {
        WebElement element = waitUntilPresenceByLocator(locator);
        Actions scrollToElement = new Actions(driver);
        scrollToElement.moveToElement(element).build().perform();
        waitUntilClickableByLocator(locator);
    }

    protected void click(By locator) {
        WebElement element = waitUntilPresenceByLocator(locator);
        waitUntilClickableByLocator(locator);
        element.click();
    }

    public WebElement hover(By locator) {
        WebElement webElement = waitUntilVisibleByLocator(locator);
        actions.moveToElement(webElement).build().perform();
        return webElement;
    }

    public void clickAfterWaitForElement(By locator) {
        waitUntilVisibleByLocator(locator);
        click(locator);
    }

    public String getText(By locator) {
        return waitUntilVisibleByLocator(locator).getText();
    }

    protected WebElement findElement(By locator) {
        return getDriver().findElement(locator);
    }

    protected WebElement waitUntilEnableByLocator(By locator) {
        driver.switchTo().parentFrame();
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void setDropdownList(String value, By areaPath, By listItemPath) {
        clickAfterWaitForElement(areaPath);
        clickAndWrite(genericComboBoxText, value);
        clickAfterWaitForElement(listItemPath);
    }
}