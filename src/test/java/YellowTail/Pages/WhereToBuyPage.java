package YellowTail.Pages;

import org.openqa.selenium.By;
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

    public WhereToBuyPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getLocationNameField(){
        return locationNameField;
    }
    public WebElement getSearchSubmitButton(){
        return searchSubmitButton;
    }
    public WebElement getStockInEnteredArea(){
        return stockInEnteredArea;
    }



}
