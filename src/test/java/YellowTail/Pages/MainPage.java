package YellowTail.Pages;

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


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getWelcomeLogo() {
        return welcomeLogo;
    }

    public WebElement getMenuButton() {
        return menuButton;
    }

    public WebElement getWelcomeToTheWorldLogo() {
        return welcomeToTheWorldLogo;
    }
    public WebElement getWeArePassionateParagraph() {
        return weArePassionateParagraph;
    }
    public WebElement getFindYourWineButton() {
        return findYourWineButton;
    }
    public WebElement getFooter() {
        return footer;
    }
    public MenuBar clickOnMenuButton(){
        getMenuButton().click();
        return new MenuBar(driver);
    }
}
