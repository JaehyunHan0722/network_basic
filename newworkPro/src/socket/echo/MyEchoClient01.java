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
//서버와 통신하며 데이터를 주고 받을 수 있는 클라이언트
public class MyEchoClient01 {

	public static void main(String[] args) {
		Socket server = null;
		BufferedReader in = null;
		PrintWriter out = null;
		BufferedReader keyin = null;	//서버로 보내기 위해 키보드를 통해 입력한 메세지리를 읽기 위한 스트림객체
		try {
			server = new Socket("192.168.0.140", 12345);
			System.out.println("서버접속완료!! 여긴 클라이언트");
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			out = new PrintWriter(server.getOutputStream(), true);
			keyin = new BufferedReader(new InputStreamReader(System.in));
			
			//******************통신 시작***********************
			//키보드로 입력한 데이터를 서버로 지속전송하기
			//서버가 다시 보내오는 메세지를 콘솔에 출력
			String sendMsg = ""; //서버로 보낼 메세지
			String resMsg = ""; //서버에서 받은 메세지
			
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
