package android_sts_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientSenderThread extends Thread{
	Socket client;
	
	public ClientSenderThread(Socket client) {
		super();
		this.client = client;
	}
	
	@Override
	public void run() {
		BufferedReader keyin = null;
		PrintWriter out = null;
		try {
			keyin = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(client.getOutputStream(), true);
			String sendMsg = "";
			while(true) {
				sendMsg = keyin.readLine();
				if(sendMsg == null) {
					break;
				}
				out.println(sendMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
