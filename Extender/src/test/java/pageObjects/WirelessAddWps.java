package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sky.common.BrowserFactory;

public class WirelessAddWps extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public WirelessAddWps(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this);
    }
  
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy\"]/h1")
    @CacheLookup
    public WebElement homeHeader; 
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form[1]/div[2]/input")
    @CacheLookup
    public WebElement wpsPush;  
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form[1]/div[3]/input[1]")
    @CacheLookup
    public WebElement wpsPin;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form[1]/div[3]/input[2]")
    @CacheLookup
    public WebElement wpsPinEntry; 
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form[1]/a/span")
    @CacheLookup
    public WebElement wpsAdd;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form[2]/div[2]/div[1]/select")
    @CacheLookup
    public WebElement wpsAPMode24;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form[2]/div[2]/div[2]/select")
    @CacheLookup
    public WebElement wpsAPMode5;    

    @FindBy(how = How.XPATH, using = "//*[@id=\"wpspin\"]")
    @CacheLookup
    public WebElement wpsCurrentPin;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[1]/span")
    @CacheLookup
    public WebElement cancel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[2]/span")
    @CacheLookup
    public WebElement Apply;   
    
}
