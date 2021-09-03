package pages;

import methods.RegistrationMethods;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

import java.util.ArrayList;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationMethods methods;

    // Test methods

    // register user
    public RegistrationPage registerUser(ArrayList<String> userData) {
        methods = new RegistrationMethods(driver);
        methods.register(userData);
        return this;
    }

    // Verification Methods

    // register user verification
    public RegistrationPage verifyRegisterUser() {
        methods = new RegistrationMethods(driver);
        methods.verifyRegister("MY ACCOUNT");
        return this;
    }
}
