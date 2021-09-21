package YellowTail.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
   WebDriver driver;
   @FindBy (xpath = "//label[@for='confirm']")
   private WebElement legalDrinkingAgeField;
    @FindBy (xpath = "//label[@for='confirm']")
    private WebElement checkboxLegalDrinkingAge;
    @FindBy (xpath = "//select[@name='country']")
    private WebElement selectedDropdown;
    @FindBy (xpath = "//input[@type='submit']")
    private WebElement welcomeButton;
    @FindBy (xpath = "//select[@name='country']")
    private WebElement dropdownSelect;

   public WelcomePage(WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(driver,this);
   }

    public WebElement getLegalDrinkingAgeField() {
       return legalDrinkingAgeField;
    }
    public WebElement getCheckboxLegalDrinkingAge() {
        return checkboxLegalDrinkingAge;
    }
    public WebElement getSelectedDropdown() {
     return selectedDropdown;
    }
    public WebElement getWelcomeButton() {
       return welcomeButton;
    }
    public WebElement getDropdownSelect() {
        return dropdownSelect;
    }
    public MainPage clickOnWelcomeButton(){
       getWelcomeButton().click();
       return new MainPage(driver);
    }

}
