package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;

public class Advanced extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public Advanced(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this);
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy\"]/h1")
    @CacheLookup
    public WebElement homeHeader;  
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[2]/input")
    @CacheLookup
    public WebElement obtainIP; 
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[3]/input[1]")
    @CacheLookup
    public WebElement lanIP1;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[3]/input[2]")
    @CacheLookup
    public WebElement lanIP2;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[3]/input[3]")
    @CacheLookup
    public WebElement lanIP3;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[3]/input[4]")
    @CacheLookup
    public WebElement lanIP4;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[4]/input[1]")
    @CacheLookup
    public WebElement lanMask1;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[4]/input[2]")
    @CacheLookup
    public WebElement lanMask2;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[4]/input[3]")
    @CacheLookup
    public WebElement lanMask3;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[4]/input[4]")
    @CacheLookup
    public WebElement lanMask4;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[5]/input[1]")
    @CacheLookup
    public WebElement lanGateway1;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[5]/input[2]")
    @CacheLookup
    public WebElement lanGateway2;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[5]/input[3]")
    @CacheLookup
    public WebElement lanGateway3;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[5]/input[4]")
    @CacheLookup
    public WebElement lanGateway4;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[6]/input[1]")
    @CacheLookup
    public WebElement lanPNS1;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[6]/input[2]")
    @CacheLookup
    public WebElement lanPNS2;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[6]/input[3]")
    @CacheLookup
    public WebElement lanPNS3;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[6]/input[4]")
    @CacheLookup
    public WebElement lanPNS4;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[7]/input[1]")
    @CacheLookup
    public WebElement lanSNS1;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[7]/input[2]")
    @CacheLookup
    public WebElement lanSNS2;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[7]/input[3]")
    @CacheLookup
    public WebElement lanSNS3;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[7]/input[4]")
    @CacheLookup
    public WebElement lanSNS4;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[8]/input")
    @CacheLookup
    public WebElement lanPort;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[1]/span")
    @CacheLookup
    public WebElement cancel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[2]/span")
    @CacheLookup
    public WebElement Apply; 
    
}