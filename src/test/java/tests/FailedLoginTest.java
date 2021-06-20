package tests;

import org.junit.Assert;
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

        try {
            homePage.verifyFailedLogin("There is 1 error\nAuthentication failed.");
            System.out.print("The user IS NOT logged in.");
        } catch (Exception e) {
            Assert.fail("User IS logged in");
        }
    }

}
