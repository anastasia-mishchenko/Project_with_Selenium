package yellowTail.pages;

import io.qameta.allure.Step;
import yellowTail.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhereToBuyPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='locationName']")
    private WebElement locationNameField;
    @FindBy(xpath = "//button[@class='search-submit']")
    private WebElement searchSubmitButton;
    @FindBy(xpath = "//h3[@style='display: block;']")
    private WebElement stockInEnteredArea;

    public WhereToBuyPage () {
        this.driver = DriverProvider.INSTANCE.getDriver();
        PageFactory.initElements(driver,this);
    }
    @Step
    public WebElement getLocationNameField(){
        return locationNameField;
    }
    @Step
    public WebElement getSearchSubmitButton(){
        return searchSubmitButton;
    }
    @Step
    public WebElement getStockInEnteredArea(){
        return stockInEnteredArea;
    }



}
