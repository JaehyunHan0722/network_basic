package android_sts_connection;

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
		
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버 시작!!");
			while(true) {
				client = server.accept();
				if(client != null) {
					clientIp = client.getInetAddress();
					System.out.println("클라이언트 ip: "+clientIp.getHostAddress());
										
					ServerReceiveThread srt = new ServerReceiveThread(client);
					srt.start();
					new ServerSenderThread(client).start();
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
