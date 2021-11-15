package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
//서버와 통신하며 데이터를 주고 받을 수 있는 클라이언트
public class MyNetClient02 {

	public static void main(String[] args) {
		Socket serverobj = null;
		InputStream socketIn = null;	//클라이언트가 보내오는 데이터를 읽기 위해서 소케셍서 꺼내오는 스트림객체
		OutputStream socketOut = null;	//클라이언트에게 데이터를 보내기 위해서 소켓에서 꺼내오는 스트림객체
		DataInputStream dis = null;		//클라이언트로부터 읽은 데이터를 타입별로 읽기 위해 사용하는 최종스트림객체
		DataOutputStream dos = null;	//클라이은트로 데이터를 타입별로 보내기 위해 사용하는 최종스트림객체
		try {
			//서버와 통신할 수 있는 소켓객체를 생성
			//서버에 연결을 요청
			serverobj = new Socket("192.168.0.158", 12345);
			System.out.println("서버접속완료: "+serverobj);
			socketIn = serverobj.getInputStream();
			socketOut = serverobj.getOutputStream();
			dis = new DataInputStream(socketIn);
			dos = new DataOutputStream(socketOut);
			
			//1. 서버가 보내오는 데이터 읽기 (순서가 중요 --- 2번을 연속해서 읽기)
			//	클라이언트 <- 서버
			String data = dis.readUTF();
			System.out.println("서버가 전송한 메세지1: "+data);
			int intdata = dis.readInt();
			System.out.println("서버가 전송한 메세지2: "+intdata);
			
			//2. 클라이언트에서 서버로 데이터 보내기
			//	클라이언트 -> 서버
			dos.writeUTF("안녕하세요 저는 클라이언트 입니다.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
