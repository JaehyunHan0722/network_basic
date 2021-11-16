package duo.console.chatting;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//������ ������ �� ����� �� �ִ� �����带 �����ϰ� start
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
