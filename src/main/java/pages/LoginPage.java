package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyManager;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By signInBy = By.className("login");
    By emailBy = By.id("email");
    By passwordBy = By.id("passwd");
    By submitBy = By.id("SubmitLogin");

    String baseURL = PropertyManager.getInstance().getURL();

    public LoginPage basePage() {
        driver.get(baseURL);
        return this;
    }

    public LoginPage login(String email, String password) {
        click(signInBy);
        writeText(emailBy, email);
        writeText(passwordBy, password);
        click(submitBy);
        return this;
    }
}
