package pages;


import methods.LoginMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

import java.util.ArrayList;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginMethods methods;

    // Test methods

    // login user
    public LoginPage loginUser() {
        methods = new LoginMethods(driver);
        methods.login(
                PropertyManager.getInstance().getEmail(),
                PropertyManager.getInstance().getPassword()
        );
        return this;
    }

    public LoginPage failLoginUser() {
        methods = new LoginMethods(driver);
        methods.login(
                PropertyManager.getInstance().getBadEmail(),
                PropertyManager.getInstance().getBadPassword()
        );
        return this;
    }

    // Verification methods
    public LoginPage verifyLoginUser() {
        methods = new LoginMethods(driver);
        methods.verifyLogin("Sign out");
        return this;
    }

    // verify fail login
    public LoginPage verifyFailLoginUser() {
        methods = new LoginMethods(driver);
        methods.verifyFailedLogin("There is 1 error\nAuthentication failed.");
        return this;
    }
}
