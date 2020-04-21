package lima.util;

import lima.base.BasePage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtil {

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    private static RemoteWebDriver remoteWebDriver;

    public static void setUp() {
        boolean remote = false;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        if (remote) {
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.1.29:4444/wd/hub"), options);
                //driver = new RemoteWebDriver(new URL("http://192.168.21.230:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver.exe");
            driver = new ChromeDriver(options);
        }

    }

    public static void closeDriver() {
        driver.close();
    }

    public static <T extends BasePage> T createClass(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
            return constructor.newInstance(driver);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}
