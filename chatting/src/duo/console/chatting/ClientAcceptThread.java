package duo.console.chatting;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientAcceptThread extends Thread{
	Socket client = null;
	InetAddress clientIp = null;
	
	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버 접속 완료");
			
			while(true) {
				client = server.accept();
				if(client != null) {
					clientIp = client.getInetAddress();
					System.out.println("접속한 클라이언트 ip: "+clientIp.getHostAddress());
					
					new ClientReceiveThread(client).start();
					new ClientSenderThread(client).start();
				}
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
