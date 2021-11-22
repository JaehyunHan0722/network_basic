package basic;

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
	private MqttConnectOptions mqttOption;
	
	public MyMqtt_Sub_Client init(String server, String clientId) {
		mqttOption = new MqttConnectOptions();
		mqttOption.setCleanSession(true);
		mqttOption.setKeepAliveInterval(30);
		
		try {
			mqttclient = new MqttClient(server, clientId);
			mqttclient.setCallback(this);
			mqttclient.connect(mqttOption);
		} catch (MqttException e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
	//Ŀ�ؼ��� ����Ǹ� ȣ��
	@Override
	public void connectionLost(Throwable arg0) {
		
		
	}
	//�޼��� ����� �Ϸ�Ǹ� ȣ��
	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		
		
	}
	//�޼����� �����ϸ� ȣ��Ǵ� �޼ҵ� - topic(broker������û�� topic��), MqttMessage�� �޼���
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("==============수신된 메세지===============");
		System.out.println("토픽: "+topic);
		System.out.println("메세지: "+message);
		System.out.println("id: "+message.getId());
		System.out.println("Payload: "+new String(message.getPayload()));
		
	}
	public boolean subscribe(String topic) {
		
		try {
			if(topic != null) {
				mqttclient.subscribe(topic, 0);		//topic, Qos�� �޼����� �����ϰ� �����ϴ� ���(ǰ��)
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
