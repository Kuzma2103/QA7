package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By errorMessageBy = By.xpath("//*[@id=\"center_column\"]/div[1]");

    public HomePage verifyFailedLogin(String expectedText) {
        String alert = readText(errorMessageBy);
        assertStringEquals(alert, expectedText);
        return this;
    }
}
