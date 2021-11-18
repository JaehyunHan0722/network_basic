package main;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class MyMqtt_Pub_Client {
	
	private MqttClient client;
	private MqttMessage message;
	private String topic;
	
	public MyMqtt_Pub_Client(String topic, MqttMessage message, MqttClient client) {
		this.message = message;
		this.topic = topic;
		this.client = client; 
	}
	
	public boolean send () {		
		try {
			MqttMessage message2 = new MqttMessage();
			String publish = null;
			publish = new String(message.getPayload());
			System.out.println("Publish할 문장::"+publish);
			if(publish.equals("Button Released")) {
				publish = "버튼 안눌림!!";
				System.out.println("안눌렸다!!");
			}else {
				System.out.println(publish);
				publish = "버튼 눌림!!";
				System.out.println("눌렸다!!");
			}
			message2.setPayload(publish.getBytes());
			client.publish(topic, message2);
		} catch (MqttPersistenceException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		}
		return true;
	}
	
//	public static void main(String[] args) {
//		MyMqtt_Pub_Client sender = new MyMqtt_Pub_Client();
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				int i=1;
//				String msg = "";
//				while(true) {
//					if(i==5) {
//						break;
//					}else {
//						if(i%2==1) {
//							msg = "Red_On";
//						}else {
//							msg = "White_On";
//						}
//					}
//					sender.send("led2", msg);
//					i++;
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				
//			}
//			
//		}).start();
//	}

}
