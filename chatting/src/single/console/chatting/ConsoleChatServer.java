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
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버 접속 완료!!");
			while(true) {
				client = server.accept();
				if(client != null) {
					//클라이언트끼리 1:1로 통신하도록 구현하려면 클라이언트 정보를 저장
					//accept해서 클라이언트의 접속을 대기하는 부분도 쓰레드로 처리
					clientIp = client.getInetAddress();
					System.out.println("접속한 클라이언트 ip: "+clientIp.getHostAddress());
										
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
