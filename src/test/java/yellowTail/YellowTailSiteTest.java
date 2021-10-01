package yellowTail;

import io.qameta.allure.Description;
import yellowTail.pages.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YellowTailSiteTest extends TestNgRunner{


    @Description (" Case 1: Welcome page: all required elements are displayed")
    @Test (description = "Case1")
//1. Go to Welcome page: https://www.yellowtailwine.com
//2. Verify that “I am of legal drinking age in” is displayed
//3. Verify that checkbox before “I am of legal drinking age in” is displayed
//4. Verify that dropdown with Select is displayed
//5. Verify that “Welcome” button is displayed and is inactive
    public void isElementDisplayedWelcomePage() {

        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WelcomePage welcomePage = new WelcomePage();

        Assert.assertTrue(welcomePage.getLegalDrinkingAgeField().isDisplayed());
        Assert.assertTrue(welcomePage.getCheckboxLegalDrinkingAge().isDisplayed());
        Assert.assertTrue(welcomePage.getSelectedDropdown().isDisplayed());
        Assert.assertTrue(welcomePage.getWelcomeButton().isDisplayed());
        Assert.assertFalse(welcomePage.getWelcomeButton().isEnabled());


    }
    @Description("Case 2: Welcome page: navigate to main page as European customer")
    @Test (description = "Case2")
//1. Tick on checkbox
//2. Select “Europe” from dropbox
//3. Press “Welcome” button
//4. Main page should be displayed
    public void navigateToMainPage (){

        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.getCheckboxLegalDrinkingAge().click();

        Select dropdownSelect = new Select(welcomePage.getDropdownSelect());
        dropdownSelect.selectByValue("eu");

        MainPage mainPage = welcomePage.clickOnWelcomeButton();
        Assert.assertTrue(mainPage.getWelcomeLogo().isDisplayed());

    }
    @Description ("Case 3: Main page: all required elements are displayed")
    @Test (description = "Case3")
//1. Navigate to main page
//2. Verify that the following elements are displayed:
//- menu button
//- WELCOME TO THE WORLD OF [Yellow tail]
//- We are passionate about creating great tasting, quality wines for everyone to enjoy
//- find your wine button
//- footer
    public void isElementsDisplayedMainPage (){
        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPage();

        Assert.assertTrue(mainPage.getMenuButton().isDisplayed());
        Assert.assertTrue(mainPage.getWelcomeToTheWorldLogo().isDisplayed());
        Assert.assertTrue(mainPage.getWeArePassionateParagraph().isDisplayed());
        Assert.assertTrue(mainPage.getFindYourWineButton().isDisplayed());
        Assert.assertTrue(mainPage.getFooter().isDisplayed());

    }
    @Description("Case 4: Main page: Menu button logic (open header)")
    @Test (description = "Case4")
//1. Navigate to main page
//2. Click on Menu button
//3. Verify that header with all needed links is appeared
    public void openHeader(){
        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage();
        MenuBar menuBar = mainPage.navigateToMenuBar();
        Waiters.waitForElementToBeVisible(menuBar.getYellowTailLogo());
        Assert.assertTrue(menuBar.getYellowTailLogo().isDisplayed());
        Assert.assertTrue(menuBar.getWhereToBuyNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getWinesNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getCocktailsNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getOurStoryNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getFAQsNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getContactNavigation().isDisplayed());
        Assert.assertTrue(menuBar.getGlobeDropdown().isDisplayed());

    }
    @Description("Case 5: Main page: Menu button logic (close header)")
    @Test (description = "Case5")
//1. Navigate to main page
//2. Click on Menu button
//3. Click on [yellow tail]
//4. Verify that Menu button is visible
    public void closeHeader(){
        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       MainPage mainPage = new MainPage();
        MenuBar menuBar = mainPage.navigateToMenuBar();
        Waiters.waitForElementToBeVisible(menuBar.getYellowTailLogo());
        menuBar.getYellowTailLogo().click();
        Assert.assertTrue(mainPage.getMenuButton().isDisplayed());

        }
        @Description("Case 6: Main page: Global Nav logic")
        @Test (description = "Case6")

//        1. Navigate to main page
//        2. Click on Menu button
//        3. Click on Globe icon
//        4. Select China in popup and click on it
//        5. Verify that language is changed
        public void verifyIsLanguageChanged() {
            DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            MainPage mainPage = new MainPage();
            MenuBar menuBar = mainPage.navigateToMenuBar();
            Waiters.waitForElementToBeVisible(menuBar.getYellowTailLogo());
            menuBar.getGlobeDropdown().click();
            menuBar.getChinaLanguageSelect().click();

        Assert.assertTrue(DriverProvider.INSTANCE.getDriver().getCurrentUrl().contains("cn"));

    }
    @Description("Case 8: Where to buy: enter valid postal code")
    @Test (description = "Case7")
//1. Navigate to “Where to buy” page
//2. Enter valid data in “Your location” field
//3. Click on Search button
//4. Verify that the results of search are displayed

    public void enterValidPostalCode() {
        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        MainPage mainPage = new MainPage();
        WhereToBuyPage whereToBuyPage = mainPage.navigateToMenuBar().clickOnWhereToBuyNavigation();
        whereToBuyPage.getLocationNameField().click();
        whereToBuyPage.getLocationNameField().sendKeys("Sydney");
        whereToBuyPage.getSearchSubmitButton().click();

        Assert.assertTrue(whereToBuyPage.getStockInEnteredArea().isDisplayed());
    }

    @Description("Case 9: Cocktails: Select one wine")
    @Test (description = "Case8")
//1. Navigate to “Cocktails” page
//2. Select “Red wine cocktails”
//3. Verify that 9 recipes are displayed
    public void verifyRecipesAreDisplayed () {
        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        MainPage mainPage = new MainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToMenuBar().clickOnCocktailsNavigation();
        cocktailsPage.getSelectWineForCocktails().click();
        cocktailsPage.getRedWineElement().click();
        Assert.assertEquals(cocktailsPage.getRedWineRecipes().size(), 9);

    }
    @Description("Case 10: Cocktails: Navigate to Cocktail recipe page")
    @Test (description = "Case9")
//1. Navigate to “Cocktails” page
//2. Scroll to “RASPBERRY ROSÉ” recipe
//3. Click on “RASPBERRY ROSÉ” recipe
//4. Verify that new page is displayed:
//   - ingredients section is displayed
    public void verifyRaspberryRosePageIsDisplayed () {
        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToMenuBar().clickOnCocktailsNavigation();
        Actions actions = new Actions(DriverProvider.INSTANCE.getDriver());
        actions.moveToElement(cocktailsPage.getRaspberryRoseRecipe());
        actions.perform();
        cocktailsPage.getRaspberryRoseRecipe().click();
        Assert.assertTrue(cocktailsPage.getRecipeTitle().isDisplayed());
        Assert.assertTrue(cocktailsPage.getIngredientsSection().isDisplayed());

    }
    @Description("Case 11: Cocktails: Select several wines")
    @Test (description = "Case10")
//1. Navigate to “Cocktails” page
//2. Select “Red wine cocktails”
//3. Select “Sparkling wine cocktails”
//4. Verify that “Multiple” word is displayed in “Type” dropdown
//5. Verify that 18 recipes are displayed
    public void testSelectSeverWines (){

        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToMenuBar().clickOnCocktailsNavigation();
        cocktailsPage.getCocktailsNavigation().click();
        cocktailsPage.getSelectWineForCocktails().click();
        cocktailsPage.getRedWineElement().click();
        cocktailsPage.getSparklingWine().click();
        Assert.assertTrue(cocktailsPage.getMultipleSelect().isDisplayed());
        Assert.assertEquals(cocktailsPage.getRedWineRecipes().size(), 20);

    }






}
