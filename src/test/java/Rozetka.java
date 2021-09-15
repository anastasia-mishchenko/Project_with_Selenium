import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rozetka {
    @Test
    public void navigateToRozetcaMobilePhones(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/mobile-phones/c80003/");

        WebElement mobilePhones = driver.findElement(By.xpath("//div[@class='ng-star-inserted']/h1"));
        Assert.assertEquals(mobilePhones.getText(), "Мобильные телефоны");
        Assert.assertTrue(driver.getCurrentUrl().contains("mobile-phones"));
    }
}
