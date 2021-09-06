package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.ContactPage;

import java.util.ArrayList;

public class ContactUsTest extends BaseTest {

    public ContactPage contactPage;
    ArrayList<String> userData = new ArrayList<>();

    @Test
    public void contactUsTest() {
        contactPage = new ContactPage(driver);
        contactPage.contactUs(userData);

        // Test assertion
        try {
            contactPage.verifyContactUs();
            System.out.println("The message is sent successfully.");
        } catch (Exception e) {
            Assert.fail("Something went wrong.");
        }
    }
}
