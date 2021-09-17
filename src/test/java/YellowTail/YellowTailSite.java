package YellowTail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;

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
//    Case 1: Welcome page: all required elements are displayed
//1. Go to Welcome page: https://www.yellowtailwine.com
//2. Verify that “I am of legal drinking age in” is displayed
//3. Verify that checkbox before “I am of legal drinking age in” is displayed
//4. Verify that dropdown with Select is displayed
//5. Verify that “Welcome” button is displayed and is inactive
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
//Case 2: Welcome page: navigate to main page as European customer
//1. Tick on checkbox
//2. Select “Europe” from dropbox
//3. Press “Welcome” button
//4. Main page should be displayed
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
//Case 3: Main page: all required elements are displayed
//1. Navigate to main page
//2. Verify that the following elements are displayed:
//- menu button
//- WELCOME TO THE WORLD OF [Yellow tail]
//- We are passionate about creating great tasting, quality wines for everyone to enjoy
//- find your wine button
//- footer
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
//Case 4: Main page: Menu button logic (open header)
//1. Navigate to main page
//2. Click on Menu button
//3. Verify that header with all needed links is appeared
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

    @Test (description = "Case5")
//Case 5: Main page: Menu button logic (close header)
//1. Navigate to main page
//2. Click on Menu button
//3. Click on [yellow tail]
//4. Verify that Menu button is visible
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
    @Test (description = "Case8")
//Case 8: Where to buy: enter valid postal code
//1. Navigate to “Where to buy” page
//2. Enter valid data in “Your location” field
//3. Click on Search button
//4. Verify that the results of search are displayed

    public void enterValidPostalCode() throws InterruptedException {
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
        WebElement whereToBuyNavigation = driver.findElement(By.xpath("//div[@class='main-nav']//span[text()='Where To Buy']"));
        whereToBuyNavigation.click();
            Thread.sleep(2000);
        WebElement locationNameField = driver.findElement(By.xpath("//input[@id='locationName']"));
        locationNameField.click();
        locationNameField.sendKeys("Sydney");
        WebElement searchSubmitButton = driver.findElement(By.xpath("//button[@class='search-submit']"));
        searchSubmitButton.click();
        WebElement stocksInEnteredArea = driver.findElement(By.xpath("//h3[@style='display: block;']"));
        Assert.assertTrue(stocksInEnteredArea.isDisplayed(), "Passed");
    }

        @Test (description = "Case6")
//        Case 6: Main page: Global Nav logic
//        1. Navigate to main page
//        2. Click on Menu button
//        3. Click on Globe icon
//        4. Select China in popup and click on it
//        5. Verify that language is changed
        public void verifyIsLanguageChanged() throws InterruptedException {
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
        WebElement globeDropdown = driver.findElement(By.xpath("//div[@class='main-nav']//span[@class='fa fa-globe fa-lg']"));
        globeDropdown.click();

        WebElement chinaSelect = driver.findElement(By.xpath("//a[@data-key='CN']"));
        chinaSelect.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("cn"));

    }
    //Case 7 страница с китайским недоступна
    @Test (description = "Case9")
//Case 9: Cocktails: Select one wine
//1. Navigate to “Cocktails” page
//2. Select “Red wine cocktails”
//3. Verify that 9 recipes are displayed
    public void verifyRecipesAreDisplayed () throws InterruptedException {
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
        WebElement cocktailsNavigation = driver.findElement(By.xpath("//div[@class='main-nav']//span[text()='Cocktails']"));
        cocktailsNavigation.click();
            Thread.sleep(2000);
        WebElement selectWineForCocktails = driver.findElement(By.xpath("//a[@class='selected']"));
        selectWineForCocktails.click();
            Thread.sleep(2000);
        WebElement redWine = driver.findElement(By.xpath("//a[@data-value='red']"));
        redWine.click();
            Thread.sleep(2000);
        List<WebElement> redWineRecipes = driver.findElements(By.xpath("//div[@class='tile recipe-tile']"));
        Assert.assertTrue(redWineRecipes.size()==9);
    }

    @Test (description = "Case10")
//Case 10: Cocktails: Navigate to Cocktail recipe page
//1. Navigate to “Cocktails” page
//2. Scroll to “RASPBERRY ROSÉ” recipe
//3. Click on “RASPBERRY ROSÉ” recipe
//4. Verify that new page is displayed:
//   - ingredients section is displayed
    public void verifyRaspberryRosePageIsDisplayed () throws InterruptedException {
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
        WebElement cocktailsNavigation = driver.findElement(By.xpath("//div[@class='main-nav']//span[text()='Cocktails']"));
        cocktailsNavigation.click();
        Thread.sleep(2000);

        WebElement recipeRaspberryRose = driver.findElement(By.xpath("//h2[contains(text(),'Raspberry Rosé')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(recipeRaspberryRose);
        actions.perform();
        recipeRaspberryRose.click();

        WebElement recipeTitle = driver.findElement(By.xpath("//h1[@class='recipe-title']"));
        Assert.assertTrue(recipeTitle.isDisplayed(),"Passed");
        WebElement ingredients = driver.findElement(By.xpath("//h3[contains(text(),'Ingredients')]"));
        Assert.assertTrue(ingredients.isDisplayed(),"Passed");

    }
    @Test (description = "Case11")
//Case 11: Cocktails: Select several wines
//1. Navigate to “Cocktails” page
//2. Select “Red wine cocktails”
//3. Select “Sparkling wine cocktails”
//4. Verify that “Multiple” word is displayed in “Type” dropdown
//5. Verify that 18 recipes are displayed
    public void testSelectSeverWines () throws InterruptedException {
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
        WebElement cocktailsNavigation = driver.findElement(By.xpath("//div[@class='main-nav']//span[text()='Cocktails']"));
        cocktailsNavigation.click();
        Thread.sleep(2000);

        WebElement selectWineForCocktails = driver.findElement(By.xpath("//a[@class='selected']"));
        selectWineForCocktails.click();
        Thread.sleep(2000);
        WebElement redWine = driver.findElement(By.xpath("//a[@data-value='red']"));
        redWine.click();
        WebElement sparklingWine = driver.findElement(By.xpath("//a[@data-value='bubbles']"));
        sparklingWine.click();

        WebElement multipleSelect = driver.findElement(By.xpath("//span[contains(text(),'Multiple')]"));
        Assert.assertTrue(multipleSelect.isDisplayed(),"Passed");
        List<WebElement> redWineRecipes = driver.findElements(By.xpath("//div[@class='tile recipe-tile']"));
        Assert.assertTrue(redWineRecipes.size()==20);




    }






}
