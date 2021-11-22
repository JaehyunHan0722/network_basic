package basic;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class MyMqtt_Pub_Client {
	
	private MqttClient client;
	
	public MyMqtt_Pub_Client() {
		try {
			client = new MqttClient("tcp://192.168.0.140:1883", "myid2");
			client.connect();
		} catch (MqttException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean send (String topic, String message) {		
		try {
			System.out.println("Publish할 문장: "+message);
			MqttMessage msg = new MqttMessage();
			msg.setPayload(message.getBytes());
			System.out.println("Mqtt메세지: "+message);
			client.publish(topic, msg);
		} catch (MqttPersistenceException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static void main(String[] args) {
		MyMqtt_Pub_Client sender = new MyMqtt_Pub_Client();
		new Thread(new Runnable() {
			@Override
			public void run() {
				int i=1;
				String msg = "";
				while(true) {
					if(i==5) {
						break;
					}else {
						if(i%2==1) {
							msg = "홀수!";
						}else {
							msg = "짝수!";
						}
					}
					System.out.println(msg);
					sender.send("led", msg);
					i++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
			
		}).start();
	}

}
