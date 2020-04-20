package lima.page;

import io.qameta.allure.Step;
import lima.base.BasePage;
import lima.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static lima.constants.Constants.LoginPage.*;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void navigateToLogin() {
        getDriver().get(rootMainPageloginURL);
        takeScreenShot("Address is visited...");

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
