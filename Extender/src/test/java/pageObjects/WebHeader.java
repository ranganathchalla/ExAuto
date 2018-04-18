package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;
import org.openqa.selenium.support.PageFactory;

public class WebHeader extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public WebHeader(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this );
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"topmenu\"]/li[1]/a")
    @CacheLookup
    public WebElement wireless;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"submenu-wireless\"]/li[1]/a")
    @CacheLookup
    public WebElement wireless24ghz;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"submenu-wireless\"]/li[2]/a")
    @CacheLookup
    public WebElement wireless5ghz;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"submenu-wireless\"]/li[3]/a")
    @CacheLookup
    public WebElement addWPS;    
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"topmenu\"]/li[2]/a")
    @CacheLookup
    public WebElement ethernet;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"topmenu\"]/li[3]/a")
    @CacheLookup
    public WebElement diagnostics;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"topmenu\"]/li[4]/a")
    @CacheLookup
    public WebElement maintenance;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"submenu-maintenance\"]/li[1]/a")
    @CacheLookup
    public WebElement boosterStatus;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"submenu-maintenance\"]/li[2]/a")
    @CacheLookup
    public WebElement defaultSettings;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"submenu-maintenance\"]/li[3]/a")
    @CacheLookup
    public WebElement setPassword;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"submenu-maintenance\"]/li[4]/a")
    @CacheLookup
    public WebElement boosterUpgrade;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"topmenu\"]/li[5]/a")
    @CacheLookup
    public WebElement advanced;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"topmenu\"]/li[6]/a")
    @CacheLookup
    public WebElement support;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"topmenu\"]/li[7]/a")
    @CacheLookup
    public WebElement licence;     

    
    @FindBy(how = How.XPATH, using = "//*[@id=\"logout\"]")
    @CacheLookup
    public WebElement logout;
    
  
    public void navigateWireless() {
    	wireless.click();
    }
    
    public void navigateMaintenance() {
    	maintenance.click();
    }
    
    public void navigateAdvance() {
    	advanced.click();
    }
    
    public void navigateLicence() {
    	licence.click();
    }
    
    public void navigateSupport() {
    	support.click();
    }
    
    public void navigateEthernet() {
    	ethernet.click();
    }
    
    public void navigateDiagnostics() {
    	diagnostics.click();
    }   
    
    public void navigateLogout() {
    	logout.click();
    }
}
