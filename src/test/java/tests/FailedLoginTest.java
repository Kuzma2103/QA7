package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.PropertyManager;

public class FailedLoginTest extends BaseTest {

    public HomePage homePage;
    public LoginPage loginPage;

    @Test
    public void failedLogin() {

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(PropertyManager.getInstance().getEmail(), PropertyManager.getInstance().getPassword());
    }

}
