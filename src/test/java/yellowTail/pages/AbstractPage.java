package yellowTail.pages;

import yellowTail.DriverProvider;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    public AbstractPage(){
        PageFactory.initElements(DriverProvider.INSTANCE.getDriver(),this);
    }
    public void navigateToPage (String url) {DriverProvider.INSTANCE.getDriver().get(url);}
}
