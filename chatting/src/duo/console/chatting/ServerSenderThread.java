package duo.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerSenderThread extends Thread{
	Socket server;
	//쓰레드가 생성될 때 서버 정보를 넘겨받도록
	public ServerSenderThread(Socket server) {
		super();
		this.server = server;
	}
	//서버가 보내는 메세지를 읽어서 콘솔에 출력하는 실행흐름
	@Override
	public void run() {
		BufferedReader keyin = null;
		PrintWriter out = null;
		try {
			keyin = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(server.getOutputStream(), true);
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
