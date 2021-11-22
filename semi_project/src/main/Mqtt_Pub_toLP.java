package main;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class Mqtt_Pub_toLP {
	
	private MqttClient mqttClient;
	private String message;
	private String topic;
	
	public Mqtt_Pub_toLP(MqttClient mqttClient, String topic, String message) {
		this.mqttClient = mqttClient;
		this.topic = topic;
		this.message = message;
	}
	
	public boolean send() {		
		try {
			MqttMessage mqttMessage = new MqttMessage();
			System.out.println("Publish할 문장::"+message);
			if(message.equals("1")) {
				System.out.println("LED켜기");
			}else if(message.equals("0")){
				System.out.println("LED끄기");
			}
			mqttMessage.setPayload(message.getBytes());
			mqttClient.publish(topic, mqttMessage);
		} catch (MqttPersistenceException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
