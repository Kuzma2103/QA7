package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.PropertyManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public ChromeOptions options;

    @Before
    public void setup() {
        options = new ChromeOptions();

        // Disable browser pop ups
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        // Check for OS version
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(os);

        if (os.contains("windows")) {
            // For windows OS
            System.setProperty("webdriver.chrome.driver", PropertyManager.getInstance().getDriverPath());
        } else {
            // For Linux / Ubuntu OS
            System.setProperty("webdriver.chrome.driver", PropertyManager.getInstance().getDriverPathLinux());
        }

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(PropertyManager.getInstance().getURL());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
