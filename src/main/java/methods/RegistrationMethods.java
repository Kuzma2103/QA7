package methods;

import data.DataCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.ArrayList;

public class RegistrationMethods extends BasePage {

    public RegistrationMethods(WebDriver driver) {
        super(driver);
    }

    // Element references
    By signInLinkBy = By.className("login");
    By emailBy = By.id("email_create");
    By firstNameBy = By.id("customer_firstname");
    By lastNameBy = By.id("customer_lastname");
    By passwordBy = By.id("passwd");
    By addressBy = By.id("address1");
    By cityBy = By.id("city");
    By stateBy = By.id("id_state");
    By zipPostalBy = By.id("postcode");
    By mobilePhoneBy = By.id("phone_mobile");
    By aliasAddressBy = By.id("alias");


    // Button references
    By createAnAccountButtonBy = By.id("SubmitCreate");
    By registerButtonBy = By.id("submitAccount");

    // Assert element references
    //    By accountNameBy = By.xpath("//a[@class='account']");
    By elementTextBy = By.xpath("//h1[@class='page-heading'][text()='My account']");


    // Methods

    // Registration user
    public RegistrationMethods register(ArrayList<String> userData) {
        DataCreation.createData(userData);
        click(signInLinkBy);
        writeText(emailBy, userData.get(0));
        click(createAnAccountButtonBy);
        writeText(firstNameBy, userData.get(1));
        writeText(lastNameBy, userData.get(2));
        writeText(passwordBy, userData.get(3));
        writeText(addressBy, userData.get(4));
        writeText(cityBy, userData.get(5));
        Select state = new Select(driver.findElement(stateBy));
        state.selectByValue("2");
        writeText(zipPostalBy, userData.get(6));
        writeText(mobilePhoneBy, userData.get(7));
        writeText(aliasAddressBy, userData.get(4));
        click(registerButtonBy);

        return this;
    }

    // Verification
    public RegistrationMethods verifyRegister(String expectedText) {
        String elementText = readText(elementTextBy);
        assertStringEquals(elementText, expectedText);
        return this;
    }
}
