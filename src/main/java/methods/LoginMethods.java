package methods;

import data.DataCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.ArrayList;

public class LoginMethods extends BasePage {

    public LoginMethods(WebDriver driver) {
        super(driver);
    }

    // Element references

    By signInBy = By.className("login");
    By emailBy = By.id("email");
    By passwordBy = By.id("passwd");
    By submitBy = By.id("SubmitLogin");

    // Assert element references
    By errorMessageBy = By.xpath("//*[@id=\"center_column\"]/div[1]");
    By signOutBy = By.className("logout");

    // Methods

    // login method
    public LoginMethods login(String email, String password) {
        click(signInBy);
        writeText(emailBy, email);
        writeText(passwordBy, password);
        click(submitBy);
        return this;
    }


    // Verifications

    // login verification
    public LoginMethods verifyLogin(String expectedText) {
        String elementText = readText(signOutBy);
        assertStringEquals(elementText, expectedText);
        return this;
    }


    // fail login verification
    public LoginMethods verifyFailedLogin(String expectedText) {
        String alert = readText(errorMessageBy);
        assertStringEquals(alert, expectedText);
        return this;
    }
}
