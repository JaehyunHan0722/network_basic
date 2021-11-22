package main;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer extends Thread{
	
	ServerSocket server = null;
	Socket client = null;
	InetAddress clientIp = null;
			
	@Override
	public void run() {
		try {
			server = new ServerSocket(12345);
			System.out.println("서버 시작!!");
			
			while(true) {
				client = server.accept();
				if(client != null) {
					clientIp = client.getInetAddress();
					System.out.println("접속한 클라이언트 ip: "+clientIp.getHostAddress());
					
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getClient() {
		return client;
	}
	
	public ServerSocket getServer() {
		return server;
	}
}
