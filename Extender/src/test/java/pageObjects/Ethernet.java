package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;

public class Ethernet extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public Ethernet(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this);
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy\"]/h1")
    @CacheLookup
    public WebElement homeHeader;  
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[1]/div/select")
    @CacheLookup
    public WebElement ethType;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[2]/select")
    @CacheLookup
    public WebElement enegryEffEth;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[1]/span")
    @CacheLookup
    public WebElement cancel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[2]/span")
    @CacheLookup
    public WebElement Apply;      
    
}
