package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;

public class Wireless24ghz extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public Wireless24ghz(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this);
    }
  
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy\"]/h1")
    @CacheLookup
    public WebElement homeHeader;  
 
    @FindBy(how = How.XPATH, using = "//*[@id=\"accesspoint\"]")
    @CacheLookup
    public WebElement wirelessState;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"EnblWps\"]")
    @CacheLookup
    public WebElement wpsState;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[1]/span")
    @CacheLookup
    public WebElement cancel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[2]/span")
    @CacheLookup
    public WebElement Apply;    
  
}
