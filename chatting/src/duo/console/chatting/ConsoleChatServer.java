package duo.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ConsoleChatServer {

	public static void main(String[] args) {
		Socket client = null;
		InetAddress clientIp = null;
				
		while(true) {
			
			ClientAcceptThread accept = new ClientAcceptThread();
			accept.start();
			new ServerReceiveThread(client).start();
			new ServerSenderThread(client).start();
		}	
		
	}

}
