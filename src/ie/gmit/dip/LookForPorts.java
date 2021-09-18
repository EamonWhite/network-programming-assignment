package ie.gmit.dip;

import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class LookForPorts {
				
	public static void main(String[] args) {	
		long startTime = new Date().getTime();
		InetAddress ip;
		
		try {
		ip = InetAddress.getLocalHost();
		System.out.println("IP address : " + ip.getHostAddress());
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
		byte[] mac = network.getHardwareAddress();
		System.out.print("MAC address : ");
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
		System.out.println(sb.toString());
		} 
		catch (UnknownHostException | SocketException e1) {
	
			e1.printStackTrace();
		}
		
			try {
				Socket theSocket = new Socket("www.gmit.ie", 80);
				InetAddress host = theSocket.getInetAddress();
				System.out.println(host);
				theSocket.close();
			}
			catch (UnknownHostException e) {
				System.err.println(e);
			}
			catch (IOException e) {
				System.err.println(e);
			}
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
				
		
		String host = "www.gmit.ie";
		
		if (args.length > 0) { 
			host = args[0];
		}
		
		for (int i = 1; i < 1024; i++) {
			try {
				Socket s = new Socket(host, i);
				
				System.out.println("There is a server on port " + i + " of " + host);
				
				s.close();
			}
			catch (UnknownHostException ex) {
				System.err.println("Unknown Host: " + host);
			}
			catch (IOException e) {
				System.err.println("Handshake not accepted - no server listening on port " + i);
			}
		}
		long endTime = new Date().getTime();
		long totalTime = endTime - startTime;
		System.out.println("Execution time in milliseconds: " + totalTime);
	}
}
