package YellowTail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class YellowTailSite {
    WebDriver driver;

    @BeforeTest
    public void openChromeBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com/");

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


    @Test (description = "Case1")
    public void isElementDisplayedWelcomePage() throws InterruptedException {
        Thread.sleep(2000);
        WebElement legalDrinkingAge = driver.findElement(By.xpath("//label[@for='confirm']"));
        Assert.assertTrue(legalDrinkingAge.isDisplayed(),"Passed");
        WebElement checkboxLegalDrinkingAge = driver.findElement(By.xpath("//label[@for='confirm']"));
        Assert.assertTrue(checkboxLegalDrinkingAge.isDisplayed(),"Passed");
        WebElement dropdownSelect = driver.findElement(By.xpath("//select[@name='country']"));
        Assert.assertTrue(dropdownSelect.isDisplayed(),"Passed");
        WebElement welcomeButton = driver.findElement(By.xpath("//input[@type='submit']"));
        Assert.assertTrue(welcomeButton.isDisplayed(),"Passed");
        Assert.assertFalse(welcomeButton.isEnabled(),"Passed");

    }
    @Test (description = "Case2")
    public void navigateToMainPage () throws InterruptedException {

        Thread.sleep(2000);
        WebElement checkboxLegalDrinkingAge = driver.findElement(By.xpath("//label[@for='confirm']"));
        checkboxLegalDrinkingAge.click();

        Select dropdownSelect = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        dropdownSelect.selectByValue("eu");

        WebElement welcomeButton = driver.findElement(By.xpath("//input[@type='submit']"));
        Assert.assertTrue(welcomeButton.isEnabled(),"Passed");
        welcomeButton.click();

        WebElement welcomeLogo = driver.findElement(By.xpath("//span[text()='Welcome']"));
        Assert.assertTrue(welcomeLogo.isDisplayed(),"Passed");

    }
    @Test (description = "Case3")
    public void isElementsDisplayedMainPage () throws InterruptedException {
        Thread.sleep(2000);
        WebElement checkboxLegalDrinkingAge = driver.findElement(By.xpath("//label[@for='confirm']"));
        checkboxLegalDrinkingAge.click();
        Select dropdownSelect = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        dropdownSelect.selectByValue("eu");
        WebElement welcomeButton = driver.findElement(By.xpath("//input[@type='submit']"));
        welcomeButton.click();

        WebElement menuButton = driver.findElement(By.xpath("//span[text()='Menu']"));
        Assert.assertTrue(menuButton.isDisplayed(),"Passed");

        WebElement welcomeToTheWorld = driver.findElement(By.xpath("//div[@class='content animation-screen -one']/h2"));
        Assert.assertTrue(welcomeToTheWorld.isDisplayed(),"Passed");

        WebElement weArePassionate = driver.findElement(By.xpath("//p[contains(text(),'We are passionate')]"));
        Assert.assertTrue(weArePassionate.isDisplayed(),"Passed");

        WebElement findYourWineButton = driver.findElement(By.xpath("//div[@class='content animation-screen -one']/a"));
        Assert.assertTrue(findYourWineButton.isDisplayed(),"Passed");

        WebElement footer = driver.findElement(By.xpath("//footer"));
        Assert.assertTrue(footer.isDisplayed(),"Passed");

    }
    @Test (description = "Case4")
    public void openHeader() throws InterruptedException {
        Thread.sleep(2000);
        WebElement checkboxLegalDrinkingAge = driver.findElement(By.xpath("//label[@for='confirm']"));
        checkboxLegalDrinkingAge.click();
        Select dropdownSelect = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        dropdownSelect.selectByValue("eu");
        WebElement welcomeButton = driver.findElement(By.xpath("//input[@type='submit']"));
        welcomeButton.click();

        Thread.sleep(2000);
        WebElement menuButton = driver.findElement(By.xpath("//span[text()='Menu']"));
        menuButton.click();

        Thread.sleep(2000);
        WebElement yellowTailLogo = driver.findElement(By.xpath("//div[@class='top-nav -active']//img[@alt='Yellow tail logo']"));
        Assert.assertTrue(yellowTailLogo.isDisplayed(),"Passed");
        WebElement winesNavigation = driver.findElement(By.xpath("//div[@class='main-nav']//span[text()='Wines']"));
        Assert.assertTrue(winesNavigation.isDisplayed(),"Passed");
        WebElement whereToBuyNavigation = driver.findElement(By.xpath("//div[@class='main-nav']//span[text()='Where To Buy']"));
        Assert.assertTrue(whereToBuyNavigation.isDisplayed(),"Passed");
        WebElement cocktailsNavigation = driver.findElement(By.xpath("//div[@class='main-nav']//span[text()='Cocktails']"));
        Assert.assertTrue(cocktailsNavigation.isDisplayed(),"Passed");
        WebElement ourStoryNavigation = driver.findElement(By.xpath("//div[@class='main-nav']//span[text()='Our Story']"));
        Assert.assertTrue(ourStoryNavigation.isDisplayed(),"Passed");
        WebElement fAQsNavigation = driver.findElement(By.xpath("//div[@class='main-nav']//span[text()='FAQs']"));
        Assert.assertTrue(fAQsNavigation.isDisplayed(),"Passed");
        WebElement contactNavigation = driver.findElement(By.xpath("//div[@class='main-nav']//span[text()='Contact']"));
        Assert.assertTrue(contactNavigation.isDisplayed(),"Passed");
        WebElement globeDropdown = driver.findElement(By.xpath("//div[@class='main-nav']//span[@class='fa fa-globe fa-lg']"));
        Assert.assertTrue(globeDropdown.isDisplayed(),"Passed");

    }

    @Test (description = "Case4")
    public void closeHeader() throws InterruptedException {
        Thread.sleep(2000);
        WebElement checkboxLegalDrinkingAge = driver.findElement(By.xpath("//label[@for='confirm']"));
        checkboxLegalDrinkingAge.click();
        Select dropdownSelect = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        dropdownSelect.selectByValue("eu");
        WebElement welcomeButton = driver.findElement(By.xpath("//input[@type='submit']"));
        welcomeButton.click();

        Thread.sleep(2000);
        WebElement menuButton = driver.findElement(By.xpath("//span[text()='Menu']"));
        menuButton.click();
        Thread.sleep(2000);
        WebElement yellowTailLogo = driver.findElement(By.xpath("//div[@class='top-nav -active']//img[@alt='Yellow tail logo']"));


        yellowTailLogo.click();
        Thread.sleep(2000);
        Assert.assertTrue(menuButton.isDisplayed(),"Passed");
    }





}
