package main;

public class AndroidMqttConnectServer {
	
	public static void main(String[] args) {
		Mqtt_Sub_fromLP mqttTcp = new Mqtt_Sub_fromLP();
		mqttTcp.init("tcp://192.168.0.140:1883", "semi").subscribe("LP");
				
	}
}
