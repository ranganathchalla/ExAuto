package com.sky.common;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.testng.Assert;
import junit.framework.Assert;

import static common.constants.CommonConstants.FAIL;
import static common.constants.CommonConstants.NEW_LINE;
import static common.constants.CommonConstants.PASS;

/**
 * The Logger class has utility methods for logging Status of execution.
 * 
 * @author Md Sarfaraz Ahmed
 * @version 1.0, 23/05/2013
 */
/*public class CommonAutomationLogger {
	private static final Logger rootLogger = Logger.getRootLogger();
	private static Logger logger = Logger.getLogger(CommonAutomationLogger.class);
	
	static {
		startLogger();
	}
	
	public static void startLogger() {
		rootLogger.removeAllAppenders();
		PropertyConfigurator.configure("log4j.properties");
		System.setOut(createLoggingProxy(System.out));
		System.setErr(createLoggingProxy(System.err));
	}
	
	public static PrintStream createLoggingProxy(final PrintStream realPrintStream) {
		return new PrintStream(realPrintStream) {
			@Override
			public void print(final String string) {
				realPrintStream.print(string);
				logger.info(string);
			}
		};
	}*/
	
	public class CommonAutomationLogger {
		private static final Logger rootLogger = Logger.getRootLogger();
		private static Logger logger = Logger.getLogger(CommonAutomationLogger.class);
		private static CommonAutomationLogger loggerInstance = new CommonAutomationLogger();
		
		static String moduleName = System.getProperty("module");

	//        static String buildNumber = System.getProperty("BuildNumber"); 
	        
	        static String buildNumber = "1";
		
		static {
			startLogger();
		}
		
		public static void startLogger() {
			rootLogger.removeAllAppenders();
			PropertyConfigurator.configure("log4j.properties");
			System.setOut(createLoggingProxy(System.out));
			System.setErr(createLoggingProxy(System.err));
		}
	
		public static PrintStream createLoggingProxy(final PrintStream realPrintStream) {
			return new PrintStream(realPrintStream) {
				@Override
				public void print(final String string) {
					realPrintStream.print(string);
					logger.info(string);
				}
			};
		}
	
	
	
	
	/**
	 * Logs testCaseID, Test case name and description of test case.
	 * 
	 * @param testCaseID
	 *            TestCase Id
	 * @param testCaseName
	 *            name of the test case
	 */
	public static void logTestCaseStepsResult(String stepName, String status) {

		String dashedLine = "====";
		logger.info("");
		logger.info(dashedLine + " [ Step Name: " + stepName + " ]"
				+ dashedLine + " [ Status : " + status + " ] " + dashedLine);

		if (status.equalsIgnoreCase(FAIL)) {

			logger.info("Test step :" + stepName + " is failed");

			Assert.fail();
		}
		logger.info("");
	}

	/**
	 * Prints a dashed line in the log file.
	 */
	public void printAsteriskLine() {
		String line = "";
		for (int i = 0; i < 20; i++) {
			line = line + "*****";
		}
		logger.info(line);
	}

	/**
	 * Logs testCaseID, Test case name and description of test case.
	 * 
	 * @param testCaseID
	 *            TestCase Id
	 * @param testCaseName
	 *            name of the test case
	 * @throws IOException
	 */
	public static void logTestCaseIDAndName(String testCaseID, String testCaseName)throws IOException {

		logger.info("=============================================");
		String dashedLine = "=========";
		logger.info("");
		
		logger.info("[" + 2 + "] " + dashedLine + " [ Test Case Id : "
				+ testCaseID + " ]" + dashedLine + " [ Testcase Name : "
				+ testCaseName + " ] " + dashedLine);
		logger.info("");
	}

	/**
	 * Logs testCaseID, Test case name and description of test case.
	 * 
	 * @param testCaseID
	 *            TestCase Id
	 * @param testCaseName
	 *            name of the test case
	 */
	public void logTestCaseStepsResult(String stepName, String status, Logger log1) {

		String dashedLine = "====";
		log1.info("");
		log1.info(dashedLine + " [ Step Name: " + stepName + " ]"
				+ dashedLine + " [ Status : " + status + " ] " + dashedLine);

		if (status.equalsIgnoreCase(FAIL)) {
			log1.info("Test step :" + stepName + " is failed");
			Assert.fail();
		}
	}

	/**
	 * Logs Pass or Fail status in the logger along with the given message.
	 * 
	 * @param testCaseID
	 *            test case Id
	 * @param testCaseName
	 *            name of the test case
	 * @param status
	 *            Pass or Fail status
	 * @param message
	 *            reason for failure or empty string for Pass.
	 * @param logger
	 * @throws IOException
	 *             if any I/O exception has occurred.
	 */
	public static void logTestStatus(String testCaseID, String testCaseName,
			String status, String message) throws IOException {

		String dashedLine = "====";

		if (status.equalsIgnoreCase(FAIL) || status.equalsIgnoreCase(PASS)) {

			String passMessage = " " + dashedLine + " [ Test Case Id : "
					+ testCaseID + " ]" + dashedLine + " [ Testcase Name : "
					+ testCaseName + " ] " + dashedLine + PASS + NEW_LINE;

			String failMessage = " " + dashedLine + " [ Test Case Id : "
					+ testCaseID + " ]" + dashedLine + " [ Testcase Name : "
					+ testCaseName + " ] " + dashedLine + FAIL + NEW_LINE
					+ "Reason for failure :  " + message + NEW_LINE;

			if (status.equalsIgnoreCase(FAIL)) {
				logger.info(failMessage);
				Assert.fail(failMessage);

			} else if (status.equalsIgnoreCase(PASS)) {
				logger.info(passMessage);
				Assert.assertTrue(true);
			}

		}
	}
	
	/**
	 * get logger method
	 * 
	 * @return logger instance
	 */
	public static CommonAutomationLogger getLogger() {

		if (loggerInstance == null) {
			// logger = Logger.getLogger(IHRAutomationLogger.class.getName());
			loggerInstance = new CommonAutomationLogger();
		}

		//String moduleName = "STATS_DIAGNOSTICS";

		System.out.println("Bamboo Line Number" + buildNumber);

		if(moduleName == null){
			moduleName = "Batch";
		}

		System.setProperty("Module", moduleName);

		System.setProperty("log4j.date", dateFormat());

		System.setProperty("BuildNumber", buildNumber);


		PropertyConfigurator.configure("log4j.properties");
		return loggerInstance;
	}
	
	/**
	 * Logs the given message.
	 * 
	 * @param message
	 *            any String that needs to written in the Log file
	 */
	public void logStatus(String message) {
		logger.debug(message);
	}
	
	/**
	 * Logs the given message.
	 * 
	 * @param message
	 *            any String that needs to written in the Log file
	 */
	public void logErrMsg(String message) {
		logger.error(message);
	}
	
	public void logErrMsg(String message, Exception e) {
		logger.error(message, e);
	}
	
	/**
	 * Logs the given message.
	 * 
	 * @param message
	 *            any String that needs to written in the Log file
	 */
	public void logInfoMsg(String message) {
		logger.info(message);
	}
	
	
	 /**
     * Returns the current date and time in specified format
     * @return dateNow Current date and time
     */
    public static String dateFormat() {

        Calendar currentDate = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MMM_dd");

        String dateNow = formatter.format(currentDate.getTime());

        return dateNow;

    }

}
