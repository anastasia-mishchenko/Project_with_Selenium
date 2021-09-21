package YellowTail.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CocktailsPage {
    WebDriver driver;
    @FindBy (xpath = "//div[@class='main-nav']//span[text()='Cocktails']")
    private WebElement cocktailsNavigation;
    @FindBy (xpath = "//a[@class='selected']")
    private WebElement selectWineForCocktails;
    @FindBy (xpath = "//a[@data-value='red']")
    private WebElement redWineElement;
    @FindBy (xpath = "//div[@class='tile recipe-tile']")
    private List<WebElement> redWineRecipes;
    @FindBy (xpath = "//h2[contains(text(),'Raspberry Rosé')]")
    private WebElement raspberryRoseRecipe;
    @FindBy (xpath = "//h1[@class='recipe-title']")
    private WebElement recipeTitle;
    @FindBy (xpath = "//h3[contains(text(),'Ingredients')]")
    private WebElement ingredientsSection;
    @FindBy (xpath = "//a[@data-value='bubbles']")
    private WebElement sparklingWine;
    @FindBy (xpath = "//span[contains(text(),'Multiple')]")
    private WebElement multipleSelect;


    public CocktailsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getCocktailsNavigation(){
        return cocktailsNavigation;
    }
    public WebElement getSelectWineForCocktails(){
        return selectWineForCocktails;
    }
    public WebElement getRedWineElement(){
        return redWineElement;
    }
    public List<WebElement> getRedWineRecipes(){
        return redWineRecipes;
    }
    public WebElement getRaspberryRoseRecipe(){
        return raspberryRoseRecipe;
    }
    public WebElement getRecipeTitle(){
        return recipeTitle;
    }
    public WebElement getIngredientsSection(){
        return ingredientsSection;
    }
    public WebElement getSparklingWine(){
        return sparklingWine;
    }
    public WebElement getMultipleSelect(){
        return multipleSelect;
    }






}
