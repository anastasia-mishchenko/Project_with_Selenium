package yellowTail.pages;


import com.codeborne.selenide.SelenideElement;
import yellowTail.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.page;

public class WelcomePage {
   WebDriver driver;
   @FindBy (xpath = "//label[@for='confirm']")
   private SelenideElement legalDrinkingAgeField;
    @FindBy (xpath = "//label[@for='confirm']")
    private SelenideElement checkboxLegalDrinkingAge;
    @FindBy (xpath = "//select[@name='country']")
    private SelenideElement selectedDropdown;
    @FindBy (xpath = "//input[@type='submit']")
    private SelenideElement welcomeButton;
    @FindBy (xpath = "//select[@name='country']")
    private SelenideElement dropdownSelect;

//   public WelcomePage() {
//       this.driver = DriverProvider.INSTANCE.getDriver();
//       PageFactory.initElements(driver, this);
//   }
    public SelenideElement getLegalDrinkingAgeField() {
       return legalDrinkingAgeField;
    }
    public SelenideElement getCheckboxLegalDrinkingAge() {
        return checkboxLegalDrinkingAge;
    }
    public SelenideElement getSelectedDropdown() {
     return selectedDropdown;
    }
    public SelenideElement getWelcomeButton() {
       return welcomeButton;
    }
    public SelenideElement getDropdownSelect() {
        return dropdownSelect;
    }
    public MainPage clickOnWelcomeButton(){
       getWelcomeButton().click();
       return page (MainPage.class);
    }
    public MainPage navigateToMainPage(){

       getCheckboxLegalDrinkingAge().click();
        getDropdownSelect().selectOptionByValue("eu");
        welcomeButton.click();
        return page(MainPage.class);
    }

}
