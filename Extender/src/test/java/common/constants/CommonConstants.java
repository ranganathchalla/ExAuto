/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 * COPYRIGHT 2013.  ALL RIGHTS RESERVED.  THIS MODULE CONTAINS
 * BRITISH SKY BROADCASTING CONFIDENTIAL AND PROPRIETARY INFORMATION.
 * THE INFORMATION CONTAINED HEREIN IS GOVERNED BY LICENSE AND
 * SHALL NOT BE DISTRIBUTED OR COPIED WITHOUT WRITTEN PERMISSION
 * FROM BRITISH SKY BROADCASTING.
 *-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/

package common.constants;

/**
 * CommonConstants interface contains the SKY HUB2 public constants that are used in
 * the Automation classes.
 * 
 * @author Sarfaraz Ahmed
 * 
 */
public interface CommonConstants {
	
	/**
	 * String constant for 'Remote Host IP :'
	 */
	String REMOTE_HOST1 = "192.168.0.80";
	
	/**
	 * String constant for 'Remote Host IP :'
	 */
	String REMOTE_HOST2 = "192.168.0.60";
	
	
	String AGENT_IP = "192.168.0.94";
	/**
	 * String constant for 'Meraki Wifi Stumbler Website'
	 */
	String MerakiWiFiStumbler = "http://tools.meraki.com/stumbler";	
	
	/**
	 * Location of the Batch file on the Remote Host to Associate with Router in Open Authentication mode :'
	 */
	String REMOTE_HOST_OpenAuth = "http://localhost/test_auto/index.php?argmt=ConnectTest-TestWiFi-OpenAuthentication";
	
	/**
	 * Location of the Batch file on the Remote Host to Associate with Router in WPA2/PSK mode with valid Characters :'
	 */
	String REMOTE_HOST_WPA2_PSK_ValidCharacters = "http://localhost/test_auto/index.php?argmt=ConnectTest-TestWiFi-WPA2-PSK-ValidCharacter";
		
	/**
	 * Location of the Batch file on the Remote Host to Associate with Router in WPA2/PSK mode with 63 Valid Characters :'
	 */
	String REMOTE_HOST_WPA2_PSK_63 = "http://localhost/test_auto/index.php?argmt=ConnectTest-TestWiFi-WPA2-PSK-63";
	
	/**
	 * Location of the Batch file on the Remote Host to Associate with Router in WPA2/PSK mode with 8 valid Characters :'
	 */	
	String REMOTE_HOST_WPA2_PSK_8 = "http://localhost/test_auto/index.php?argmt=ConnectTest-TestWiFi-WPA2-PSK-8";
	
	/**
	 * Location of the Batch file on the Remote Host to Disable wireless interface on the Remote Host :'
	 */
	String REMOTE_HOST_DISABLE_WIRELESS = "http://localhost/test_auto/index.php?argmt=wirelessdisable";
	
	
	
	/**
	 * String constant for 'Test Case Description :'
	 */
	String TESTCASE_DESCRIPTION = "Test Case Description : ";
	
	/**
	 * String constant for 'Properties/Common/'
	 */
	String PATH_TO_COMMON_PROPERTIES = "Properties/Common/";
	
	/**
	 * String constant for 'Properties/PageObject/'
	 */
	String PATH_TO_PAGE_OBJECT = "/home/test_user/eclipse-workspace/EXTENDER-AUTOMATION2/Properties/PageObject/";
	
	/**
	 * String constant for 'Properties/PropertiesData/'
	 */
	String PATH_TO_PROPERTIES_FILE = "Properties/PropertiesData/";

	/**
	 * String constant for ':'
	 */
	String COLON = ":";

	/**
	 * String constant for Comma
	 */
	String COMMA = ",";
	
	/**
	 * String constant for 'common-properties.xml'
	 */
	String SKYHUB2_COMMON_PROPERTIES_XML =  "common-properties.xml";
	
	/**
	 * String constant for 'CommonPageObjects.xml'
	 */
	String SKYHUB2_COMMON_PAGE_OBJECT = "CommonPageObjects.xml";
	
	
	/**
	 * Following variables load the module page objects like xpath, link..etc. 
	 * These files contains the values related specific to selenium execution
	 * 
	 */
	

	/**
	 * String constant for 'AdvancePageObjects.xml'
	 */
	String SKYHUB2_ADVANCE_PAGE_OBJECTS_XML = PATH_TO_PAGE_OBJECT + "AdvancePageObjects.xml";
	
		
	/**
	 * String constant for 'Maintenance-PageObjects.xml'
	 */
	String SKYHUB2_MAINTENANCE_PAGE_OBJECTS_XML = PATH_TO_PAGE_OBJECT + "MaintenancePageObjects.xml";
	
	/**
	 * String constant for 'SecurityPageObjects.xml'
	 */
	String SKYHUB2_SECURITY_PAGE_OBJECTS_XML = PATH_TO_PAGE_OBJECT + "SecurityPageObjects.xml";
		
	
	/**
	 * String constant for 'SupportPageObjects.xml'
	 */
	String SKYHUB2_SUPPORT_PAGE_OBJECTS_XML = PATH_TO_PAGE_OBJECT + "SupportPageObjects.xml";
	
	/**
	 * String constant for 'WirelessPageObjects.xml'
	 */
	String SKYHUB2_WIRELESS_PAGE_OBJECTS_XML = PATH_TO_PAGE_OBJECT + "WirelessPageObjects.xml";
	
	/**
	 * String constant for SelfHeal-PageObjects.xml
	 */
	String SKYHUB2_SELFHEAL_PAGE_OBJECTS_XML = PATH_TO_PAGE_OBJECT + "SelfHeal-PageObjects.xml";
	
	
	/**
	 * Following variables load the module xml specific path. 
	 * These files contains the data passing to the automation tests and expected result
	 * 
	 */
	
	
	/**
	 * String constant for 'Wireless-properties.xml'
	 */
	String SKYHUB2_WIRELESS_XML = PATH_TO_PROPERTIES_FILE + "Wireless-Properties.xml";
	
	/**
	 * String constant for 'Maintenance-Properties.xml'
	 */
	String SKYHUB2_MAINTENANCE_XML = PATH_TO_PROPERTIES_FILE + "Maintenance-Properties.xml";
	
	
	/**
	 * String constant for 'Security-properties.xml'
	 */
	String SKYHUB2_SECURITY_XML = PATH_TO_PROPERTIES_FILE + "Security-Properties.xml";
	
	/**
	 * String constant for 'Advance-Properties.xml'
	 */
	String SKYHUB2_ADVANCE_XML = PATH_TO_PROPERTIES_FILE + "Advance-Properties.xml";
	
	/**
	 * String constant for 'Support-Properties.xml'
	 */
	String SKYHUB2_SUPPORT_XML = PATH_TO_PROPERTIES_FILE + "Support-Properties.xml";
	
	/**
	 * String constant for 'SelfHeal-Properties.xml'
	 */
	String SKYHUB2_SELFHEAL_XML = PATH_TO_PROPERTIES_FILE + "SelfHeal-Properties.xml";
	

	
		
	/**
	 * String constant for 'DATE'
	 */
	String DATE = "DATE";

	/**
	 *String constant for - '.
	 */
	String DELIM = "'.";

	/**
	 * String constant for empty string
	 */
	String EMPTY_STRING = "";

	/**
	 * String constant for 'Exception : '
	 */
	String EXCEPTION = "Exception : ";

	
	/**
	 * String constant for 'FAIL'
	 */
	String FAIL = "FAIL";

	/**
	 * String constant for 'FailingHttpStatusCodeException :\n'
	 */
	String FAILING_HTTP_STATUS_CODE_EXCEPTION = "FailingHttpStatusCodeException :\n";

	/**
	 * String constant for 'FileNotFoundException :\n'
	 */
	String FILE_NOT_FOUND_EXCEPTION = "FileNotFoundException :\n";

	/**
	 * String constant for 'http://'
	 */
	String HTTP = "http://";

	/**
	 * String constant for hyphen
	 */
	String HYPHEN = "-";

	/**
	 * String constant for 'ID'
	 */
	String ID = "ID";

	/**
	 * String constant for 'InterruptedException : '
	 */
	String INTERRUPTED_EXCEPTION = "InterruptedException : ";

	/**
	 * String constant for 'InvalidPropertiesFormatException :\n'
	 */
	String INVALID_PROPERTIES_FORMAT_EXCEPTION = "InvalidPropertiesFormatException :\n";

	/**
	 * String constant for 'IOException : '
	 */
	String IO_EXCEPTION = "IOException : ";
	/**
	 * String constant for 'JSchException : '
	 */
	String JSCH_EXCEPTION = "JSchException : ";
	
	/**
	 * String constant for 'SeleniumException : '
	 */
	String WebDriver_EXCEPTION = "SeleniumException : ";

	/**
	 * String constant for 'LEVEL'
	 */
	String LEVEL = "LEVEL";
	/**
	 * String constant for ' list is empty '
	 */
	String LIST_EMPTY = " list is empty ";
      
	/**
	 * String constant for 'Logs'
	 */
	String LOGS = "Logs";

	/**
	 * String constant for 'MESSAGE'
	 */
	String MESSAGE = "MESSAGE";

	/**
	 * String constant for '\n'
	 */
	String NEW_LINE = "\n";

	/**
	 * String constant for 'NO'
	 */
	String NO = "NO";

	/**
	 * String constant for 'OK'
	 */
	String OK = "OK";

	/**
	 * String constant for '1'
	 */
	String ONE = "1";

	/**
	 * String constant for '1'
	 */
	String ONE_HOUR = ONE;

	/**
	 * String constant for 'PASS'
	 */
	String PASS = "PASS";

	/**
	 * String constant for ';'
	 */
	String SEMI_COLON = ";";

	/**
	 *String constant for - should be '.
	 */
	String SHOULD_BE = " should be '";

	/**
	 * String constant for single quotes(')
	 */
	String SINGLE_QUOTES = "'";

	
	/**
	 * String constant for '/'
	 */
	String SLASH = "/";

	/**
	 * String constant for single space.
	 */
	String SPACE = " ";


	/**
	 * Integer constant for '1000'
	 */
	int SLEEP_ONE_THOUSAND = 1500;
	
	/**
	 * Integer constant for '3000'
	 */
	int SLEEP_THREE_THOUSAND = 3000;
	
	/**
	 * Integer constant for '4000'
	 */
	int SLEEP_FOUR_THOUSAND = 4000;
 
        
	
	/**
	 * Integer constant for '5000'
	 */
	int SLEEP_FIVE_THOUSAND = 5000;
	
	/**
	 * Integer constant for '6000'
	 */
	int SLEEP_SIX_THOUSAND = 6000;

	/**
	 * Integer constant for '10000'
	 */
	int SLEEP_TEN_THOUSAND = 10000;
	
	/**
	 * Integer constant for '20000'
	 */
	int TWENTY_THOUSAND = 20000;
	
	/**
	 * Integer constant for '30000'
	 */
	int THIRTY_THOUSAND = 30000;
	
	/**
	 * Integer constant for '40000'
	 */
	int FOURTY_THOUSAND = 40000;
	
	
	/**
	 * Integer constant for '60000'
	 */
	int SLEEP_SIXTY_THOUSAND = 60000;
	/**
	 * Integer constant for '80000'
	 */
	int SLEEP_EIGHTY_THOUSAND = 80000;
	
	/**
	 * Integer constant for '120000'
	 */

	int SLEEP_TWO_MINUTES = 160000;
	
	/**
	 * Integer constant for '150000'
	 */
	int SLEEP_TWOANDHALF_MINUTES = 150000;
	
	/**
	 * Integer constant for '60000'
	 */
	int SLEEP_ONE_MINUTE = 60000;
	
	/**
	 * Integer constant for '120000'
	 */
	int SLEEP_TWO_MINUTE = 120000;
	
	/**
	 * Integer constant for '180000'
	 */
	int SLEEP_THREE_MINUTES = 180000;
	
	/**
	 * Integer constant for '240000'
	 */
	int SLEEP_FOUR_MINUTES = 240000;
	
	/**
	 * Integer constant for '300000'
	 */
	int SLEEP_FIVE_MINUTES = 300000;
	
	/**
	 * Integer constant for '4444'
	 */
	int DEFAULT_SELENIUM_PORT = 4444;

	/**
	 * Integer constant for '200'
	 */
	int SLEEP_TIME_TWO_HUNDRED = 200;

	/**
	 * Integer constant for '2000'
	 */
	int SLEEP_TIME_TWO_THOUSAND = 2000;
	
	/**
	 * String constant for 'W1Channel'
	 */
	String NAME_CHANNEL = "name=wlChannel";

	/**
	 * String constant for tab
	 */
	String TAB = "\t";

	/**
	 * String constant for '2'
	 */
	String TWO = "2";

	/**
	 * String constant for 'Unable to click the button ' '.
	 */
	String UNABLE_TO_CLICK_ON_BUTTON = "Unable to click the button '";

	/**
	 * String constant for 'Unable to click on the link ' '
	 */
	String UNABLE_TO_CLICK_ON_LINK = "Unable to click on the link '";

	/**
	 * String constant for 'Unable to find '
	 */
	String UNABLE_TO_FIND = "Unable to find ";

	/**
	 *String constant for 'WARNING'.
	 */
	String WARNING = "WARNING";
	
	/**
	 *String constant for 'localhost'.
	 */
	String LOCALHOST = "localhost";
	
	/**
	 *String constant for '/bin/sh'.
	 */
	String BASHSHELL = "/bin/sh";
	
	/**
	 *String constant for '-c'.
	 */
	String HYPHENC = "-c";
	
	/**
	 *String constant for 'AutoExe'.
	 */
	String AUTOIT_EXE_FOLDER = "AutoExe";
	
	/**
	 *String constant for 'Resource'.
	 */
	String RESOURCE_FOLDER = "Resource";
	
	/**
	 *String constant for 'HelpTextFiles'.
	 */
	String HELP_TEXT_FOLDER = "HelpTextFiles";
	
	/**
	 * String constant for What's my IP Website'
	 */
	String WhatsmyIP = "http://www.whatsmyip.org";
	
	/**
	 * String constant for google Website'
	 */
	String Google = "http://www.google.com";
	
	/**
	 * Integer constant for '15000'
	 */
	int SLEEP_FIFTEEN_THOUSAND = 15000;
	
	/**
	 * Integer constant for '90000'
	 */
	int SLEEP_NINTY_THOUSAND = 15000;
	
	/**
	 * String constant for BBC Website'
	 */
	String BBC = "http://www.bbc.co.uk";
        
        /**
	 * String constant for BBC Website'
	 */
	String BBCWEBSITE = "www.bbc.co.uk";
	
	/**
	 * String constant for NonExistant Website'
	 */
	String NonExistant_Website= "www.elgooghhujhky34768877856.com";
	
	/**
	 * String constant for '\\n'
	 */
	String LINE = "\\n";
	
	
	/**
	 * String constant for '\\.'
	 */
	String DOT = "\\.";	
	
	
	/**
	 * String constant for 'Sky'
	 */
	String SKY = "Sky";	
	
	/**
	 * String constant for 'Model'
	 */
	String MODEL = "SR102";	
	
	
	/**
	 * String constant for 'LAN IP'
	 */
	String LAN_IP = "192.168.0.1";	
	
	
	/**
	 * String constant for 'Region'
	 */
	String EUROPE = "Europe";	
	
	/**
	 * String constant for 'Image_folder'
	 */
	String IMAGE_FOLDER = "Images";	
	
	/**
	 * String constant for 'Output_folder'
	 */
	String OUTPUT_FOLDER = "Output";	
	
	
	/**
	 * String constant for 'Random_SSID'
	 */
	String Random_SSID = "CITESTER123";
	
	/**
	 * String constant for 'Random_Password'
	 */
	String Random_Password = "CITESTER12345";
	
	
	
}
