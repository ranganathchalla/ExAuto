package com.sky.common;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClientProcess extends Thread{
	private String core_dump_file;
	
	public ClientProcess(String core_dump){
		core_dump_file = core_dump;
	}
	
	   
	public void run(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		core_dump_file = core_dump_file + "_" + dateFormat.format(cal.getTime());
		String command = "nc -l 1234 > /home/test_user/core_dump/" + core_dump_file;

		try {
	        ProcessBuilder probuilder = new ProcessBuilder( "/bin/sh",
	        		"-c",
	        		command);
	        Process process = probuilder.start();
            boolean hasExited = nonBlockingWaitFor(process, 10000);
	        
	        if (hasExited) {
	        	process.waitFor();	        	
	        } 
	        process.destroy();
	        
        } catch (IOException ex) {
			System.out.println(ex);
		} catch (IllegalThreadStateException e) {
			System.out.println(e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean nonBlockingWaitFor(Process proc, long procMaxTimeoutMillis)
			throws InterruptedException {
		final long TIMESTAMP_BEFORE_EXECUTE = System.currentTimeMillis();
		boolean hasExited = false;
		while (!hasExited) {
			try {
				// set/calculate your own granularity of check, which fits your
				// procMaxTimeoutMillis
				// using the IllegalThreadStateException side-effect of
				// exitValue() if process hasn't exited
				proc.exitValue();
				hasExited = true;
			} catch (IllegalThreadStateException e) {
				if (System.currentTimeMillis() > (TIMESTAMP_BEFORE_EXECUTE + procMaxTimeoutMillis)) {
					System.out.println("Command timeout after 100 sec!!!!");
					break;
				}
			}
		}
		return hasExited;
	}
}
