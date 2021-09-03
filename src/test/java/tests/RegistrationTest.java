package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.RegistrationPage;
import utilities.PropertyManager;

import java.util.ArrayList;

public class RegistrationTest extends BaseTest {

    public RegistrationPage registrationPage;
    ArrayList<String> userData = new ArrayList<>();

    @Test
    public void registrationTest() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(userData);

        // Test assertion
        try {
            registrationPage.verifyRegisterUser();
            System.out.println("User is registered.");
            PropertyManager.setProperty("reg_email", userData.get(0));
            PropertyManager.setProperty("reg_password", userData.get(3));
            PropertyManager.setProperty("first_name", userData.get(1));
            PropertyManager.setProperty("last_name", userData.get(2));
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
