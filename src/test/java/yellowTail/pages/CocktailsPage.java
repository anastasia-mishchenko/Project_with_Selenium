package yellowTail.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import yellowTail.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CocktailsPage {
    WebDriver driver;
    @FindBy (xpath = "//div[@class='main-nav']//span[text()='Cocktails']")
    private SelenideElement cocktailsNavigation;
    @FindBy (xpath = "//a[@class='selected']")
    private SelenideElement selectWineForCocktails;
    @FindBy (xpath = "//a[@data-value='red']")
    private SelenideElement redWineElement;
    @FindBy (xpath = "//div[@class='tile recipe-tile']")
    private ElementsCollection redWineRecipes;
    @FindBy (xpath = "//h2[contains(text(),'Raspberry Rosé')]")
    private SelenideElement raspberryRoseRecipe;
    @FindBy (xpath = "//h1[@class='recipe-title']")
    private SelenideElement recipeTitle;
    @FindBy (xpath = "//h3[contains(text(),'Ingredients')]")
    private SelenideElement ingredientsSection;
    @FindBy (xpath = "//a[@data-value='bubbles']")
    private SelenideElement sparklingWine;
    @FindBy (xpath = "//span[contains(text(),'Multiple')]")
    private SelenideElement multipleSelect;


//    public CocktailsPage () {
//        this.driver = DriverProvider.INSTANCE.getDriver();
//        PageFactory.initElements(driver,this);
//    }
    public SelenideElement getCocktailsNavigation(){
        return cocktailsNavigation;
    }
    public SelenideElement getSelectWineForCocktails(){
        return selectWineForCocktails;
    }
    public SelenideElement getRedWineElement(){
        return redWineElement;
    }
    public ElementsCollection getRedWineRecipes(){
        return redWineRecipes;
    }
    public SelenideElement getRaspberryRoseRecipe(){
        return raspberryRoseRecipe;
    }
    public SelenideElement getRecipeTitle(){
        return recipeTitle;
    }
    public SelenideElement getIngredientsSection(){
        return ingredientsSection;
    }
    public SelenideElement getSparklingWine(){
        return sparklingWine;
    }
    public SelenideElement getMultipleSelect(){
        return multipleSelect;
    }






}
