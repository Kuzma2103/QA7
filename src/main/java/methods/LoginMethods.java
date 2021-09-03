package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginMethods extends BasePage {

    public LoginMethods(WebDriver driver) {
        super(driver);
    }

    By signInBy = By.className("login");
    By emailBy = By.id("email");
    By passwordBy = By.id("passwd");
    By submitBy = By.id("SubmitLogin");

    By errorMessageBy = By.xpath("//*[@id=\"center_column\"]/div[1]");

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

    // fail login verification
    public LoginMethods verifyFailedLogin(String expectedText) {
        String alert = readText(errorMessageBy);
        assertStringEquals(alert, expectedText);
        return this;
    }
}
