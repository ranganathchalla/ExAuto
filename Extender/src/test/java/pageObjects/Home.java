package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	
	private BrowserFactory browserFactory;
	
	public Home(WebDriver driver)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(driver,this);
     //   this.browserFactory.getDriver();
    }	
		
    @FindBy(how = How.XPATH, using = "//*[@id=\"header-title\"]/a")
    @CacheLookup
    public WebElement goHome;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy-index\"]/h1")
    @CacheLookup
    public WebElement homeHeader;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[1]/div[2]/span[2]")
    @CacheLookup
    public WebElement hmeConState;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[4]/span[2]")
    @CacheLookup
    public WebElement hmeWirelessState;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[5]/span[2]")
    @CacheLookup
    public WebElement hmeWirelessSSID;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[6]/span[2]")
    @CacheLookup
    public WebElement hmeWirelessNetworkVisible;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[7]/span[2]")
    @CacheLookup
    public WebElement hmeWirelessChannel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[8]/span[2]")
    @CacheLookup
    public WebElement hmeWirelessEncryption;    
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a/span")
    @CacheLookup
    public WebElement refresh;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[2]/div/div/ul/li[1]/a")
    @CacheLookup
    public WebElement furtherDiagnosticHelp;   
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[2]/div/div/ul/li[2]/a")
    @CacheLookup
    public WebElement changeAdminPassword;
  
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[2]/div/div/ul/li[3]/a")
    @CacheLookup
    public WebElement DisEnableWireless;
    
    @FindBy(how = How.LINK_TEXT, using = "Revert to factory default settings")
    @CacheLookup
    public WebElement revertFactory;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[2]/div/div/ul/li[5]/a")
    @CacheLookup
    public WebElement reboot;
    
    public String getPageHeading() {
    	return homeHeader.getText();
    } 
    
    public void click(WebElement element) {  	    	
    	
    	//WebDriverWait wait=new WebDriverWait(browserFactory.getDriver(), 20);
    	//wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    	element.click();
    } 
        
}
