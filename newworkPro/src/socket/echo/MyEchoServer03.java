package socket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class MyEchoServer03 {

	public static void main(String[] args) {
		Socket client = null;
		BufferedReader in = null;	//클라이언트와 통신하기 위한 스트림
		BufferedReader keyin = null;	//키보드로 입력하는 메세지를 읽기 위한 스트림
		PrintWriter out = null;
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버 접속 완료!!");
			while(true) {
				client = server.accept();
				InetAddress clientIp = client.getInetAddress();
				System.out.println("접속한 클라이언트 ip: "+clientIp.getHostAddress());
				
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				keyin = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(client.getOutputStream(), true);
				
				String resMsg = "";
				String sendMsg = "";
				while(true) {
					resMsg = in.readLine();
					if(resMsg == null) {
						break;
						
					}
					System.out.println("클라이언트가 보낸 메세지: "+resMsg);
					sendMsg = keyin.readLine();
					out.println(sendMsg);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
