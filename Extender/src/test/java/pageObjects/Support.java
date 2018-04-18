package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;

public class Support extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public Support(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this);
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy\"]/h1")
    @CacheLookup
    public WebElement homeHeader;  
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"popup\"]")
    @CacheLookup
    public WebElement supportLogs;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div[2]/a/span")
    @CacheLookup
    public WebElement refresh;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[2]/div/div/ul/li[1]/a")
    @CacheLookup
    public WebElement supportLanLink;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[2]/div/div/ul/li[2]/a")
    @CacheLookup
    public WebElement SupportWirelessLink;
}
