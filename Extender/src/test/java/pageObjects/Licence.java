package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;

public class Licence extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public Licence(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this);
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy\"]/h1")
    @CacheLookup
    public WebElement homeHeader;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/p[2]/a")
    @CacheLookup
    public WebElement licenceURL;
    
    public void linkLicence() {
    	licenceURL.click();
    } 

}
