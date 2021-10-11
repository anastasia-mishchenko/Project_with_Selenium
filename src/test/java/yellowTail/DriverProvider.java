package yellowTail;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static yellowTail.Constants.BROWSER_NAME_PROPERTY;
import static yellowTail.Constants.FILE_WITH_PROPERTIES;

public class DriverProvider {
//    private static WebDriver driver;
//    static String driverName = "chrome";
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            driver = createDriver(driverName);
//        }
//        return driver;
//    }

//    private static WebDriver createDriver(String driverName) {
//        if (driverName.equals("chrome")) {
//            System.setProperty(CHROME_DRIVER_PROPERTY, PATH_TO_CHROME_DRIVER);
//            return new ChromeDriver();
//        } else if (driverName.equals("firefox")) {
//            System.setProperty(FIREFOX_DRIVER_PROPERTY, PATH_TO_FIREFOX_DRIVER);
//            return new FirefoxDriver();
//        } else {
//            System.setProperty(CHROME_DRIVER_PROPERTY, PATH_TO_CHROME_DRIVER);
//            return new ChromeDriver();
//        }
//    }
    public static final DriverProvider INSTANCE = new DriverProvider();
    private ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();

    private DriverProvider(){}

    public WebDriver getDriver(){
        if (DRIVER.get() == null){
           String browserName =(System.getProperty(BROWSER_NAME_PROPERTY)==null) ?
                   loadProperties().getProperty(BROWSER_NAME_PROPERTY):System.getProperty(BROWSER_NAME_PROPERTY);

            WebDriver createdWebDriver = new DriverFactory().createDriverInstance(BrowserType.valueOf(browserName));
            //BrowserType.CHROME
            DRIVER.set(createdWebDriver);
        }
        return DRIVER.get();
    }

    public void removeDriver(){
        DRIVER.get().quit();
        DRIVER.remove();
    }

    public static Properties loadProperties() {
        String current = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String resourcesFolder = "src" + separator + "test" + separator + "resources";


        Path file = Paths.get(current + separator + resourcesFolder + separator + FILE_WITH_PROPERTIES);

        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException("No such file is found");
        }

    return properties;
    }
}

