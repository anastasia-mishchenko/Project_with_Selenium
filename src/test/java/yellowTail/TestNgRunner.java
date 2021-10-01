package yellowTail;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static yellowTail.Constants.*;

public class TestNgRunner {

    @BeforeMethod
    public void beforeMethod(){
//        System.setProperty(CHROME_DRIVER_PROPERTY, PATH_TO_CHROME_DRIVER);
//        driver = new ChromeDriver();
//        driver.get(YELLOW_TILE_SITE_URL);
        DriverProvider.INSTANCE.getDriver().get(YELLOW_TILE_SITE_URL);

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result){
        if(!result.isSuccess()){
            //makeScreenshot();
        }
//        DriverProvider.INSTANCE.getDriver().quit();
        DriverProvider.INSTANCE.removeDriver();
    }
    @Attachment (value = "Page screenshot", type = "img/png")
    public byte[] makeScreenshot(){
        return ((TakesScreenshot) DriverProvider.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
