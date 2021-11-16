package duo.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ServerReceiveThread extends Thread{
	Socket client;
	//쓰레드가 생성될 때 서버 정보를 넘겨받도록
	public ServerReceiveThread(Socket client) {
		super();
		this.client = client;
	}
	//서버가 보내는 메세지를 읽어서 콘솔에 출력하는 실행흐름
	@Override
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String resMsg = "";
			while(true) {
				resMsg = in.readLine();
				if(resMsg == null) {
					break;
				}
				System.out.println("클라이언트: "+resMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
