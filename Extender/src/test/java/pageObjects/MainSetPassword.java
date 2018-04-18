package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;

public class MainSetPassword extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public MainSetPassword(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this);
    }    
  
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy\"]/h1")
    @CacheLookup
    public WebElement homeHeader;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[2]/input")
    @CacheLookup
    public WebElement currentPassword;  
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[3]/input")
    @CacheLookup
    public WebElement newPassword;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[4]/input")
    @CacheLookup
    public WebElement newPasswordRepeat;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/form/div[5]/input")
    @CacheLookup
    public WebElement tiemout;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[1]/span")
    @CacheLookup
    public WebElement cancel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[2]/span")
    @CacheLookup
    public WebElement Apply;  
       
    
}
