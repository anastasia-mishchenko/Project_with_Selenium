package YellowTail.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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



    public MenuBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getYellowTailLogo () {
        return yellowTailLogo;
    }
    public WebElement getWinesNavigation () {
        return winesNavigation;
    }
   public WebElement getWhereToBuyNavigation() {
      return whereToBuyNavigation;
   }
    public WebElement getCocktailsNavigation() {
        return cocktailsNavigation;
    }
    public WebElement getOurStoryNavigation() {
        return ourStoryNavigation;
    }
    public WebElement getFAQsNavigation() {
        return fAQsNavigation;
    }
    public WebElement getContactNavigation() {
        return contactNavigation;
    }
    public WebElement getGlobeDropdown() {
        return globeDropdown;
    }
    public WebElement getChinaLanguageSelect() {
        return chinaLanguageSelect;
    }
    public void waitForYellowTailLogo() {
        (new WebDriverWait(driver, 3)).until(
                ExpectedConditions.visibilityOf(yellowTailLogo));
    }

    public WhereToBuyPage clickOnWhereToBuyNavigation(){
        getWhereToBuyNavigation().click();
        return new WhereToBuyPage(driver);
    }
    public CocktailsPage clickOnCocktailsNavigation(){
        getCocktailsNavigation().click();
        return new CocktailsPage(driver);
    }

}
