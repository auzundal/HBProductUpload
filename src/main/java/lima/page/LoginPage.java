package lima.page;

import io.qameta.allure.Step;
import lima.base.BasePage;
import lima.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage  implements Constants.LoginPage {


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
        waitUntilVisibleByLocator(loginPageErrorMessageToast);
        takeScreenShot("checkLoginWithWrongCrediantialsToast");
        return isElementExists(loginPageErrorMessageToast);
    }
}
