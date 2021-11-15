package socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
//������ ����ϸ� �����͸� �ְ� ���� �� �ִ� Ŭ���̾�Ʈ
public class MyNetClient04 {

	public static void main(String[] args) {
		Socket client = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("�������ӿϷ�!!");
			while(true) {
				client = server.accept();
				InetAddress clientIp = client.getInetAddress();
				System.out.println("������ Ŭ���̾�Ʈ: "+clientIp.getHostAddress());
				//��Ʈ��ũ�� ���ؼ� ������� �ϱ� ���� IO��Ʈ����ü�� ����
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream());
				
				
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
