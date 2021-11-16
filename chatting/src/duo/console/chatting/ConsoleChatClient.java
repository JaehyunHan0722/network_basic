package duo.console.chatting;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//서버와 접속한 후 통신할 수 있는 쓰레드를 생성하고 start
public class ConsoleChatClient {

	public static void main(String[] args) {
		try {
			Socket server = new Socket("192.168.0.140", 12345);
			new ClientReceiveThread(server).start();
			new ClientSenderThread(server).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
