package yellowTail.pages;

import io.qameta.allure.Step;
import yellowTail.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;
    @FindBy (xpath = "//span[text()='Welcome']")
    private WebElement welcomeLogo;
    @FindBy (xpath = "//span[text()='Menu']")
    private WebElement menuButton;
    @FindBy (xpath = "//div[@class='content animation-screen -one']/h2")
    private WebElement welcomeToTheWorldLogo;
    @FindBy (xpath = "//p[contains(text(),'We are passionate')]")
    private WebElement weArePassionateParagraph;
    @FindBy (xpath = "//div[@class='content animation-screen -one']/a")
    private WebElement findYourWineButton;
    @FindBy (xpath = "//footer")
    private WebElement footer;


    public MainPage() {
        this.driver = DriverProvider.INSTANCE.getDriver();
        PageFactory.initElements(driver, this);
    }
    @Step
    public WebElement getWelcomeLogo() {
        return welcomeLogo;
    }
    @Step
    public WebElement getMenuButton() {
        return menuButton;
    }
    @Step
    public WebElement getWelcomeToTheWorldLogo() {
        return welcomeToTheWorldLogo;
    }
    @Step
    public WebElement getWeArePassionateParagraph() {
        return weArePassionateParagraph;
    }
    @Step
    public WebElement getFindYourWineButton() {
        return findYourWineButton;
    }
    @Step
    public WebElement getFooter() {
        return footer;
    }
    @Step ("Click on Menu Button")
    public MenuBar clickOnMenuButton(){
        getMenuButton().click();
        return new MenuBar();
    }
    @Step ("Navigate to Menu Bar")
    public MenuBar navigateToMenuBar(){
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.navigateToMainPage();
        getMenuButton().click();
        return new MenuBar();
    }
}
