package com.sky.common;

import com.jscape.inet.telnet.*;

import com.sky.common.ClientProcess;

import static common.constants.CommonConstants.AGENT_IP;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPETelnetClient extends TelnetAdapter {

	private Telnet telnet = null;
	private OutputStream output = null;
	private static BufferedReader reader = null;
	private boolean connected = false;

	public CPETelnetClient(String hostname) throws IOException, TelnetException, InterruptedException {
		// create new Telnet instance
		telnet = new Telnet(hostname);
		reader = new BufferedReader(new InputStreamReader(System.in));
		// register this class as TelnetListener
		telnet.addTelnetListener(this);

		// establish Telnet connection
		telnet.connect();
		connected = true;
		// get output stream
		output = telnet.getOutputStream();
	}

	public void adslDown() throws InterruptedException, IOException {
		// sends all data entered at console to Telnet server
		if (connected) {
			((TelnetOutputStream) output).println("admin");
			Thread.sleep(1000);
			((TelnetOutputStream) output).println("sky");
			Thread.sleep(1000);
			((TelnetOutputStream) output).println("adsl connection --down");
			Thread.sleep(5000);
			System.out.println("ADSL Disconnected");
		} else {
			System.err.println("Connection is not up");
		}
	} 

	public void adslUp() throws InterruptedException, IOException {
		// sends all data entered at console to Telnet server
		if (connected) {
			((TelnetOutputStream) output).println("admin");
			Thread.sleep(1000);
			((TelnetOutputStream) output).println("sky");
			Thread.sleep(1000);
			((TelnetOutputStream) output).println("adsl connection --up");
			Thread.sleep(5000);
			System.out.println("ADSl Connected");
		} else {
			System.err.println("Connection is not up");
		}
	} 

	public void updateCorePattern() throws InterruptedException, IOException {

		((TelnetOutputStream) output).println("admin");
		Thread.sleep(1000);
		((TelnetOutputStream) output).println("sky");
		Thread.sleep(1000);
		String element = "echo '/var/auxfs/core_%e%' > /proc/sys/kernel/core_pattern\r";
		((TelnetOutputStream) output).println(element);
		Thread.sleep(1000);
		element = "cat /proc/sys/kernel/core_pattern\r";
		((TelnetOutputStream) output).println(element);
		Thread.sleep(1000);		
		OutputStream s = ((TelnetOutputStream)output).getStream();		
		element = "exit\r";
		((TelnetOutputStream) output).println(element);
		Thread.sleep(1000);
		s = ((TelnetOutputStream)output).getStream();

		//System.out.println(reader.readLine());

	}

	public void getCoreDumps() throws InterruptedException, IOException {
		((TelnetOutputStream) output).println("admin");
		Thread.sleep(1000);
		((TelnetOutputStream) output).println("sky");
		Thread.sleep(1000);
		String element = "sh";		
		((TelnetOutputStream) output).println(element);
		Thread.sleep(1000);
		element = "cd /var/auxfs\r";		
		((TelnetOutputStream) output).println(element);
		Thread.sleep(1000);
		element = "ls /var/auxfs | grep core\r";
		((TelnetOutputStream) output).println(element);
		Thread.sleep(100);
		OutputStream s = ((TelnetOutputStream)output).getStream();
		String ret1 = s.toString();
		System.err.println(s);
		if(ret1.contains("core_")) {

			Pattern p1 = Pattern.compile("core_([^,]*)");
			Matcher m = p1.matcher(ret1);
			if (m.find()) {
				System.out.println("DUMP :" + m.group(1));
			}

			String[] parts = m.group(1).split("core_");

			System.out.println("Number of dumps available: "
					+ parts.length);
			for (int i=0; i<parts.length; i++) {

				String dumpfile = "core_"
						+ parts[i].replaceAll("(#|\\s)", "");

				System.out.println("Downloading the dumpfile: " + dumpfile);

				ClientProcess clientProcess = new ClientProcess(dumpfile);
				clientProcess.start();

				element = "nc " + AGENT_IP + " 1234 < " + dumpfile + " \n";
				((TelnetOutputStream) output).println(element);

				Thread.sleep(1000);

				// wait until the thread has completed it's task
				clientProcess.join();

				element = "rm -f " + dumpfile + " \n";
				((TelnetOutputStream) output).println(element);

				Thread.sleep(1000);					

				System.out.println("Download completed");
			}
		} else {
			System.out.println("No coredump available!");
		}
		element = "exit\r\n";
		((TelnetOutputStream) output).println(element);	
		Thread.sleep(1000);
		element = "exit\r\n";
		((TelnetOutputStream) output).println(element);
		Thread.sleep(1000);
		s = ((TelnetOutputStream)output).getStream();
		System.err.println(s);
	}		

	/** 
	 * Invoked when Telnet socket is connected.
	 * @see TelnetConnectedEvent
	 * @see Telnet#connect
	 */
	public void connected(TelnetConnectedEvent event) {
		System.out.println("Connected");
	}

	/** 
	 * Invoked when Telnet socket is disconnected. Disconnect can
	 * occur in many circumstances including IOException during socket read/write.
	 * @see TelnetDisconnectedEvent
	 * @see Telnet#disconnect
	 */
	public void disconnected(TelnetDisconnectedEvent event) {
		connected = false;
		System.out.print("Disconnected.  Press enter key to quit.");
	}

	public void closeConnection() throws IOException {
		try {
			connected = false;
			telnet.disconnect();
			output.close();
		} catch (Exception e) {
		}
	}

	/**
	 * Invoked when Telnet server requests that the Telnet client begin performing specified <code>TelnetOption</code>.
	 * @param event a <code>DoOptionEvent</code>
	 * @see DoOptionEvent
	 * @see TelnetOption
	 */
	public void doOption(DoOptionEvent event) {
		// refuse any options requested by Telnet server
		telnet.sendWontOption(event.getOption());
	}

	/**
	 * Invoked when Telnet server offers to begin performing specified <code>TelnetOption</code>.
	 * @param event a <code>WillOptionEvent</code>
	 * @see WillOptionEvent
	 * @see TelnetOption
	 */
	public void willOption(WillOptionEvent event) {
		// refuse any options offered by Telnet server
		telnet.sendDontOption(event.getOption());
	}

	/**
	 * Invoked when data is received from Telnet server.
	 * @param event a <code>TelnetDataReceivedEvent</code>
	 * @see TelnetDataReceivedEvent
	 */
	public void dataReceived(TelnetDataReceivedEvent event) {
		// print data recevied from Telnet server to console
		System.out.print(event.getData());
	}

	/**
	 * Main method for launching program
	 * @param args program arguments
	 */
	public static void main(String[] args) {
		try {
			String hostname = "192.168.0.1";

			// create new TelnetExample instance
			CPETelnetClient cl = new CPETelnetClient(hostname);
			//cl.adslDown();	
			cl.updateCorePattern();
			//cl.getCoreDumps();
			Thread.sleep(10000);			
			//cl.adslUp();			
			//cl.closeConnection();

		} catch (Exception e) {
			e.printStackTrace(System.out);		
		}
	}

}
