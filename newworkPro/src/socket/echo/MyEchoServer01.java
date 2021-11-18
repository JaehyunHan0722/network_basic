package socket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class MyEchoServer01 {

	public static void main(String[] args) {
		Socket client = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버 열림!");
			while(true) {
				client = server.accept();
				InetAddress clientIp = client.getInetAddress();
				System.out.println("클라이언트 접속함: "+clientIp.getHostAddress());
				//��Ʈ��ũ�� ���ؼ� ������� �ϱ� ���� IO��Ʈ����ü�� ����
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream(), true);
				
				//*********************��� ����**************************
				//Ŭ���̾�Ʈ�� �������� �޼����� �ٽ� Ŭ���̾�Ʈ���� ����
				String resMsg = "";
				while(true) {
					resMsg = in.readLine();
					if(resMsg == null) {
						break;
						
					}
					System.out.println("Ŭ���̾�Ʈ�� ���� �޼���:"+resMsg);
					out.println(resMsg+"^^");
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
