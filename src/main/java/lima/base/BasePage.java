package lima.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
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

    protected void clickAndWrite(By locator, String value) {
        WebElement element = waitUntilPresenceByLocator(locator);
        waitUntilVisibleByLocator(locator);
        element.click();
        takeScreenShot("Sendkeys");
        element.sendKeys(value);
    }

    protected void uploadMedia(By locator, String value){
        isElementDisplayed(locator);
        findElement(locator).sendKeys(value);
    }

    public boolean isElementDisplayed(By by) {

        return findElement(by).isDisplayed();
    }

    protected boolean waitUntilInvisibleByLocator(By locator, int timeout) {
        WebDriverWait waitProgressBar = new WebDriverWait(driver, timeout);
        waitProgressBar.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        return waitProgressBar.until(ExpectedConditions.invisibilityOfElementLocated(locator));
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
        waitUntilVisibleByLocator(locator);
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
        click(areaPath);
        clickAndWrite(genericComboBoxText, value);
        click(listItemPath);
    }

    protected void sendEndKey() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
    }

    protected ExpectedCondition<Boolean> waitUntilInVisibleByLocator(By locator) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return !driver.findElement(locator).isDisplayed();
                } catch (org.openqa.selenium.NoSuchElementException nc) {
                    return true;
                } catch (StaleElementReferenceException ex) {
                    return true;
                } catch (TimeoutException te) {
                    return true;
                }
            }

            public String toString() {
                return "element to be visible: " + locator;
            }
        };
    }

    public boolean waitUntilDisplayed(By by) {
        return wait.until(waitUntilInVisibleByLocator(by));
    }

    public boolean isDisplayed(By by) {
        try {
            return getDriver().findElement(by).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}