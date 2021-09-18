package ie.gmit.dip;

import java.net.*;
import java.io.*;

public class EchoClient {

	public static void main(String[] args) {
		Socket theSocket;
		String hostname;
		BufferedReader theInputStream;
		BufferedReader userInput;
		PrintStream theOutputStream;
		String theLine;
		
		if (args.length > 0) {
			hostname = args[0];
		}
		else {
			hostname = "localhost";
		}
		try {
			theSocket = new Socket(hostname, 7);
			theInputStream = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
			theOutputStream = new PrintStream(theSocket.getOutputStream());
			userInput = new BufferedReader(new InputStreamReader(System.in));
			
			while (true) {
				theLine = userInput.readLine();
				if (theLine.equals(".")) break;
				theOutputStream.println(theLine);
				System.out.println(theInputStream.readLine());
			}
			theSocket.close();
		}
		catch (UnknownHostException e) {
			System.err.println(e);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
}
