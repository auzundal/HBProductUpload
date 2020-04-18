package lima.page;

import io.qameta.allure.Step;
import lima.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void navigateToLogin() {
        getDriver().get(rootMainPageloginURL);
        takeScreenShot("Adrese gidildi...");

    }

    public void login(String username, String password) {
        clickAndWrite(usernameTextbox, username);
        clickAndWrite(passwordTextbox, password);
        click(loginButton);
        takeScreenShot("login");
    }

    public boolean checkLoginWithWrongCrediantialsToast() {
        waitUntilVisibleByLocator(errorMessageToast);
        takeScreenShot("checkLoginWithWrongCrediantialsToast");
        return isElementExists(errorMessageToast);
    }

    private String rootMainPageloginURL = ("http://192.168.55.112:30011/login");
    private By usernameTextbox = By.id("loginPage-input-username");
    private By passwordTextbox = By.id("loginPage-input-password");
    private By loginButton = By.id("loginPage-button-login");
    private By errorMessageToast = By.cssSelector(".toast.toast-error");
}
