package main;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;


//MqttŬ���̾�Ʈ �ۼ� - subscriber
//������û�� �ϰ� �޼����� ���޵Ǵ� ���� ���
//1. MqttCallback �������̽��� ���
//2. MqttCallbakc �������̽��� �޼ҵ带 �������̵�
//3. MqttClient ��ü�� ����� - broker�� ����ϴ� ������ ���, subscriber, publisher�� ������ ���
public class MyMqtt_Sub_Client implements MqttCallback{
	private MqttClient mqttclient;
	private MqttClient connect_client;
	private MqttConnectOptions mqttOption;
	SerialArduinoLEDControl serialObj;
	OutputStream out;
	
//	public MyMqtt_Sub_Client() {
//		serialObj = new SerialArduinoLEDControl();
//		serialObj.connect("COM5");
//		out = serialObj.getOutput();
//	}
	
	public MyMqtt_Sub_Client init(String server, String clientId) {
		mqttOption = new MqttConnectOptions();
		mqttOption.setCleanSession(true);
		mqttOption.setKeepAliveInterval(30);
		try {
			//broker��  subscribe �ϱ� ���� Ŭ���̾�Ʈ ��ü�� ����
			mqttclient = new MqttClient(server, clientId);
			//Ŭ���̾�Ʈ ��ü�� �ݹ��� ���� - subscribe�ϸ鼭 ������ ������ �޼ҵ尡 ȣ��� �� �ִ�.
			mqttclient.setCallback(this);
			//mqttclient�� broker�� ������ �� �ֵ��� ����
			mqttclient.connect(mqttOption);
			
			connect_client = new MqttClient("tcp://192.168.0.123:1883", "myid2");
			connect_client.connect();
		} catch (MqttException e) {
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public void connectionLost(Throwable arg0) {
		
	}
	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		
	}
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("==============메세지 수신===============");
		System.out.println("토픽: "+topic);
		System.out.println("메세지: "+message);
		System.out.println("id: "+message.getId());
		System.out.println("Payload: "+new String(message.getPayload()));
		
		MyMqtt_Pub_Client publish = new MyMqtt_Pub_Client(topic, message, connect_client);
		publish.send();
				
	}
	
	public boolean subscribe(String topic) {
		try {
			if(topic != null) {
			mqttclient.subscribe(topic, 0); //topic, Qos�� �޼����� �����ϰ� �����ϴ� ���(ǰ��)
			}
		} catch (MqttException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		MyMqtt_Sub_Client client = new MyMqtt_Sub_Client();
		//MqttClient��ü�� broker�� ����ǰ� ������û
		client.init("tcp://192.168.0.140:1883", "myid").subscribe("led");
	}
}