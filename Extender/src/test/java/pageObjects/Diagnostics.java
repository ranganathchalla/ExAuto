package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;

public class Diagnostics extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public Diagnostics(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this);
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy\"]/h1")
    @CacheLookup
    public WebElement homeHeader;  
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div[2]/span[2]")
    @CacheLookup
    public WebElement CurrentTime;   
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"popup\"]")
    @CacheLookup
    public WebElement logData;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div[4]/a[1]/span")
    @CacheLookup
    public WebElement refresh;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div[4]/a[2]/span")
    @CacheLookup
    public WebElement clearLog;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div[4]/a[3]/span")
    @CacheLookup
    public WebElement saveLog;   
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"connections\"]")
    @CacheLookup
    public WebElement IncludeConnections;
  
    @FindBy(how = How.XPATH, using = "//*[@id=\"router\"]")
    @CacheLookup
    public WebElement IncludeRouterOps;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"disable\"]")
    @CacheLookup
    public WebElement disableSyslog;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"send\"]")
    @CacheLookup
    public WebElement sendSyslog;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form[3]/div[7]/input[2]")
    @CacheLookup
    public WebElement syslogIp1;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form[3]/div[7]/input[3]")
    @CacheLookup
    public WebElement syslogIp2;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form[3]/div[7]/input[4]")
    @CacheLookup
    public WebElement syslogIp3;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form[3]/div[7]/input[5]")
    @CacheLookup
    public WebElement syslogIp4;
   
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[1]/span")
    @CacheLookup
    public WebElement cancel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[2]/span")
    @CacheLookup
    public WebElement Apply;  
}
