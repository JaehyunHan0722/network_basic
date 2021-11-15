package single.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientSenderThread extends Thread{
	Socket client;
	//쓰레드가 생성될 때 서버 정보를 넘겨받도록
	public ClientSenderThread(Socket client) {
		super();
		this.client = client;
	}
	//키보드로 입력한 메세지를 서버로 보내는 작업을 처리
	@Override
	public void run() {
		BufferedReader keyin = null;
		PrintWriter out = null;
		try {
			keyin = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(client.getOutputStream(), true);
			String sendMsg = "";
			while(true) {
				sendMsg = keyin.readLine();
				if(sendMsg == null) {
					break;
				}
				out.println(sendMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
