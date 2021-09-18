package ie.gmit.dip;

import java.net.*;
import java.io.*;

public class DaytimeClient {

	public static void main(String[] args) {
		Socket theSocket;
		String hostname;
		BufferedReader theTimeStream;
		
		if (args.length > 0) {
			hostname = args[0];
		}
		else {
			hostname = "localhost";
		}
		try {
			theSocket = new Socket(hostname, 13);
			theTimeStream = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
			String theTime = theTimeStream.readLine();
			System.out.println("It is " + theTime + " at " + hostname);
		}
		catch (UnknownHostException e) {
			System.err.println(e);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
}
