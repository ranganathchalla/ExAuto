package com.sky.gui;

import static common.constants.CommonConstants.FAIL;
import static common.constants.CommonConstants.LOCALHOST;
import static common.constants.CommonConstants.NEW_LINE;
import static common.constants.CommonConstants.PASS;
import static common.constants.CommonConstants.WebDriver_EXCEPTION;
import static common.constants.CommonConstants.SLEEP_SIXTY_THOUSAND;
import static common.constants.CommonConstants.SLEEP_TWO_MINUTES;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import static com.sky.common.CommonAutomationLogger.*;
import static com.sky.common.CommonExecutionHelper.*;
import com.sky.common.BrowserFactory;
import com.sky.common.CommonAutomationLogger;
import com.sky.common.CommonExecutionHelper;
import com.sky.common.CommonProperties;
import com.sky.common.ProcessHandler;
import com.sky.fus.FWupgrade;

import pageObjects.Advanced;
import pageObjects.Diagnostics;
import pageObjects.Ethernet;
import pageObjects.Home;
import pageObjects.Licence;
import pageObjects.MainDefaultSettings;
import pageObjects.MainSetPassword;
import pageObjects.Maintenance;
import pageObjects.Support;
import pageObjects.Upgrade;
import pageObjects.WebHeader;
import pageObjects.Wireless24ghz;
import pageObjects.Wireless5ghz;
import pageObjects.WirelessAddWps;

public class GUIFunctionalTests {

	private String BASE_URL = null;
	private String boosterIP = null;
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
	private BrowserFactory browserFactory;

	//private static Logger logger = Logger.getLogger(FWupgrade.class);
	private CommonProperties commonProperties = new CommonProperties();

	//private static Logger logger = Logger.getLogger(GUIFunctionalTests.class);
	private static CommonAutomationLogger logger = CommonAutomationLogger.getLogger();

	String browser = null;

	CommonExecutionHelper executionHelper = new CommonExecutionHelper();

	String ExtenderSerialPort = commonProperties
			.getPropertyFromXMLFile("ExtenderSerialPort");

	Pattern pattern;

	Matcher matcher;

	private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	private static final String MACADDRESS_PATTERN = "^([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})$";

	String workingDir = System.getProperty("user.dir");

	@BeforeClass
	public static void beforeClass() {		
		logger.logStatus("Terminating processes");
		ProcessHandler.KillProcesses();
	}

	@Before
	public void setUp() throws Exception {
		maintenance = (Maintenance) getPage("Maintenance");
		home = (Home) getPage("Home");
		
		boosterIP = commonProperties.getPropertyFromXMLFile("BoosterIP");
		browser = commonProperties.getPropertyFromXMLFile("Browser");
		BrowserFactory browserFactory = new BrowserFactory();
		executionHelper = new CommonExecutionHelper(browserFactory);
		String indexUrl = commonProperties.getPropertyFromXMLFile("IndexUrl");
		logger.logStatus("indexUrl :" + indexUrl);	
		BrowserFactory.initBrowser(browser);
		BrowserFactory.loadApplication(indexUrl);		
		//executionHelper.RestoreFactoryDefaults();		
		//Thread.sleep(SLEEP_SIXTY_THOUSAND); //Looks like the device is not ready.
		//Update core_pattern to capture core dump
		//executionHelper.updateCorePattern(boosterIP,logger);
		logger.logStatus("************Opening The Browser******************");
	}
	@After
	public void afterClass() throws Exception {

		//Get core dump if available
		//executionHelper.getCoreDumps(boosterIP,logger);			
	}

	@Test
	public void test_GUI_SPEC_4() throws Exception {

		// String status = FAIL;

		String message = null;

		String testCaseID = "GUI-SPEC-4";

		String testCaseName = "Requiremnet ID :1000.0552: The product shall provide a summary status page";

		try {
			
			logTestCaseIDAndName(testCaseID, testCaseName);
			//boolean isSummaryPageDisplayed = executionHelper.verifyHomePageDisplayed();
			boolean isSummaryPageDisplayed = executionHelper.verifyHomePageDisplayed();
			if (!isSummaryPageDisplayed) {
				message = "Unable to display Summary page";
				logger.logErrMsg(message);
				logTestStatus(testCaseID, testCaseName, FAIL, message);
			}
			logger.logStatus(" Navigate to Home page is successful");
			logTestStatus(testCaseID, testCaseName, PASS, message);

		} catch (WebDriverException webDriverException) {		
			logger.logStatus(WebDriver_EXCEPTION + webDriverException);
			logTestStatus(testCaseID, testCaseName, FAIL,
					"Failure in Selenium elements");

		}
	}

	@Test
	public void test_GUI_SPEC_5() throws Exception {

		// String status = FAIL;

		String message = null;
		String testCaseID = "GUI-SPEC-5";
		String testCaseName = "Requiremnet ID :1000.0605: The product shall present the summary status page when the product's LAN IP address is entered as a URL within a web browser";

		try {

			logTestCaseIDAndName(testCaseID, testCaseName);		

			String ExtIndexPage = commonProperties.getPropertyFromXMLFile("IndexUrl");			
			String[] parts = ExtIndexPage.split("@");
			String[] splitparts = parts[1].split("/");			
			String ExtLanIP = splitparts[0];			
			String ext_base_url="http://"+ExtLanIP;	
			logger.logStatus(ext_base_url);
			BrowserFactory.loadApplication(ext_base_url);
			boolean isSummaryPageDisplayed = executionHelper.verifyHomePageDisplayed();
			checkforPage(isSummaryPageDisplayed,testCaseID,testCaseName,"Home Page");
			
			logTestStatus(testCaseID, testCaseName, PASS, message);			

		} catch (WebDriverException webDriverException) {			

			logger.logStatus(WebDriver_EXCEPTION + webDriverException);

			logTestStatus(testCaseID, testCaseName, FAIL,
					"Failure in Selenium elements");
		}
	}
	
	/**
	 * This automation script tests the Home banner click from all GUI pages
	 * 
	 * 1000.0260 The product shall provide a link that will return the user
	 * directly to the GUI home page from every page presented. Version : 1.0
	 * 	 
	 */

	@Test
	public void test_GUI_SPEC_11() throws Exception {

		// String status = FAIL;

		String message = null;

		String testCaseID = "GUI-SPEC-11";

		String testCaseName = "1000.0260 The product shall provide a link that will return the user directly to the GUI home page from every page presented";

		try {

			logTestCaseIDAndName(testCaseID, testCaseName);
			logger.logStatus("######################## Maintenance Page #########################");

			boolean isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();

			checkforPage(isMaintenancePageOpen,testCaseID,testCaseName,"Maintenance Page");	

			logger.logStatus(" Click Home Banner from Router Status page");

			boolean isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");

			isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();

			checkforPage(isMaintenancePageOpen,testCaseID,testCaseName,"Maintenance Page");		

			boolean isDefaultPageOpen = executionHelper.navigateToDefaultSettingsPage();

			checkforPage(isDefaultPageOpen,testCaseID,testCaseName,"Default Page");	

			logger.logStatus(" Click Home Banner from Backup Settings page");

			isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");

			isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();

			checkforPage(isMaintenancePageOpen,testCaseID,testCaseName,"Maintenance Page");
			// Checking Set password page
			boolean isSetPasswordPageOpen = executionHelper.navigateToSetPasswordPage();

			checkforPage(isSetPasswordPageOpen,testCaseID,testCaseName,"Set Password Page");			

			logger.logStatus("Clicked Set Password page link");
			logger.logStatus(" Click Home Banner from Set Password page");

			isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");

			isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();

			checkforPage(isMaintenancePageOpen,testCaseID,testCaseName,"Maintenance Page");

			// Checking Router Upgrade page

			boolean isUpgradePageOpen = executionHelper.navigateToUpgradePage();
			checkforPage(isUpgradePageOpen,testCaseID,testCaseName,"Upgrade Page");						
			logger.logStatus(" Click Home Banner from Router Upgrade page");

			isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");

			logger.logStatus("########################  Wireless Page #########################");

			boolean isWirelessPageOpen = executionHelper.navigateToWirelessPage();
			checkforPage(isWirelessPageOpen,testCaseID,testCaseName,"Wireless Page");			

			logger.logStatus(" Click Home Banner from Wireless Setting page");

			isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");

			boolean isWireless5GPageOpen = executionHelper.navigateTo5GWirelessPage();

			checkforPage(isWireless5GPageOpen,testCaseID,testCaseName,"Wireless 5GHz Page");	

			logger.logStatus(" Click Home Banner from Wireless Setting page");

			isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");

			// Wireless Page and its sub page checks start from here
			// Checking Wireless setting page

			//isWirelessPageOpen = executionHelper.navigateToWirelessPage();
			//checkforPage(isWirelessPageOpen,testCaseID,testCaseName,"Wireless Page");	

			Thread.sleep(12000);

			// Checking Add WPS client page
			boolean isAddwpsPageOpen = executionHelper.navigateToAddWpsPage();
			checkforPage(isAddwpsPageOpen,testCaseID,testCaseName,"Add Wps Page");				
			logger.logStatus(" Click Home Banner from Add WPS Client page");

			isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");

			logger.logStatus("########################  Security Page #########################");
			logger.logStatus("Security Page is not available for Extender hence Ignored");


			logger.logStatus("########################  Diagnostics Page #########################");

			boolean isExtDiagnosticsPageOpen = executionHelper.navigateToDiagnosticsPage();

			checkforPage(isExtDiagnosticsPageOpen,testCaseID,testCaseName,"Diagnostics Page");
			isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");				
			logger.logStatus("########################  Advanced Page #########################");

			boolean isAdvancePageOpen = executionHelper.navigateToAdvancedPage();

			checkforPage(isAdvancePageOpen,testCaseID,testCaseName,"Advance Page");

			isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");			

			logger.logStatus("########################  Support Page #########################");

			boolean isSupportPageOpen = executionHelper.navigateToSupportPage();

			checkforPage(isSupportPageOpen,testCaseID,testCaseName,"Support Page");

			logger.logStatus(" Click Home Banner from Support page");

			isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");

			logger.logStatus("########################  Licence Page #########################");

			boolean isLicencePageOpen = executionHelper.navigateToLicencePage();

			checkforPage(isLicencePageOpen,testCaseID,testCaseName,"Licence Page");	

			logger.logStatus(" Click Home Banner from Licence page");

			isHomePageOpen = executionHelper.verifyHomePageDisplayed();

			checkforPage(isHomePageOpen,testCaseID,testCaseName,"Home Page");		

			logger.logStatus("************Closing The Browser******************");

			logTestStatus(testCaseID, testCaseName, PASS, message);

		} catch (WebDriverException webDriverException) {			

			logger.logStatus(WebDriver_EXCEPTION + webDriverException);

			logTestStatus(testCaseID, testCaseName, FAIL,"Failure in Selenium elements");

		}
	}

	/**
	 * This automation script test
	 * 
	 * 1000.0362 The product shall inform the user of the wireless access point
	 * SSID name when the user requests to view wireless settings 
	 * @Version : 1.0 	 
	 */
	
	@Test
	public void test_GUI_SPEC_19() throws Exception {

		String message = null;

		String testCaseID = "GUI-SPEC-19";

		String mainWindowPageTitle = null;

		String testCaseName = "Requiremnet ID :1000.0362 The product shall inform the user of the wireless access point SSID name when the user requests to view wireless settings";

		try {

			logTestCaseIDAndName(testCaseID, testCaseName);
			logger.logStatus("Precondition : Capturing SSID name from Maintenance and Summary Page.");
			boolean isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();
			checkforPage(isMaintenancePageOpen, testCaseID, testCaseName, "Maintenance Page");				
			
			String ssidFromMaintenancePage=maintenance.mainSSID.getText();
			String[] splitssidfromMaintenancePage = ssidFromMaintenancePage.split(" ");
			logger.logStatus(" 2.4 GHz SSID from Maintenance page is : "
					+ ssidFromMaintenancePage);
			logger.logStatus("Extracted 2.4 Ghz SSID from Maintenance page is : "
					+ splitssidfromMaintenancePage[0]);

			if (splitssidfromMaintenancePage.length > 2
					&& splitssidfromMaintenancePage[3] != null) {
				logger.logStatus("5GHz SSID from Maintenance page is : "
						+ ssidFromMaintenancePage);
				logger.logStatus("Extracted 5 Ghz SSID from Maintenance page is : "
						+ splitssidfromMaintenancePage[3]);
			}
			
			boolean isNavigateToHomePage = executionHelper.verifyHomePageDisplayed();
			checkforPage(isNavigateToHomePage,testCaseID,testCaseName,"Home Page");
			String ssidFromSummaryPage = home.hmeWirelessSSID.getText();
			String[] splitssidfromSummaryPage = ssidFromSummaryPage.split(" ");

			logger.logStatus("Extracted 2.4 Ghz SSID from Summary Status Page is : "
					+ splitssidfromSummaryPage[0]);

			logger.logStatus("Test case main steps start.....");
			boolean navigateToWirelessSettingPage = executionHelper.navigateToWirelessPage();
			checkforPage(navigateToWirelessSettingPage,testCaseID,testCaseName,"Wireless Page");
			
			if (!(splitssidfromMaintenancePage[0].equals(splitssidfromSummaryPage[0]))) {
				message = "SSID displayed on wireless setting page is not matched with router status and summary page";
				logger.logErrMsg(message);				
				logTestStatus(testCaseID, testCaseName, FAIL, message);
			}		
			
			logger.logStatus("SSID displayed on Summary page is matched with router status and summary page");
			logger.logStatus("************Closing The Browser******************");
			logTestStatus(testCaseID, testCaseName, PASS, message);

		} catch (WebDriverException webDriverException) {		
			logger.logStatus(WebDriver_EXCEPTION + webDriverException);
			logTestStatus(testCaseID, testCaseName, FAIL,
					"Failure in Selenium elements");

		}
	}

	/**
	 * This automation script test the 1000.0637 The product shall show the
	 * product's Manufacturer when the user requests to view router status.
	 * 
	 * 1000.0637 The product shall show the product's Manufacturer when the user
	 * requests to view router status Version : 1.0
	 */
	
	@Test
	public void test_GUI_SPEC_20() throws Exception {
		
		String message = null;
		String testCaseID = "GUI-SPEC-20";
		String mainWindowPageTitle = null;
		String testCaseName = "Requiremnet ID :1000.0637 The product shall show the product's Manufacturer  when the user requests to view router status";

		try {
			logTestCaseIDAndName(testCaseID, testCaseName);
			boolean isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();
			checkforPage(isMaintenancePageOpen, testCaseID, testCaseName, "Maintenance Page");
			String manufacturerFromGUI =maintenance.mainManufacturer.getText();
			logger.logStatus("Expected Manufacturer is : Sky ");
			logger.logStatus("Manufacturer from GUI is : " + manufacturerFromGUI);

			if (!manufacturerFromGUI.equalsIgnoreCase("Sky")) {
				message = "Manufacturer vaule is not as expected : "+ manufacturerFromGUI;
				logger.logErrMsg(message);
				logTestStatus(testCaseID, testCaseName, FAIL, message);
			}

			logger.logStatus("************Closing The Browser******************");
			logTestStatus(testCaseID, testCaseName, PASS, message);
			
		} catch (WebDriverException webDriverException) {		
			logger.logStatus(WebDriver_EXCEPTION + webDriverException);
			logTestStatus(testCaseID, testCaseName, FAIL,
					"Failure in Selenium elements");
		}			
	}
	

	/**
	 * This automation script test the 1000.0291 The product shall show the
	 * product's Model Number when the user requests to view router status.
	 * 
	 * 1000.0291 The product shall show the product's Model Number when the user
	 * requests to view router status Version : 1.0
	 * 	 
	 */
	@Test
	public void test_GUI_SPEC_21() throws Exception,WebDriverException {
		
		String message = null;
		String testCaseID = "GUI-SPEC-21";		
		String testCaseName = "Requiremnet ID :1000.0291 The product shall show the product's Model Number when the user requests to view router status";

		try {
			boolean isSummaryPageDisplayed = executionHelper.verifyHomePageDisplayed();
			checkforPage(isSummaryPageDisplayed,testCaseID,testCaseName,"Home Page");
			logTestCaseIDAndName(testCaseID, testCaseName);
			String mainWindowPageTitle = home.getPageHeading();
			logger.logStatus("Page Title : " + mainWindowPageTitle);
			boolean isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();
			checkforPage(isMaintenancePageOpen, testCaseID, testCaseName, "Maintenance Page");
			logger.logStatus("Expected Model number is: EE120");
			String modelNoFromGUI  = maintenance.mainModel.getText();
			logger.logStatus("Model number from GUI is : " + modelNoFromGUI);

			if (!modelNoFromGUI.equalsIgnoreCase("EE120")) {

				message = "Model number from GUI is not as expected : "+ modelNoFromGUI;
				logger.logErrMsg(message);
				logTestStatus(testCaseID, testCaseName, FAIL, message);
			}
			logger.logStatus("************Closing The Browser******************");

			logTestStatus(testCaseID, testCaseName, PASS, message);
			
		} catch (WebDriverException webDriverException) {		
			logger.logStatus(WebDriver_EXCEPTION + webDriverException);
			logTestStatus(testCaseID, testCaseName, FAIL,
					"Failure in Selenium elements");
		}
		
	}
	
	
	/**
	 * This automation script test the 1000.0103 The product shall show the
	 * product's Firmware version when the user requests to view router status.
	 * 
	 * 1000.0103 The product shall show the product's Firmware version when the
	 * user requests to view router status Version : 1.0
	 * 
	 */
	
	@Test
	public void test_GUI_SPEC_22() throws Exception,WebDriverException {
		
		String message = null;
		String testCaseID = "GUI-SPEC-22";		
		String testCaseName = "Requiremnet ID :1000.0103 The product shall show the product's Firmware version when the user requests to view router status";


		try {
			boolean isSummaryPageDisplayed = executionHelper.verifyHomePageDisplayed();
			checkforPage(isSummaryPageDisplayed,testCaseID,testCaseName,"Home Page");
			logTestCaseIDAndName(testCaseID, testCaseName);
			String mainWindowPageTitle = home.getPageHeading();
			logger.logStatus("Page Title : " + mainWindowPageTitle);
			boolean isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();
			checkforPage(isMaintenancePageOpen, testCaseID, testCaseName, "Maintenance Page");
			String firmwareVersion = commonProperties
					.getPropertyFromXMLFile("FirmwareVersion_New");
			logger.logStatus("Expected Firmeware version is: " + firmwareVersion);
			String firmwareVersionFromGUI = maintenance.mainFirmware.getText();
			logger.logStatus("Firmeware version number from GUI is : " + firmwareVersionFromGUI);
			if (!(firmwareVersionFromGUI.trim().equalsIgnoreCase(
					firmwareVersion.trim()) || firmwareVersionFromGUI.trim()
					.contains(firmwareVersion.trim()))) {

				message = "Firmware from GUI is not as expected : "
						+ firmwareVersionFromGUI;

				logger.logErrMsg(message);

				logTestStatus(testCaseID, testCaseName, FAIL, message);
			}
			
			logger.logStatus("************Closing The Browser******************");

			logTestStatus(testCaseID, testCaseName, PASS, message);
			
		} catch (WebDriverException webDriverException) {		
			logger.logStatus(WebDriver_EXCEPTION + webDriverException);
			logTestStatus(testCaseID, testCaseName, FAIL,
					"Failure in Selenium elements");
		}
		
	}
	
	/**
	 * This automation script test the 1000.0353 The product shall show the LAN
	 * MAC address when the user requests to view router status
	 * 
	 * 1000.0353 The product shall show the LAN MAC address when the user
	 * requests to view router status Version : 1.0
	 * 	 
	 */

	@Test
	public void test_GUI_SPEC_39() throws Exception,WebDriverException {
		
		String message = null;
		String testCaseID = "GUI-SPEC-39";		
		String testCaseName = "Requiremnet ID :1000.0353 The product shall show the LAN MAC address when the user requests to view router status";

		try {
			boolean isSummaryPageDisplayed = executionHelper.verifyHomePageDisplayed();
			checkforPage(isSummaryPageDisplayed,testCaseID,testCaseName,"Home Page");
			logTestCaseIDAndName(testCaseID, testCaseName);
			String mainWindowPageTitle = home.getPageHeading();
			logger.logStatus("Page Title : " + mainWindowPageTitle);
			boolean isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();
			checkforPage(isMaintenancePageOpen, testCaseID, testCaseName, "Maintenance Page");
			String slanMACAddressFromGUI = maintenance.mainMAC.getText();
			String[] parts = slanMACAddressFromGUI.split(":");

			System.out.println("parts.length is " + parts.length);
			String lanMACAddressFromGUI = slanMACAddressFromGUI;
			System.out.println(parts[0]);
			if (parts[0].contentEquals("exact")) {
				lanMACAddressFromGUI = parts[1] + ":" + parts[2] + ":"
						+ parts[3] + ":" + parts[4] + ":" + parts[5] + ":"
						+ parts[6];
			}

			logger.logStatus("LAN Mac address from GUI is : " + lanMACAddressFromGUI);
			pattern = Pattern.compile(MACADDRESS_PATTERN);
			matcher = pattern.matcher(lanMACAddressFromGUI);
			if (!matcher.matches()) {
				message = "LAN MAC address from GUI is not as expected";
				logger.logErrMsg(message);
				logTestStatus(testCaseID, testCaseName, FAIL, message);
			}
			logger.logStatus("************Closing The Browser******************");
			logTestStatus(testCaseID, testCaseName, PASS, message);
		} catch (WebDriverException webDriverException) {		
			logger.logStatus(WebDriver_EXCEPTION + webDriverException);
			logTestStatus(testCaseID, testCaseName, FAIL,
					"Failure in Selenium elements");
		}
	}
	
	/**
	 * This automation script test the 1000.0908 The product shall show the
	 * product's LAN IP Address when the user requests to view router status
	 * 
	 * 1000.0908 The product shall show the product's LAN IP Address when the
	 * user requests to view router status Version : 1.0
	 * 
	 */
	
	@Test
	public void test_GUI_SPEC_40() throws Exception,WebDriverException {
		
		String message = null;
		String testCaseID = "GUI-SPEC-40";			
		String testCaseName = "Requiremnet ID :1000.0908 The product shall show the product's LAN IP Address when the user requests to view router status";

		try {
			boolean isSummaryPageDisplayed = executionHelper.verifyHomePageDisplayed();
			checkforPage(isSummaryPageDisplayed,testCaseID,testCaseName,"Home Page");
			logTestCaseIDAndName(testCaseID, testCaseName);
			String mainWindowPageTitle = home.getPageHeading();
			logger.logStatus("Page Title : " + mainWindowPageTitle);
			boolean isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();
			checkforPage(isMaintenancePageOpen, testCaseID, testCaseName, "Maintenance Page");
			String lanIPAddressFromGUI = maintenance.mainIPv4.getText();			
			pattern = Pattern.compile(IPADDRESS_PATTERN);
			matcher = pattern.matcher(lanIPAddressFromGUI);			
			if (!matcher.matches()) {
				message = "LAN MAC address from GUI is not as expected";
				logger.logErrMsg(message);
				logTestStatus(testCaseID, testCaseName, FAIL, message);
			}
			logger.logStatus("************Closing The Browser******************");
			logTestStatus(testCaseID, testCaseName, PASS, message);
			
		} catch (WebDriverException webDriverException) {		
			logger.logStatus(WebDriver_EXCEPTION + webDriverException);
			logTestStatus(testCaseID, testCaseName, FAIL,
					"Failure in Selenium elements");
		}
	}
	
	/**
	 * This automation script test requirement
	 * 
	 * 1000.0043 The product shall show the LAN IP subnet mask when the user
	 * requests to view router status Version : 1.0
	 * 
	 * @author :Sarfaraz.Ahmmed@bskyb.com Date : 22-Aug-2013.
	 */

	
	@Test
	public void test_GUI_SPEC_43() throws Exception,WebDriverException {
		
		String message = null;
		String testCaseID = "GUI-SPEC-43";		
		String testCaseName = "Requiremnet ID :1000.0043 The product shall show the LAN IP subnet mask when the user requests to view router status";

		try {

			logTestCaseIDAndName(testCaseID, testCaseName);
			boolean isSummaryPageDisplayed = executionHelper.verifyHomePageDisplayed();
			checkforPage(isSummaryPageDisplayed,testCaseID,testCaseName,"Home Page");
			logTestCaseIDAndName(testCaseID, testCaseName);
			String mainWindowPageTitle = home.getPageHeading();
			logger.logStatus("Page Title : " + mainWindowPageTitle);
			boolean isMaintenancePageOpen = executionHelper.navigateToMaintenancePage();
			checkforPage(isMaintenancePageOpen, testCaseID, testCaseName, "Maintenance Page");
			String lanSubnetMaskAddressFromGUI = maintenance.mainMask.getText();
			logger.logStatus("LAN subnet mask from GUI is : "
					+ lanSubnetMaskAddressFromGUI);
			pattern = Pattern.compile(IPADDRESS_PATTERN);
			matcher = pattern.matcher(lanSubnetMaskAddressFromGUI);
			if (!matcher.matches()) {
				message = "LAN subnet mask from GUI is not as expected";
				logger.logErrMsg(message);
				logTestStatus(testCaseID, testCaseName, FAIL, message);
			}

			logger.logStatus("************Closing The Browser******************");
			logTestStatus(testCaseID, testCaseName, PASS, message);
		} catch (WebDriverException webDriverException) {		
			logger.logStatus(WebDriver_EXCEPTION + webDriverException);
			logTestStatus(testCaseID, testCaseName, FAIL,
					"Failure in Selenium elements");
		}			
	}
	
	
	/**
	 * Finds the expected Network type
	 * 
	 * @return
	 */
	private String getExpectedNetworkType() {
		String connectionType = System.getProperty("Connections");
		String exp_NetworkType;

		if (connectionType == null) {
			connectionType = "PPPoA";
		}

		if (connectionType.equalsIgnoreCase("PPPoA")) {
			exp_NetworkType = "PPPoA";
		} else if (connectionType.equalsIgnoreCase("IPoE")) {
			exp_NetworkType = "MER";
		} else {
			exp_NetworkType = "WANoE";
		}
		return exp_NetworkType;
	}
	
	private void checkforPage(boolean isPageOpen,String testCaseID,String testCaseName,String page) throws IOException {
		if (!isPageOpen) {

			logger.logErrMsg("Unable to navigate to "+page);
			logTestStatus(testCaseID, testCaseName, FAIL, "Unable to display "+page);
		}
	}

	public Object getPage(String page) throws NoSuchMethodException, InvocationTargetException, ClassNotFoundException{

		browserFactory = new BrowserFactory();
		logger.logInfoMsg("Navigating to page "+page);
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
			case "Maintenance":
				maintenance = (Maintenance)con.newInstance(browserFactory.getDriver());
				return maintenance;
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		logger.logInfoMsg("Returing null");     
		return null; 
	}
	
	public boolean verifyUserNameDisplayed() {
		boolean status = false;
		try {

			String expUserName = "User Name";			
			String expUserValue = "admin";
			if((browserFactory.getDriver().getPageSource().contains(expUserName))
					&&(browserFactory.getDriver().getPageSource().contains(expUserValue)))
				status = true;
		}
		catch (WebDriverException webDriverException) {		
			logger.logStatus(WebDriver_EXCEPTION + webDriverException);			
		}
		return status;
	}

}
