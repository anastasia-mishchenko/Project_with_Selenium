package yellowTail.pages;

import io.qameta.allure.Step;
import yellowTail.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

   public WelcomePage(){
       this.driver = DriverProvider.INSTANCE.getDriver();
       PageFactory.initElements(driver,this);
   }
    @Step
    public WebElement getLegalDrinkingAgeField() {
       return legalDrinkingAgeField;
    }
    @Step
    public WebElement getCheckboxLegalDrinkingAge() {
        return checkboxLegalDrinkingAge;
    }
    @Step
    public WebElement getSelectedDropdown() {
     return selectedDropdown;
    }
    @Step
    public WebElement getWelcomeButton() {
       return welcomeButton;
    }
    @Step
    public WebElement getDropdownSelect() {
        return dropdownSelect;
    }
    @Step
    public MainPage clickOnWelcomeButton(){
       getWelcomeButton().click();
       return new MainPage();
    }
    @Step ("Navigate to Main page")
    public MainPage navigateToMainPage(){

       getCheckboxLegalDrinkingAge().click();

        Select dropdownSelect = new Select(getDropdownSelect());
        dropdownSelect.selectByValue("eu");

        welcomeButton.click();
        return new MainPage();
    }

}
