/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 * COPYRIGHT 2013.  ALL RIGHTS RESERVED.  THIS MODULE CONTAINS
 * BRITISH SKY BROADCASTING CONFIDENTIAL AND PROPRIETARY INFORMATION.
 * THE INFORMATION CONTAINED HEREIN IS GOVERNED BY LICENSE AND
 * SHALL NOT BE DISTRIBUTED OR COPIED WITHOUT WRITTEN PERMISSION
 * FROM BRITISH SKY BROADCASTING CABLE.
 *-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/

package com.sky.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.junit.Assert;

import static common.constants.CommonConstants.*;

/**
 * The CommonXMLPropertiesLoader class contains accessor methods, which return the
 * value of the fields from common-properties.xml.
 * 
 * @author Sarfaraz Ahmed
 * @version 1.0,23/05/2013
 */
public class CommonProperties {
	
	/**
	 * This value will loaded from ANT build file
	 */
	
	static String commonPropertyPath = System.getProperty("CommonPropertyPath");

	/**
	 * Load common-properties.xml file
	 * 
	 * @exception ioException
	 * @return
	 */
	public CommonProperties() {

		try {
			
			
			getXmlProperties();

		} catch (IOException ioException) {

			ioException.printStackTrace();

			Assert.fail("Unable to load common-properties.xml");
		}
	}

	private static Properties skyhub2CommonProperties = null;

	/**
	 * Get a single instance of Properties file.
	 * 
	 * @return all the properties and value from common-properties.xml
	 * @throws IOException
	 *             if any I/O exception has occurred.
	 */
	private static Properties getXmlProperties() throws IOException {

		if (skyhub2CommonProperties == null) {

			skyhub2CommonProperties = loadXmlProperties();

		}
		return skyhub2CommonProperties;
	}

	/**
	 * Loads all the properties from common-properties.xml
	 * 
	 * @return all the properties and value from common-properties.xml
	 */
	private static Properties loadXmlProperties() throws FileNotFoundException,
			InvalidPropertiesFormatException, IOException {

		Properties properties = new Properties();
		
		if(commonPropertyPath == null){
			commonPropertyPath = PATH_TO_COMMON_PROPERTIES;
		}

		System.out.println("path: " + commonPropertyPath + SKYHUB2_COMMON_PROPERTIES_XML);
		FileInputStream fis = new FileInputStream(commonPropertyPath + SKYHUB2_COMMON_PROPERTIES_XML);

		properties.loadFromXML(fis);

		return properties;
	}

	/**
	 * Get the value of a key from common-properties.xml return the value
	 * 
	 * @param key
	 * @return
	 */
	public String getPropertyFromXMLFile(String key) {

		return skyhub2CommonProperties.getProperty(key);
	}

}
