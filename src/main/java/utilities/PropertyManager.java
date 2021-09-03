package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyManager {

    private static String driverPath;
    private static String url;
    private static String bad_email;
    private static String bad_password;

    // user register data
    private static String email;
    private static String password;
    private static String first_name;
    private static String last_name;

    public static PropertyManager getInstance() {
        Properties prop = new Properties();
        PropertyManager instance = new PropertyManager();

        try {
            FileInputStream fi = new FileInputStream("src/main/resources/configuration.properties");
            prop.load(fi);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driverPath = prop.getProperty("driverPath");
        url = prop.getProperty("url");
        bad_email = prop.getProperty("bad_email");
        bad_password = prop.getProperty("bad_password");

        // user data
        email = prop.getProperty("email");
        password = prop.getProperty("password");
        first_name = prop.getProperty("first_name");
        last_name = prop.getProperty("last_name");

        return instance;
    }

    public static void setProperty(String key, String value) {
        Properties editProperties = new Properties();

        try {
            FileInputStream editFile = new FileInputStream("src/main/resources/configuration.properties");
            editProperties.load(editFile);
            editProperties.setProperty(key, value);
            editProperties.store(new FileOutputStream("src/main/resources/configuration.properties"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDriverPath() {
        return driverPath;
    }

    public String getURL() {
        return url;
    }

    public String getBadEmail() {
        return bad_email;
    }

    public String getBadPassword() {
        return bad_password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

}