package yellowTail;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import yellowTail.pages.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YellowTailSiteTest extends TestNgRunner{


//    @Description (" Case 1: Welcome page: all required elements are displayed")
    @Test (description = "Case1")
//1. Go to Welcome page: https://www.yellowtailwine.com
//2. Verify that “I am of legal drinking age in” is displayed
//3. Verify that checkbox before “I am of legal drinking age in” is displayed
//4. Verify that dropdown with Select is displayed
//5. Verify that “Welcome” button is displayed and is inactive
    public void isElementDisplayedWelcomePage() {

        WelcomePage welcomePage = open(Constants.YELLOW_TILE_SITE_URL, WelcomePage.class);

        welcomePage.getLegalDrinkingAgeField().shouldBe(Condition.visible);
        welcomePage.getCheckboxLegalDrinkingAge().shouldBe(Condition.visible);
        welcomePage.getSelectedDropdown().shouldBe(Condition.visible);
        welcomePage.getWelcomeButton().shouldBe(Condition.visible);
        welcomePage.getWelcomeButton().shouldBe(Condition.disabled);

    }
//    @Description("Case 2: Welcome page: navigate to main page as European customer")
    @Test (description = "Case2")
//1. Tick on checkbox
//2. Select “Europe” from dropbox
//3. Press “Welcome” button
//4. Main page should be displayed
    public void navigateToMainPage (){

        WelcomePage welcomePage = open(Constants.YELLOW_TILE_SITE_URL, WelcomePage.class);
        welcomePage.getCheckboxLegalDrinkingAge().click();
        welcomePage.getDropdownSelect().selectOptionByValue("eu");

        MainPage mainPage = welcomePage.clickOnWelcomeButton();
        mainPage.getWelcomeLogo().shouldBe(Condition.visible);

    }
//    @Description ("Case 3: Main page: all required elements are displayed")
    @Test (description = "Case3")
//1. Navigate to main page
//2. Verify that the following elements are displayed:
//- menu button
//- WELCOME TO THE WORLD OF [Yellow tail]
//- We are passionate about creating great tasting, quality wines for everyone to enjoy
//- find your wine button
//- footer
    public void isElementsDisplayedMainPage (){
        WelcomePage welcomePage = open(Constants.YELLOW_TILE_SITE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        mainPage.getMenuButton().shouldBe(Condition.visible);
        mainPage.getWelcomeToTheWorldLogo().shouldBe(Condition.visible);
        mainPage.getWeArePassionateParagraph().shouldBe(Condition.visible);
        mainPage.getFindYourWineButton().shouldBe(Condition.visible);
        mainPage.getFooter().shouldBe(Condition.visible);

    }
//    @Description("Case 4: Main page: Menu button logic (open header)")
    @Test (description = "Case4")
//1. Navigate to main page
//2. Click on Menu button
//3. Verify that header with all needed links is appeared
    public void openHeader(){
        WelcomePage welcomePage = open(Constants.YELLOW_TILE_SITE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        MenuBar menuBar = mainPage.navigateToMenuBar();
        menuBar.getYellowTailLogo().shouldBe(Condition.visible);
        menuBar.getWhereToBuyNavigation().shouldBe(Condition.visible);
        menuBar.getWinesNavigation().shouldBe(Condition.visible);
        menuBar.getCocktailsNavigation().shouldBe(Condition.visible);
        menuBar.getOurStoryNavigation().shouldBe(Condition.visible);
        menuBar.getFAQsNavigation().shouldBe(Condition.visible);
        menuBar.getContactNavigation().shouldBe(Condition.visible);
        menuBar.getGlobeDropdown().shouldBe(Condition.visible);

    }
//    @Description("Case 5: Main page: Menu button logic (close header)")
    @Test (description = "Case5")
//1. Navigate to main page
//2. Click on Menu button
//3. Click on [yellow tail]
//4. Verify that Menu button is visible
    public void closeHeader(){
        WelcomePage welcomePage = open(Constants.YELLOW_TILE_SITE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        MenuBar menuBar = mainPage.navigateToMenuBar();

        menuBar.getYellowTailLogo().click();
        mainPage.getMenuButton().shouldBe(Condition.visible);

        }
//        @Description("Case 6: Main page: Global Nav logic")
        @Test (description = "Case6")

//        1. Navigate to main page
//        2. Click on Menu button
//        3. Click on Globe icon
//        4. Select China in popup and click on it
//        5. Verify that language is changed
        public void verifyIsLanguageChanged() {
            WelcomePage welcomePage = open(Constants.YELLOW_TILE_SITE_URL, WelcomePage.class);
            MainPage mainPage = welcomePage.navigateToMainPage();
            MenuBar menuBar = mainPage.navigateToMenuBar();
            menuBar.getGlobeDropdown().click();
            menuBar.getChinaLanguageSelect().click();

        Assert.assertTrue(DriverProvider.INSTANCE.getDriver().getCurrentUrl().contains("cn"));

    }
//    @Description("Case 8: Where to buy: enter valid postal code")
    @Test (description = "Case7")
//1. Navigate to “Where to buy” page
//2. Enter valid data in “Your location” field
//3. Click on Search button
//4. Verify that the results of search are displayed

    public void enterValidPostalCode() {
        WelcomePage welcomePage = open(Constants.YELLOW_TILE_SITE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        WhereToBuyPage whereToBuyPage = mainPage.navigateToMenuBar().clickOnWhereToBuyNavigation();
        whereToBuyPage.getLocationNameField().click();
        whereToBuyPage.getLocationNameField().setValue("Sydney");
        whereToBuyPage.getSearchSubmitButton().click();

        whereToBuyPage.getStockInEnteredArea().shouldBe(Condition.visible);
    }

//    @Description("Case 9: Cocktails: Select one wine")
    @Test (description = "Case8")
//1. Navigate to “Cocktails” page
//2. Select “Red wine cocktails”
//3. Verify that 9 recipes are displayed
    public void verifyRecipesAreDisplayed () {
        WelcomePage welcomePage = open(Constants.YELLOW_TILE_SITE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToMenuBar().clickOnCocktailsNavigation();
        cocktailsPage.getSelectWineForCocktails().click();
        cocktailsPage.getRedWineElement().click();
        cocktailsPage.getRedWineRecipes().shouldHaveSize(9); //???

    }
//    @Description("Case 10: Cocktails: Navigate to Cocktail recipe page")
    @Test (description = "Case9")
//1. Navigate to “Cocktails” page
//2. Scroll to “RASPBERRY ROSÉ” recipe
//3. Click on “RASPBERRY ROSÉ” recipe
//4. Verify that new page is displayed:
//   - ingredients section is displayed
    public void verifyRaspberryRosePageIsDisplayed () {
        WelcomePage welcomePage = open(Constants.YELLOW_TILE_SITE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToMenuBar().clickOnCocktailsNavigation();
        cocktailsPage.getRaspberryRoseRecipe().scrollTo();

        cocktailsPage.getRaspberryRoseRecipe().click();
        cocktailsPage.getRecipeTitle().shouldBe(Condition.visible);
       cocktailsPage.getIngredientsSection().shouldBe(Condition.visible);

    }
//    @Description("Case 11: Cocktails: Select several wines")
    @Test (description = "Case10")
//1. Navigate to “Cocktails” page
//2. Select “Red wine cocktails”
//3. Select “Sparkling wine cocktails”
//4. Verify that “Multiple” word is displayed in “Type” dropdown
//5. Verify that 18 recipes are displayed
    public void testSelectSeverWines (){

        WelcomePage welcomePage = open(Constants.YELLOW_TILE_SITE_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.navigateToMainPage();
        CocktailsPage cocktailsPage = mainPage.navigateToMenuBar().clickOnCocktailsNavigation();;
        cocktailsPage.getCocktailsNavigation().click();
        cocktailsPage.getSelectWineForCocktails().click();
        cocktailsPage.getRedWineElement().click();
        cocktailsPage.getSparklingWine().click();
        cocktailsPage.getMultipleSelect().shouldBe(Condition.visible);
        cocktailsPage.getRedWineRecipes().shouldHaveSize(20);//???
    }






}
