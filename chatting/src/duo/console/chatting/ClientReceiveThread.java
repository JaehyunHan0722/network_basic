package duo.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientReceiveThread extends Thread{
	Socket server;
	//쓰레드가 생성될 때 서버 정보를 넘겨받도록
	public ClientReceiveThread(Socket server) {
		super();
		this.server = server;
	}
	//서버가 보내는 메세지를 읽어서 콘솔에 출력하는 실행흐름
	@Override
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String resMsg = "";
			while(true) {
				resMsg = in.readLine();
				if(resMsg == null) {
					break;
				}
				System.out.println("서버: "+resMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
