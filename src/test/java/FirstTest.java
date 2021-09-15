import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
    WebDriver driver;

    @BeforeClass
    public void BeforeClass(){

    }

    @Test
    public void Test() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ithillel.ua/");
        By buttonFreeConsultationPath = By.id("btn-consultation-hero");
        WebElement buttonFreeConsultation = driver.findElement(buttonFreeConsultationPath);
        buttonFreeConsultation.click();

        By fieldNameConsultationPath = By.id("input-name-consultation");
        WebElement fieldNameConsultation = driver.findElement(fieldNameConsultationPath);
        fieldNameConsultation.click();
        fieldNameConsultation.sendKeys("Test");

        Assert.assertEquals(fieldNameConsultation.getText(), "Test");



        //       driver.quit();
        System.out.println("Successful");
    }




}
