package YellowTail;

import YellowTail.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
    public void isElementDisplayedWelcomePage() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WelcomePage welcomePage = new WelcomePage(driver);

        Assert.assertTrue(welcomePage.getLegalDrinkingAgeField().isDisplayed());
        Assert.assertTrue(welcomePage.getCheckboxLegalDrinkingAge().isDisplayed());
        Assert.assertTrue(welcomePage.getSelectedDropdown().isDisplayed());
        Assert.assertTrue(welcomePage.getWelcomeButton().isDisplayed());
        Assert.assertFalse(welcomePage.getWelcomeButton().isEnabled());

    }
    @Test (description = "Case2")
//Case 2: Welcome page: navigate to main page as European customer
//1. Tick on checkbox
//2. Select “Europe” from dropbox
//3. Press “Welcome” button
//4. Main page should be displayed
    public void navigateToMainPage (){

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = new MainPage(driver);

        welcomePage.getCheckboxLegalDrinkingAge().click();

        Select dropdownSelect = new Select(welcomePage.getDropdownSelect());
        dropdownSelect.selectByValue("eu");

        welcomePage.clickOnWelcomeButton();
        Assert.assertTrue(mainPage.getWelcomeLogo().isDisplayed());

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
    public void isElementsDisplayedMainPage (){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.getCheckboxLegalDrinkingAge().click();

        Select dropdownSelect = new Select(welcomePage.getDropdownSelect());
        dropdownSelect.selectByValue("eu");

        MainPage mainPage = welcomePage.clickOnWelcomeButton();

        Assert.assertTrue(mainPage.getMenuButton().isDisplayed());
        Assert.assertTrue(mainPage.getWelcomeToTheWorldLogo().isDisplayed());
        Assert.assertTrue(mainPage.getWeArePassionateParagraph().isDisplayed());
        Assert.assertTrue(mainPage.getFindYourWineButton().isDisplayed());
        Assert.assertTrue(mainPage.getFooter().isDisplayed());

    }
    @Test (description = "Case4")
//Case 4: Main page: Menu button logic (open header)
//1. Navigate to main page
//2. Click on Menu button
//3. Verify that header with all needed links is appeared
    public void openHeader(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.getCheckboxLegalDrinkingAge().click();

        Select dropdownSelect = new Select(welcomePage.getDropdownSelect());
        dropdownSelect.selectByValue("eu");

        MainPage mainPage = welcomePage.clickOnWelcomeButton();
        MenuBar menuBar = mainPage.clickOnMenuButton();

        menuBar.waitForYellowTailLogo();
        Assert.assertTrue(menuBar.getYellowTailLogo().isDisplayed());
        Assert.assertTrue(menuBar.getWhereToBuyNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getWinesNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getCocktailsNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getOurStoryNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getFAQsNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getContactNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getGlobeDropdown().isDisplayed());

    }

    @Test (description = "Case5")
//Case 5: Main page: Menu button logic (close header)
//1. Navigate to main page
//2. Click on Menu button
//3. Click on [yellow tail]
//4. Verify that Menu button is visible
    public void closeHeader(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.getCheckboxLegalDrinkingAge().click();

        Select dropdownSelect = new Select(welcomePage.getDropdownSelect());
        dropdownSelect.selectByValue("eu");

        MainPage mainPage = welcomePage.clickOnWelcomeButton();
        MenuBar menuBar = mainPage.clickOnMenuButton();
        menuBar.waitForYellowTailLogo();
        menuBar.getYellowTailLogo().click();
        Assert.assertTrue(mainPage.getMenuButton().isDisplayed());


        }

        @Test (description = "Case6")
//        Case 6: Main page: Global Nav logic
//        1. Navigate to main page
//        2. Click on Menu button
//        3. Click on Globe icon
//        4. Select China in popup and click on it
//        5. Verify that language is changed
        public void verifyIsLanguageChanged() {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            WelcomePage welcomePage = new WelcomePage(driver);

            welcomePage.getCheckboxLegalDrinkingAge().click();

            Select dropdownSelect = new Select(welcomePage.getDropdownSelect());
            dropdownSelect.selectByValue("eu");

            MainPage mainPage = welcomePage.clickOnWelcomeButton();
            MenuBar menuBar = mainPage.clickOnMenuButton();
            menuBar.waitForYellowTailLogo();
            menuBar.getGlobeDropdown().click();
            menuBar.getChinaLanguageSelect().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("cn"));

    }
    //Case 7 страница с китайским недоступна

    @Test (description = "Case8")
//Case 8: Where to buy: enter valid postal code
//1. Navigate to “Where to buy” page
//2. Enter valid data in “Your location” field
//3. Click on Search button
//4. Verify that the results of search are displayed

    public void enterValidPostalCode() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.getCheckboxLegalDrinkingAge().click();

        Select dropdownSelect = new Select(welcomePage.getDropdownSelect());
        dropdownSelect.selectByValue("eu");

        MainPage mainPage = welcomePage.clickOnWelcomeButton();
        MenuBar menuBar = mainPage.clickOnMenuButton();
        WhereToBuyPage whereToBuyPage = menuBar.clickOnWhereToBuyNavigation();
        whereToBuyPage.getLocationNameField().click();
        whereToBuyPage.getLocationNameField().sendKeys("Sydney");
        whereToBuyPage.getSearchSubmitButton().click();

        Assert.assertTrue(whereToBuyPage.getStockInEnteredArea().isDisplayed());
    }


    @Test (description = "Case9")
//Case 9: Cocktails: Select one wine
//1. Navigate to “Cocktails” page
//2. Select “Red wine cocktails”
//3. Verify that 9 recipes are displayed
    public void verifyRecipesAreDisplayed () {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.getCheckboxLegalDrinkingAge().click();

        Select dropdownSelect = new Select(welcomePage.getDropdownSelect());
        dropdownSelect.selectByValue("eu");

        MainPage mainPage = welcomePage.clickOnWelcomeButton();
        MenuBar menuBar = mainPage.clickOnMenuButton();
        CocktailsPage cocktailsPage = menuBar.clickOnCocktailsNavigation();
        cocktailsPage.getSelectWineForCocktails().click();
        cocktailsPage.getRedWineElement().click();
        Assert.assertEquals(cocktailsPage.getRedWineRecipes().size(), 9);

    }

    @Test (description = "Case10")
//Case 10: Cocktails: Navigate to Cocktail recipe page
//1. Navigate to “Cocktails” page
//2. Scroll to “RASPBERRY ROSÉ” recipe
//3. Click on “RASPBERRY ROSÉ” recipe
//4. Verify that new page is displayed:
//   - ingredients section is displayed
    public void verifyRaspberryRosePageIsDisplayed () {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.getCheckboxLegalDrinkingAge().click();

        Select dropdownSelect = new Select(welcomePage.getDropdownSelect());
        dropdownSelect.selectByValue("eu");

        MainPage mainPage = welcomePage.clickOnWelcomeButton();
        MenuBar menuBar = mainPage.clickOnMenuButton();
        CocktailsPage cocktailsPage = menuBar.clickOnCocktailsNavigation();
        Actions actions = new Actions(driver);
        actions.moveToElement(cocktailsPage.getRaspberryRoseRecipe());
        actions.perform();
        cocktailsPage.getRaspberryRoseRecipe().click();
        Assert.assertTrue(cocktailsPage.getRecipeTitle().isDisplayed());
        Assert.assertTrue(cocktailsPage.getIngredientsSection().isDisplayed());



    }
    @Test (description = "Case11")
//Case 11: Cocktails: Select several wines
//1. Navigate to “Cocktails” page
//2. Select “Red wine cocktails”
//3. Select “Sparkling wine cocktails”
//4. Verify that “Multiple” word is displayed in “Type” dropdown
//5. Verify that 18 recipes are displayed
    public void testSelectSeverWines (){

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.getCheckboxLegalDrinkingAge().click();

        Select dropdownSelect = new Select(welcomePage.getDropdownSelect());
        dropdownSelect.selectByValue("eu");

        MainPage mainPage = welcomePage.clickOnWelcomeButton();
        MenuBar menuBar = mainPage.clickOnMenuButton();
        CocktailsPage cocktailsPage = menuBar.clickOnCocktailsNavigation();
        cocktailsPage.getCocktailsNavigation().click();
        cocktailsPage.getSelectWineForCocktails().click();
        cocktailsPage.getRedWineElement().click();
        cocktailsPage.getSparklingWine().click();
        Assert.assertTrue(cocktailsPage.getMultipleSelect().isDisplayed());
        Assert.assertEquals(cocktailsPage.getRedWineRecipes().size(), 20);

    }






}
