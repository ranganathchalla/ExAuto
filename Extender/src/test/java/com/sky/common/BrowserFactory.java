package com.sky.common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.*;

public class BrowserFactory {
    private static   Map <String, WebDriver> Drivers = new HashMap <>();
    private static WebDriver driver;
    private static String currentPath = System.getProperty("user.dir");
    private static Properties  prop = new Properties();
    public WebDriver getDriver()
    {
      return  driver;
    }
    public static void setDriver(WebDriver value)
    {
        driver = value;
    }

    /***************************************************/
    public static WebDriver initBrowser(String strBrowserName)
    {
        //Get the Libraries Path
        String librariespath = currentPath + "/src/test/java/Libraries/" ;

        //Launch the Browser based on the Browser name
        switch (strBrowserName)
        {
            case "Firefox":
                    System.setProperty("webdriver.gecko.driver", librariespath+ "geckodriver");
                    driver = new FirefoxDriver();
                    Drivers.put("Firefox", driver);
                break;
            
            case "Chrome":
                if (driver == null) {
                    ChromeOptions options = new ChromeOptions();
                  //  String strOptions = "user-data-dir=C:\\Users\\" + new com.sun.security.auth.module.NTSystem().getName() + "\\AppData\\Local\\Google\\Chrome\\User Data";
                   // options.addArguments(strOptions);
                    options.addArguments("no-sandbox");
                    System.setProperty("webdriver.chrome.driver", librariespath + "chromedriver");
                    driver = new ChromeDriver(options);
                    Drivers.put("Chrome", driver);
                }
                break;
            case "Headless":
                if (driver == null)
                {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    System.setProperty("webdriver.chrome.driver", librariespath+ "chromedriver");
                    driver = new ChromeDriver(chromeOptions);
                    Drivers.put("Headless", driver);
                }
                break;
        }
        //Set the Timeouts
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
       // driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.switchTo().defaultContent();
        //Return the Driver
        return driver;
    }

    public static void loadApplication(String strUrl)
    {
        //Load the URL
    	//driver.close();
        driver.navigate().to(strUrl);
    }

    public static void closeAllDrivers()
    {
        //Loop through and Close all the browsers
        for (String key: Drivers.keySet())
        {
            //Drivers.get(key).close();
            Drivers.get(key).quit();
        }
        driver = null;
        Drivers.clear();

    }

    protected void mouseClick(WebElement objElement)
    {
        Actions action = new  Actions(getDriver());
        action.moveToElement(objElement).build().perform();
        this.wait(1);
        action.click(objElement).perform();
    }

    protected void enterText(WebElement objElement,String strText)
    {
        if (strText != null)
        {
            objElement.clear();
            objElement.sendKeys(strText);
            objElement.sendKeys(Keys.TAB);
        }
    }

    public static void selectText(WebElement objElement, String strText)
    {
        if (!strText.equals(""))
        {
            Select  select = new Select (objElement);
            select.selectByVisibleText(strText);
        }
    }

    public static void selectValue(WebElement objElement, String strValue)
    {
        if (!strValue.equals(""))
        {
            Select select = new Select(objElement);
            select.selectByValue(strValue);
        }
    }  
    
    
  /*  static
    {
        try
        {
            InputStream input = new FileInputStream(currentPath + "/src/test/java/Resources/config.properties");
            prop.load(input);
        } catch (Exception e){
            e.printStackTrace();
        }
    }*/
    

    public static void wait(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }

    public static void wait(double seconds)
    {
        try
        {
        Thread.sleep((int)seconds * 1000);
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }  

}

