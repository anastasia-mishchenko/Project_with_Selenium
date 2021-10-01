package yellowTail.pages;

import io.qameta.allure.Step;
import yellowTail.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuBar {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='top-nav -active']//img[@alt='Yellow tail logo']")
    private WebElement yellowTailLogo;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='Wines']")
    private WebElement winesNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='Where To Buy']")
    private WebElement whereToBuyNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='Cocktails']")
    private WebElement cocktailsNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='Our Story']")
    private WebElement ourStoryNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='FAQs']")
    private WebElement fAQsNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='Contact']")
    private WebElement contactNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[@class='fa fa-globe fa-lg']")
    private WebElement globeDropdown;
    @FindBy(xpath = "//a[@data-key='CN']")
    private WebElement chinaLanguageSelect;



    public MenuBar() {
        this.driver = DriverProvider.INSTANCE.getDriver();
        PageFactory.initElements(driver,this);
    }
    @Step
    public WebElement getYellowTailLogo () {
        return yellowTailLogo;
    }
    @Step
    public WebElement getWinesNavigation () {
        return winesNavigation;
    }
    @Step
    public WebElement getWhereToBuyNavigation() {
      return whereToBuyNavigation;
   }
    @Step
    public WebElement getCocktailsNavigation() {
        return cocktailsNavigation;
    }
    @Step
    public WebElement getOurStoryNavigation() {
        return ourStoryNavigation;
    }
    @Step
    public WebElement getFAQsNavigation() {
        return fAQsNavigation;
    }
    @Step
    public WebElement getContactNavigation() {
        return contactNavigation;
    }
    @Step
    public WebElement getGlobeDropdown() {
        return globeDropdown;
    }
    @Step
    public WebElement getChinaLanguageSelect() {
        return chinaLanguageSelect;
    }
    @Step ("Navigate to WhereToBuy page")
    public WhereToBuyPage clickOnWhereToBuyNavigation(){
        getWhereToBuyNavigation().click();
        return new WhereToBuyPage();
    }
    @Step ("Click on Cocktails button in MenuBar")
    public CocktailsPage clickOnCocktailsNavigation(){
        getCocktailsNavigation().click();
        return new CocktailsPage();
    }

}
