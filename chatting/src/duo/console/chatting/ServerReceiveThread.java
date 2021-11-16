package duo.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ServerReceiveThread extends Thread{
	Socket client;
	//�����尡 ������ �� ���� ������ �Ѱܹ޵���
	public ServerReceiveThread(Socket client) {
		super();
		this.client = client;
	}
	//������ ������ �޼����� �о �ֿܼ� ����ϴ� �����帧
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
				System.out.println("Ŭ���̾�Ʈ: "+resMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
