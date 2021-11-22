package android_sts_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientReceiveThread extends Thread{
	Socket server;
	
	public ClientReceiveThread(Socket server) {
		super();
		this.server = server;
	}
	
	@Override
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String resMsg = "";
			while(true) {
				resMsg = in.readLine();
				if(resMsg == null) {
					break;
				}
				System.out.println("서버로부터 받은 메세지: "+resMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
