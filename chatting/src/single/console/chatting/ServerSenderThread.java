package single.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerSenderThread extends Thread{
	Socket server;
	
	public ServerSenderThread(Socket server) {
		super();
		this.server = server;
	}
	
	@Override
	public void run() {
		BufferedReader keyin = null;
		PrintWriter out = null;
		try {
			keyin = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(server.getOutputStream(), true);
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
