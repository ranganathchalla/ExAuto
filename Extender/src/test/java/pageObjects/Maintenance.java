package pageObjects;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;


public class Maintenance extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public Maintenance(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this);
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy\"]/h1")
    @CacheLookup
    public WebElement homeHeader;  
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[2]/span[2]")
    @CacheLookup
    public WebElement mainManufacturer;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[3]/span[2]")
    @CacheLookup
    public WebElement mainModel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[4]/span[2]")
    @CacheLookup
    public WebElement mainFirmware;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[7]/span[2]")
    @CacheLookup
    public WebElement mainMAC;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[8]/span[2]")
    @CacheLookup
    public WebElement mainIPv4;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[9]/span[2]")
    @CacheLookup
    public WebElement mainMask;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[16]/span[2]/span")
    @CacheLookup
    public WebElement mainSSID;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[17]/span[2]/span")
    @CacheLookup
    public WebElement mainRegion;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[18]/span[2]/span")
    @CacheLookup
    public WebElement mainChannel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[19]/span[2]/span")
    @CacheLookup
    public WebElement mainAPState;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div/form/div[20]/span[2]/span")
    @CacheLookup
    public WebElement mainBroadcast;
    
    public String getElementText(WebElement element) {
    	return element.getText();
    } 
    
    

    
}
