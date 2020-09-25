package lima.page;

import io.qameta.allure.Step;
import lima.base.BasePage;
import lima.util.DriverUtil;
import org.openqa.selenium.WebDriver;
import static lima.constants.Constants.LoginPage.*;
import static lima.util.DriverUtil.*;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void navigateToLogin() {
        getDriver().get(DriverUtil.getBaseUrl() + "/login");
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