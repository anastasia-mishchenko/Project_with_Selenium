package yellowTail.pages;

import com.codeborne.selenide.SelenideElement;
import yellowTail.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhereToBuyPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='locationName']")
    private SelenideElement locationNameField;
    @FindBy(xpath = "//button[@class='search-submit']")
    private SelenideElement searchSubmitButton;
    @FindBy(xpath = "//h3[@style='display: block;']")
    private SelenideElement stockInEnteredArea;

//    public WhereToBuyPage () {
//        this.driver = DriverProvider.INSTANCE.getDriver();
//        PageFactory.initElements(driver, this);
//    }
    public SelenideElement getLocationNameField(){
        return locationNameField;
    }
    public SelenideElement getSearchSubmitButton(){
        return searchSubmitButton;
    }
    public SelenideElement getStockInEnteredArea(){
        return stockInEnteredArea;
    }



}
