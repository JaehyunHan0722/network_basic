package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
//������ ����ϸ� �����͸� �ְ� ���� �� �ִ� Ŭ���̾�Ʈ
public class MyNetClient02 {

	public static void main(String[] args) {
		Socket serverobj = null;
		InputStream socketIn = null;	//Ŭ���̾�Ʈ�� �������� �����͸� �б� ���ؼ� ���ɼļ� �������� ��Ʈ����ü
		OutputStream socketOut = null;	//Ŭ���̾�Ʈ���� �����͸� ������ ���ؼ� ���Ͽ��� �������� ��Ʈ����ü
		DataInputStream dis = null;		//Ŭ���̾�Ʈ�κ��� ���� �����͸� Ÿ�Ժ��� �б� ���� ����ϴ� ������Ʈ����ü
		DataOutputStream dos = null;	//Ŭ������Ʈ�� �����͸� Ÿ�Ժ��� ������ ���� ����ϴ� ������Ʈ����ü
		try {
			//������ ����� �� �ִ� ���ϰ�ü�� ����
			//������ ������ ��û
			serverobj = new Socket("192.168.0.140", 12345);
			System.out.println("�������ӿϷ�: "+serverobj);
			socketIn = serverobj.getInputStream();
			socketOut = serverobj.getOutputStream();
			dis = new DataInputStream(socketIn);
			dos = new DataOutputStream(socketOut);
			
			//1. ������ �������� ������ �б� (������ �߿� --- 2���� �����ؼ� �б�)
			//	Ŭ���̾�Ʈ <- ����
			String data = dis.readUTF();
			System.out.println("������ ������ �޼���1: "+data);
			int intdata = dis.readInt();
			System.out.println("������ ������ �޼���2: "+intdata);
			
			//2. Ŭ���̾�Ʈ���� ������ ������ ������
			//	Ŭ���̾�Ʈ -> ����
			dos.writeUTF("�ȳ��ϼ��� ���� Ŭ���̾�Ʈ �Դϴ�.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
