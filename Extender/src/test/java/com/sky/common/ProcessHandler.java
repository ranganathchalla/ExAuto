package com.sky.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Finds the PID of Firefox process and terminates it
 * @author Rajnish
 *
 */
public class ProcessHandler {
	
	private static Logger logger = Logger.getLogger(ProcessHandler.class);
	
	/**
	 * Issues a kill command for the given PID
	 * @param pidList
	 * @throws IOException
	 */
	private static void killProcess(List<Integer> pidList) throws IOException {
		logger.info("Trying to kill process with pid (s): "+pidList);
		
		for (Integer pid : pidList) {
		    Runtime.getRuntime().exec("kill " + pid);
		}
	}

	/**
	 * Finds the PID of a given process
	 * 
	 * @param processName
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 */
	private static List<Integer> getPIDs(String processName) throws InterruptedException, IOException {
	  Process exec = Runtime.getRuntime().exec("pidof "+processName);
	  InputStream inputStream = exec.getInputStream();
	  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	  List<Integer> processList = new ArrayList<Integer>();
	  String line;
	  
	  while((line = reader.readLine()) != null) {
		  logger.info(line);
		  
		  try {
			  String[] split = line.split(" ");
			  
			  for (String val : split) {
				  processList.add(Integer.parseInt(val.trim()));
			  }
		} catch (NumberFormatException e) {
			logger.info(e.getMessage());
		}
	  }
	  return processList;
	}
	
	/**
	 * Kills a Firefox process if it is running
	 */
	public static void killFirefox() {
		try {
			List<Integer> pidList = getPIDs("firefox");
			
			if(pidList != null && pidList.size() != 0) {
				killProcess(pidList);
			} else {
				logger.info("No firefox process running");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static void killChrome() {
		try {
			List<Integer> pidList = getPIDs("google-chrome");
			
			if(pidList != null && pidList.size() != 0) {
				killProcess(pidList);
			} else {
				logger.info("No firefox process running");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}	
		
	
	public static void KillProcesses()
    {
        try
        {
        	List<Integer> pidList = getPIDs("google-chrome");
			
			if(pidList != null && pidList.size() != 0) {
				killProcess(pidList);
			} else {
				logger.info("No firefox process running");
			}
			
			pidList = getPIDs("firefox");
			
			if(pidList != null && pidList.size() != 0) {
				killProcess(pidList);
			} else {
				logger.info("No firefox process running");
			}
			
			pidList = getPIDs("chromedriver");
			
			if(pidList != null && pidList.size() != 0) {
				killProcess(pidList);
			} else {
				logger.info("No firefox process running");
			}
			pidList = getPIDs("geckodriver");
			
			if(pidList != null && pidList.size() != 0) {
				killProcess(pidList);
			} else {
				logger.info("No firefox process running");
			}		

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
