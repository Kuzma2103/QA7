package pages;


import methods.LoginMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginMethods methods;

    // Test methods

    // login user
    public LoginPage loginUser(String email, String password) {
        methods = new LoginMethods(driver);
        methods.login(email, password);
        return this;
    }

    // Verification methods

    // verify fail login
    public LoginPage verifyFailLoginUser() {
        methods = new LoginMethods(driver);
        methods.verifyFailedLogin("There is 1 error\nAuthentication failed.");
        return this;
    }
}
