package ie.gmit.dip;

import java.net.*;
import java.io.*;
import java.util.Date;

public class DaytimeServer {

	public static int daytimePort = 13;

	public static void main(String[] args) throws IOException {
		ServerSocket theServer;
		Socket theConnection;
		PrintStream p;
		
		theServer = new ServerSocket(daytimePort);
		
		try {
			while (true) {
				theConnection = theServer.accept();
				p = new PrintStream(theConnection.getOutputStream());
				p.println(new Date());
				theConnection.close();
				theServer.close();
			}
			/*catch (IOException e) {
				theServer.close();
				System.err.println(e);
			}*/
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
}


