package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import com.sky.common.BrowserFactory;

public class Upgrade extends BrowserFactory {
	
	private BrowserFactory browserFactory;

    public Upgrade(BrowserFactory browserFactory)
    {
        this.browserFactory = browserFactory;
        PageFactory.initElements(browserFactory.getDriver(),this);
    }
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-header-copy\"]/h1")
    @CacheLookup
    public WebElement homeHeader;  
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div[2]/form/input")
    @CacheLookup
    public WebElement chooseFile;   
      
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[1]/span")
    @CacheLookup
    public WebElement cancel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"content-body\"]/div[1]/div/a[2]/span")
    @CacheLookup
    public WebElement Apply;  
    
    public void modifyFirmware(String image) {
    	chooseFile.sendKeys(image);
    	Apply.click();
    	WebDriver driver=browserFactory.getDriver();
    	driver.switchTo().alert().accept();
    	System.out.println("THE ROUTER IS REBOOTING PLEASE WAIT .....");
    	browserFactory.wait(240);
    }
}
