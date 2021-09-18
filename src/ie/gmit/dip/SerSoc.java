package ie.gmit.dip;

import java.net.*;
import java.io.*;

public class SerSoc {

	public static void main(String[] args) {
		try {
			ServerSocket theServer = new ServerSocket(5000);
			while (true) {
				Socket cl = theServer.accept();
				PrintStream p = new PrintStream(cl.getOutputStream());
				p.println("You connected to this server - Goodbye!");
				cl.close();
			}
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
}
