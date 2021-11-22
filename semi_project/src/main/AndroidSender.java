package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class AndroidSender /* extends Thread */{
	Socket AndClient;
	String message;
	public AndroidSender(Socket AndClient, String message) {
		super();
		this.AndClient = AndClient;
		this.message = message;
	}
//	@Override
	public void send()/*run()*/ {
		PrintWriter out = null;
//		while(true) {
			try {
				out = new PrintWriter(AndClient.getOutputStream(), true);
				if(out != null) {
					out.println(message);
					out = null;
				}
				Thread.sleep(3000);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
//		}
		
	}
	
	
}
