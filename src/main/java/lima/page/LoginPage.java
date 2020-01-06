package lima.page;

import lima.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLogin() {
        getDriver().get("http://192.168.55.112:30011/login");
    }

    public void login(String username, String password) {
        clickAndWrite(By.id("loginPage-input-username"), username);
        clickAndWrite(By.id("loginPage-input-password"), password);
        click(By.id("loginPage-button-login"));
    }

    public boolean checkLoginWithWrongCrediantialsToast() {
        waitUntilVisibleByLocator(By.cssSelector(".toast.toast-error"));
        return isElementExists(By.cssSelector(".toast.toast-error"));
    }

}
