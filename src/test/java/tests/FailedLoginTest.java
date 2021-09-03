package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.PropertyManager;

public class FailedLoginTest extends BaseTest {

    public LoginPage loginPage;

    @Test
    public void failedLogin() {
        loginPage = new LoginPage(driver);
        loginPage.loginUser(
                PropertyManager.getInstance().getBadEmail(),
                PropertyManager.getInstance().getBadPassword()
        );

        // Test assertion
        try {
            loginPage.verifyFailLoginUser();
            System.out.print("The user IS NOT logged in.");
        } catch (Exception e) {
            Assert.fail("User IS logged in");
        }
    }

}
