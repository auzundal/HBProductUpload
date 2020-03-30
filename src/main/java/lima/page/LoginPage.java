package lima.page;

import lima.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLogin() {
        getDriver().get(rootMainPageloginURL);
    }

    public void login(String username, String password) {
        clickAndWrite(usernameTextbox, username);
        clickAndWrite(passwordTextbox, password);
        click(loginButton);
    }

    public boolean checkLoginWithWrongCrediantialsToast() {
        waitUntilVisibleByLocator(errorMessageToast);
        return isElementExists(errorMessageToast);
    }

    private String rootMainPageloginURL = ("http://192.168.55.112:30011/login");
    private By usernameTextbox = By.id("loginPage-input-username");
    private By passwordTextbox = By.id("loginPage-input-password");
    private By loginButton = By.id("loginPage-button-login");
    private By errorMessageToast = By.cssSelector(".toast.toast-error");
}
