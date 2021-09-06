package pages;

import methods.ContactMethods;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactMethods methods;

    // Test methods
    public ContactPage contactUs(ArrayList<String> userData) {
        methods = new ContactMethods(driver);
        methods.contact(userData);
        return this;
    }

    // Verify methods
    public ContactPage verifyContactUs() {
        methods = new ContactMethods(driver);
        methods.verifyContact("Your message has been successfully sent to our team.");
        return this;
    }
}
