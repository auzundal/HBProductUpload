package lima.util;

import lima.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DriverUtil {

    private static WebDriver driver;
    private static String baseUrl;

    public static void setUp() {
        String baseUrl = System.getProperty("baseUrl");
        if (baseUrl == null) {
            throw new IllegalArgumentException("Base url should not be null");
        } else {
            setBaseUrl(baseUrl);
        }


        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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


    public static String getBaseUrl() {
        return baseUrl;
    }

    private static void setBaseUrl(String baseUrl) {
        DriverUtil.baseUrl = baseUrl;
    }
}
