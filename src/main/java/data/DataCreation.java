package data;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.ArrayList;

public class DataCreation extends BasePage {

    public DataCreation(WebDriver driver) {
        super(driver);
    }

    public static ArrayList<String> createData(ArrayList<String> userData) {
        Faker faker = new Faker();

        // Registration user data
        userData.add(faker.internet().emailAddress());          // 0 Email address
        userData.add(faker.name().firstName());                 // 1 First name
        userData.add(faker.name().lastName());                  // 2 Last name
        userData.add(faker.internet().password());              // 3 Password
        userData.add(faker.address().streetName());             // 4 Street address
        userData.add(faker.address().city());                   // 5 City
        userData.add(faker.number().digits(5));           // 6 Zip code
        userData.add(faker.phoneNumber().cellPhone());          // 7 Cell phone number

        // Contact us
        userData.add(faker.chuckNorris().fact());               // 8 Contact Message

        return userData;
    }

}
