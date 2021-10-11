package yellowTail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static yellowTail.Constants.*;
import static yellowTail.Constants.PATH_TO_FIREFOX_DRIVER;

public class DriverFactory {

    public WebDriver createDriverInstance(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty(CHROME_DRIVER_PROPERTY, PATH_TO_CHROME_DRIVER);
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty(FIREFOX_DRIVER_PROPERTY, PATH_TO_FIREFOX_DRIVER);
                return new FirefoxDriver();
            default:
                System.setProperty(CHROME_DRIVER_PROPERTY, PATH_TO_CHROME_DRIVER);
                return new ChromeDriver();
        }


    }
}
