package com.sky.common;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jscape.inet.telnet.TelnetException;
import com.sky.common.BrowserFactory;

import com.sky.common.CPEException;
import com.sky.common.CommonAutomationLogger;


import pageObjects.*;

import static common.constants.CommonConstants.*;
public class CommonExecutionHelper extends BrowserFactory {
	private BrowserFactory browserFactory;
	private CommonProperties commonProperties = new CommonProperties();
	private Home home;
	private Advanced advanced ;
	private Diagnostics diagnostics;
	private Ethernet ethernet;
	private WebHeader webHeader;
	private WirelessAddWps wirelessAddWps;
	private Wireless5ghz wireless5ghz;
	private Wireless24ghz wireless24ghz;
	private Upgrade upgrade;
	private Support support;
	private Maintenance maintenance;
	private MainSetPassword mainSetPassword;
	private MainDefaultSettings  mainDefaultSettings;
	private Licence licence;

	public CommonExecutionHelper() {};
	private static Logger logger = Logger.getLogger(CommonExecutionHelper.class);
	public CommonExecutionHelper(BrowserFactory browserFactory) {
		this.browserFactory = browserFactory;
		try
		{
			//browserFactory = new BrowserFactory();
			advanced = new Advanced(this.browserFactory);
			diagnostics  = new Diagnostics(this.browserFactory);
			ethernet  = new Ethernet(this.browserFactory);
			webHeader = new WebHeader(this.browserFactory);
			//	home = new Home(browserFactory.getDriver());

			wirelessAddWps = new WirelessAddWps(this.browserFactory);
			wireless5ghz  = new Wireless5ghz(this.browserFactory);
			wireless24ghz  = new Wireless24ghz(this.browserFactory);
			upgrade  = new Upgrade(this.browserFactory);
			support = new Support(this.browserFactory);
			maintenance = new Maintenance(this.browserFactory);
			mainSetPassword = new MainSetPassword(this.browserFactory);
			licence= new Licence(this.browserFactory);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void RestoreFactoryDefaults() throws InterruptedException	 {

		boolean status = false;
		String expected_StatusValue = "Your Sky Booster 2 is rebooting";			

		// Selecting Restore to factory		
		browserFactory = new BrowserFactory();
		home = new Home(browserFactory.getDriver());

		//home.click(home.revertFactory);
		home.revertFactory.click();
		System.out.println("Clicked RestoreFactoryDefault Link");	
		browserFactory.wait(3);
		//Assert.assertEquals("Revert to Factory Settings",mainDefaultSettings.homeHeader.getText());
		mainDefaultSettings= new MainDefaultSettings(this.browserFactory);
		mainDefaultSettings.yes.click();

		System.out.println("Clicked YES button Success");		
		browserFactory.wait(90);
		//Assert.assertEquals(expected_StatusValue,mainDefaultSettings.homeHeader.getText());

		logger.info("Success: Revert to Factory Settings page ");		
	}

	public void doFirmwareUpgrade() throws WebDriverException {

		// Properties from Common property xml - common-properties.xml
		String latestImage = commonProperties
				.getPropertyFromXMLFile("LatestImagePath");
		System.out.println("Firmware Image path is: " + latestImage);

		File file = new File(latestImage);

		if (!file.exists()) {
			logger.info("Firmware image file: " + latestImage
					+ " does not exist");


		}
		webHeader  = new WebHeader(this.browserFactory);
		webHeader.navigateMaintenance();
		webHeader.boosterUpgrade.click();
		upgrade  = new Upgrade(this.browserFactory);
		upgrade.modifyFirmware(latestImage);		
		System.out.println("updated the firmware ");
	}

	public void verifyFirmwareUpgrade()
			throws WebDriverException, InterruptedException {
		String exp_FirmwareVersion = commonProperties
				.getPropertyFromXMLFile("FirmwareVersion_New");
		webHeader  = new WebHeader(this.browserFactory);
		webHeader.maintenance.click();
		maintenance = new Maintenance(this.browserFactory);
		System.out.println("Firmware is "+ maintenance.mainFirmware.getText());
		Assert.assertEquals(exp_FirmwareVersion,maintenance.mainFirmware.getText());
	}	

	public boolean verifyHomePageDisplayed()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {

			String expPageValue = "Summary Status";
			home = (Home) getPage("Home");			
			home.goHome.click();
			logger.info("Home page tile is \""+home.homeHeader.getText()+"\"");
			if(!home.homeHeader.getText().contains(expPageValue))
			{
				logger.error("Failure: Unable to navigate to Home Summary Status Page");
				return false;
			}
		} catch (WebDriverException | ClassNotFoundException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToMaintenancePage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String expMaintenancePageValue = "Sky Booster 2 Status";
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.maintenance.click();
			maintenance = new Maintenance(this.browserFactory);
			if(!maintenance.homeHeader.getText().contains(expMaintenancePageValue))
			{
				logger.error("Failure: Unable to navigate to Maintenance Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToAdvancedPage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String expAdvancedPageValue = "LAN TCP/IP Setup";
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.advanced.click();
			advanced = new Advanced(this.browserFactory);
			if(!advanced.homeHeader.getText().contains(expAdvancedPageValue))
			{
				logger.error("Failure: Unable to navigate to Advanced Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToDiagnosticsPage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String expDiagnosticsPageValue = "Logs";
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.diagnostics.click();
			diagnostics = new Diagnostics(this.browserFactory);
			if(!diagnostics.homeHeader.getText().contains(expDiagnosticsPageValue))
			{
				logger.error("Failure: Unable to navigate to Diagnostics Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToEthernetPage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String expEthernetPageValue = "Ethernet Setup";
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.ethernet.click();
			ethernet = new Ethernet(this.browserFactory);
			if(!ethernet.homeHeader.getText().contains(expEthernetPageValue))
			{
				logger.error("Failure: Unable to navigate to Ethernet Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToWirelessPage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String[] exWirelessPageValue = {"2.4 GHz Wireless Settings","5 GHz Wireless Settings"};
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.wireless.click();
			wireless24ghz = new Wireless24ghz(this.browserFactory);

			if(!Arrays.asList(exWirelessPageValue).contains(wireless24ghz.homeHeader.getText()))
			{
				logger.error("Failure: Unable to navigate to Wireless Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}
	public boolean navigateTo5GWirelessPage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String exWireless5GhzPageValue = "5 GHz Wireless Settings";
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.wireless.click();
			webHeader.wireless5ghz.click();
			wireless5ghz = new Wireless5ghz(this.browserFactory);
			if(!wireless5ghz.homeHeader.getText().contains(exWireless5GhzPageValue))
			{
				logger.error("Failure: Unable to navigate to Wireless 5Ghz Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToSupportPage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String exSupportPageValue = "Support";
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.support.click();
			support = new Support(this.browserFactory);
			if(!support.homeHeader.getText().contains(exSupportPageValue))
			{
				logger.error("Failure: Unable to navigate to support Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToLicencePage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String exLicencePageValue = "Licence Information";
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.licence.click();
			licence = new Licence(this.browserFactory);
			if(!licence.homeHeader.getText().contains(exLicencePageValue))
			{
				logger.error("Failure: Unable to navigate to Licence Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToDefaultSettingsPage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String exDefaultSettingsPageValue = "Revert to Factory Settings";
			navigateToMaintenancePage();
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.defaultSettings.click();
			mainDefaultSettings = new MainDefaultSettings(this.browserFactory);
			if(!mainDefaultSettings.homeHeader.getText().contains(exDefaultSettingsPageValue))
			{
				logger.error("Failure: Unable to navigate to Default Settings Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToSetPasswordPage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String exSetPasswordPageValue = "Set password";
			navigateToMaintenancePage();
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.setPassword.click();
			mainSetPassword = new MainSetPassword(this.browserFactory);
			logger.info(mainSetPassword.homeHeader.getText());
			if(!mainSetPassword.homeHeader.getText().contains(exSetPasswordPageValue))
			{
				logger.error("Failure: Unable to navigate to Set password Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToUpgradePage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String exUpgradePageValue = "Sky Booster 2 Upgrade";
			navigateToMaintenancePage();
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.boosterUpgrade.click();
			upgrade = new Upgrade(this.browserFactory);
			if(!upgrade.homeHeader.getText().contains(exUpgradePageValue))
			{
				logger.error("Failure: Unable to navigate to Set password Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToAddWpsPage()
			throws WebDriverException, InterruptedException {

		boolean status = true;
		try {
			String exAddWpsPageValue = "Add WPS Client";
			navigateToWirelessPage();
			webHeader  = new WebHeader(this.browserFactory);
			webHeader.addWPS.click();
			wirelessAddWps = new WirelessAddWps(this.browserFactory);
			if(!wirelessAddWps.homeHeader.getText().contains(exAddWpsPageValue))
			{
				logger.error("Failure: Unable to navigate to Add WPS  Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public boolean navigateToPage(String page)
			throws WebDriverException, InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		boolean status = true;
		try {

			String expPageValue = "Summary Status";

			logger.info("Navigating to Home page");			
			home = (Home) getPage(page);			
			home.goHome.click();	
			//home.hmeWirelessSSID
			//home.click("home");
			if(!home.homeHeader.getText().contains(expPageValue))
			{
				logger.error("Failure: Unable to navigate to Home Summary Status Page");
				return false;
			}
		} catch (WebDriverException interruptionException) {
			logger.error(interruptionException
					+ interruptionException.getMessage());
		}		
		return status;
	}

	public Object getPage(String page) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException{
		
		browserFactory = new BrowserFactory();
		logger.info("Navigating to page "+page);
		String page1 = "pageObjects."+page;
		Constructor<?> con = Class.forName(page1).getConstructor(WebDriver.class);		
		try {			
				
			switch (page)
			{
			case "addWPS":				
				wirelessAddWps = (WirelessAddWps) con.newInstance(browserFactory.getDriver());
				return wirelessAddWps; 				
			case "Home":				
				home = (Home) con.newInstance(browserFactory.getDriver());
				return home;        	
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		logger.info("Returing null");     
		return null; 
	}

	public String getValueFromPage(String page,String element)throws WebDriverException, InterruptedException	{

	//	stringToWebelementSwitcher(page).
		return "xyz";
	}
	
	public boolean verifyElementOnPage()throws WebDriverException, InterruptedException	{


		return true;
	}

	public void updateCorePattern(String dut,CommonAutomationLogger logger) throws InterruptedException,
	CPEException {

		CPETelnetClient client;
		try {
			client = new CPETelnetClient(dut);
			client.updateCorePattern();
			Thread.sleep(10000);
			client.closeConnection();
			System.out.println("Updated core pattern");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TelnetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

	public void getCoreDumps(String dut,CommonAutomationLogger logger) throws InterruptedException,
	CPEException {

		CPETelnetClient client;
		try {
			client = new CPETelnetClient(dut);
			client.getCoreDumps();
			Thread.sleep(10000);
			client.closeConnection();
			System.out.println("Updated core pattern");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TelnetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}