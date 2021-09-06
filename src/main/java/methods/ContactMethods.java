package methods;

import data.DataCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.ArrayList;

public class ContactMethods extends BasePage {

    public ContactMethods(WebDriver driver) {
        super(driver);
    }

    // Element references
    By contactUsLinkBy = By.id("contact-link");
    By subjectBy = By.id("id_contact");
    By emailBy = By.id("email");
    By messageBy = By.id("message");

    // Button references
    By sendButtonBy = By.id("submitMessage");


    // Asertion element references
    By alertBoxBy = By.xpath("//div[@id='center_column']//p");


    // Methods
    public ContactMethods contact(ArrayList<String> userData) {
        DataCreation.createData(userData);
        click(contactUsLinkBy);
        Select subjectHeading = new Select(driver.findElement(subjectBy));
        subjectHeading.selectByValue("2");
        writeText(emailBy, userData.get(0));
        writeText(messageBy, userData.get(8));
        click(sendButtonBy);
        return this;
    }


    // Verification
    public ContactMethods verifyContact(String expectedText) {
        String elementText = readText(alertBoxBy);
        assertStringEquals(elementText, expectedText);
        return this;
    }
}
