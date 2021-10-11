package yellowTail.pages;


import com.codeborne.selenide.SelenideElement;
import yellowTail.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    WebDriver driver;
    @FindBy (xpath = "//span[text()='Welcome']")
    private SelenideElement welcomeLogo;
    @FindBy (xpath = "//span[text()='Menu']")
    private SelenideElement menuButton;
    @FindBy (xpath = "//div[@class='content animation-screen -one']/h2")
    private SelenideElement welcomeToTheWorldLogo;
    @FindBy (xpath = "//p[contains(text(),'We are passionate')]")
    private SelenideElement weArePassionateParagraph;
    @FindBy (xpath = "//div[@class='content animation-screen -one']/a")
    private SelenideElement findYourWineButton;
    @FindBy (xpath = "//footer")
    private SelenideElement footer;


//    public MainPage() {
//        this.driver = DriverProvider.INSTANCE.getDriver();
//        PageFactory.initElements(driver, this);
//    }

    public SelenideElement getWelcomeLogo() {
        return welcomeLogo;
    }
    public SelenideElement getMenuButton() {
        return menuButton;
    }
    public SelenideElement getWelcomeToTheWorldLogo() {
        return welcomeToTheWorldLogo;
    }
    public SelenideElement getWeArePassionateParagraph() {
        return weArePassionateParagraph;
    }
    public SelenideElement getFindYourWineButton() {
        return findYourWineButton;
    }
    public SelenideElement getFooter() {
        return footer;
    }
    public MenuBar clickOnMenuButton(){
        getMenuButton().click();
        return page (MenuBar.class);
    }
    public MenuBar navigateToMenuBar(){
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.navigateToMainPage();
        getMenuButton().click();
        return page(MenuBar.class);
    }
}
