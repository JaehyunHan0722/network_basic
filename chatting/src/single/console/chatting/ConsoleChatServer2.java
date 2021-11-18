package single.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsoleChatServer2 {
	private ServerSocket server;
	
	
	public void connect() {
		try {
			server = new ServerSocket(12345);
			System.out.println("서버 시작!!");
			
			Thread connect = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						Socket client = null;
						InetAddress clientIp = null;
						try {
							client = server.accept();
							if(client != null) {
								clientIp = client.getInetAddress();
								System.out.println("클라이언트 ip: "+clientIp.getHostName());
													
								ServerReceiveThread srt = new ServerReceiveThread(client);
								srt.start();
								new ServerSenderThread(client).start();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			});
			connect.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ConsoleChatServer2().connect();	
	
	}

}
