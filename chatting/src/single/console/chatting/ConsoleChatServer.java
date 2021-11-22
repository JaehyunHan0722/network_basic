package single.console.chatting;

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
			ServerSocket server = new ServerSocket(12345);	//서버를 시작
			System.out.println("서버 시작!!");
			while(true) {
				client = server.accept();		//서버에 접속한 클라이언트를 받음
				if(client != null) {
					clientIp = client.getInetAddress();
					System.out.println("클라이언트 ip: "+clientIp.getHostName());
										
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
