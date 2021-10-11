package yellowTail.pages;

import com.codeborne.selenide.SelenideElement;
import yellowTail.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.page;

public class MenuBar {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='top-nav -active']//img[@alt='Yellow tail logo']")
    private SelenideElement yellowTailLogo;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='Wines']")
    private SelenideElement winesNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='Where To Buy']")
    private SelenideElement whereToBuyNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='Cocktails']")
    private SelenideElement cocktailsNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='Our Story']")
    private SelenideElement ourStoryNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='FAQs']")
    private SelenideElement fAQsNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[text()='Contact']")
    private SelenideElement contactNavigation;
    @FindBy(xpath = "//div[@class='main-nav']//span[@class='fa fa-globe fa-lg']")
    private SelenideElement globeDropdown;
    @FindBy(xpath = "//a[@data-key='CN']")
    private SelenideElement chinaLanguageSelect;



//    public MenuBar() {
//        this.driver = DriverProvider.INSTANCE.getDriver();
//        PageFactory.initElements(driver,this);
//    }

    public SelenideElement getYellowTailLogo () {
        return yellowTailLogo;
    }
    public SelenideElement getWinesNavigation () {
        return winesNavigation;
    }
    public SelenideElement getWhereToBuyNavigation() {
      return whereToBuyNavigation;
   }
    public SelenideElement getCocktailsNavigation() {
        return cocktailsNavigation;
    }
    public SelenideElement getOurStoryNavigation() {
        return ourStoryNavigation;
    }
    public SelenideElement getFAQsNavigation() {
        return fAQsNavigation;
    }
    public SelenideElement getContactNavigation() {
        return contactNavigation;
    }
    public SelenideElement getGlobeDropdown() {
        return globeDropdown;
    }
    public SelenideElement getChinaLanguageSelect() {
        return chinaLanguageSelect;
    }

    public WhereToBuyPage clickOnWhereToBuyNavigation(){
        getWhereToBuyNavigation().click();
        return page (WhereToBuyPage.class);
    }
    public CocktailsPage clickOnCocktailsNavigation(){
        getCocktailsNavigation().click();
        return page (CocktailsPage.class);
    }

}
