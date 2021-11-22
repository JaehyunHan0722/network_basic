package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;


public class ReceivefromAndroidThread extends Thread{
	Socket client;
	MqttClient mqttClient;
	Mqtt_Pub_toLP publish;
	
	public ReceivefromAndroidThread(Socket client, MqttClient mqttClient) {
		super();
		this.client = client;
		this.mqttClient = mqttClient;
		
	}
	@Override
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String resMsg = "";
			while(true) {
				if(client == null) {
					break;
				}
				else {
					resMsg = in.readLine();
					if(resMsg == null) {
						System.out.println("수신된 메세지 없음");
					}else {
						System.out.println("==========안드로이드로부터 수신된 메세지===========");
						System.out.println("메세지: "+resMsg);
						publish = new Mqtt_Pub_toLP(mqttClient, "toLP", resMsg);
						publish.send();
					}
					Thread.sleep(3000);
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
