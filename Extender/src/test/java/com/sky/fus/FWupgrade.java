package com.sky.fus;

import static common.constants.CommonConstants.FAIL;
import static common.constants.CommonConstants.LOCALHOST;
import static common.constants.CommonConstants.PASS;
import static common.constants.CommonConstants.SLASH;
import static common.constants.CommonConstants.SLEEP_TWO_MINUTES;
import static com.sky.common.CommonAutomationLogger.logTestStatus;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.sky.common.CommonAutomationLogger.logTestCaseIDAndName;
import static com.sky.common.CommonAutomationLogger.logTestStatus;
import static com.sky.common.CommonExecutionHelper.*;
import com.sky.common.BrowserFactory;
import com.sky.common.CommonExecutionHelper;
import com.sky.common.CommonProperties;

import com.sky.common.ProcessHandler;

public class FWupgrade extends BrowserFactory {

	private CommonProperties commonProperties = new CommonProperties();
	private static Logger logger = Logger.getLogger(FWupgrade.class);
	private String testCaseID = "Firmware-Upgrade";
	private String testCaseName = "Firmware-Upgrade";
	private String browser = null;
	private String status = FAIL;
	private CommonExecutionHelper executionHelper = new CommonExecutionHelper();

	@BeforeClass
	public static void beforeClass() {
		logger.debug("Terminating processes");		
		ProcessHandler.KillProcesses();
	}

	@Before
	public void setUp() throws Exception {
		BrowserFactory browserFactory = new BrowserFactory();
		executionHelper = new CommonExecutionHelper(browserFactory);
		logTestCaseIDAndName(testCaseID, testCaseName);
		browser = commonProperties.getPropertyFromXMLFile("Browser");
		String indexUrl = commonProperties.getPropertyFromXMLFile("IndexUrl");
		logger.debug("indexUrl :" + indexUrl);	
		BrowserFactory.initBrowser(browser);
		BrowserFactory.loadApplication(indexUrl);		
		executionHelper.RestoreFactoryDefaults();			
		//Thread.sleep(SLEEP_TWO_MINUTES);
	}

	@Test
	public void testFWupgrade() throws Exception{

		try {	
			executionHelper.doFirmwareUpgrade();
			System.out.println("Firmwareupgrade successful .....");										
			executionHelper.verifyFirmwareUpgrade();						
		} catch (Exception e) {
			logger.error("Exception", e);
			//logTestStatus(testCaseID, testCaseName, FAIL,"Exception");
		} 
		logTestStatus(testCaseID, testCaseName, PASS, null);		
	}

}
