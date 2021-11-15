package socket.echo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
//서버와 클라이언트가 키보드로 통신하기
public class MyEchoClient03 {

	public static void main(String[] args) {
		Socket server = null;
		BufferedReader in = null;
		PrintWriter out = null;
		BufferedReader keyin = null;
		try {
			server = new Socket("192.168.0.140", 12345);
			System.out.println("서버 접속완료! 여긴 클라이언트 창");
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			out = new PrintWriter(server.getOutputStream(), true);
			keyin = new BufferedReader(new InputStreamReader(System.in));
			
			String sendMsg = ""; 
			String resMsg = ""; 
			
			while((sendMsg = keyin.readLine()) != null) {
				out.println(sendMsg);
				
				resMsg = in.readLine();
				System.out.println("서버에서 보내온 메세지: "+resMsg);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
