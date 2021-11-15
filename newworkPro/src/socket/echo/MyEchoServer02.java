package socket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Date;


public class MyEchoServer02 {

	public static void main(String[] args) {
		Socket client = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버접속완료!!");
			while(true) {
				client = server.accept();
				InetAddress clientIp = client.getInetAddress();
				System.out.println("접속한 클라이언트 ip: "+clientIp.getHostAddress());
				
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream(), true);
				
				out.println("안녕하세요 클라이언트님?");
				String resMsg = "";
				while(true) {
					resMsg = in.readLine();
					if(resMsg.startsWith("안녕하세요?") || resMsg.startsWith("하이")) {
						out.println(clientIp+"님 반갑습니다");
					}else if(resMsg.startsWith("오늘 날짜는")) {
						out.println(new Date().toString());
					}else {
						out.println(clientIp+"님 좀 가세요");
					}
					
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
