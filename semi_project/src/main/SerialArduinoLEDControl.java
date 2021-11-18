package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class SerialArduinoLEDControl {
	OutputStream out;
	
	public void connect(String portName) {
		try {
			CommPortIdentifier comPortIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			
			if(comPortIdentifier.isCurrentlyOwned()) {
				System.out.println("��Ʈ�� ����� �� �����ϴ�");
			}else {
				System.out.println("��Ʈ ��� ����");
				CommPort commPort = comPortIdentifier.open("basic_serial", 3000);
				System.out.println(commPort);
				//Serial��Ʈ���� Parallel��Ʈ���� Ȯ��
				if(commPort instanceof SerialPort) {
					SerialPort serialPort = (SerialPort)commPort;
					serialPort.setSerialPortParams(
							9600,
							SerialPort.DATABITS_8,
							SerialPort.STOPBITS_1,
							SerialPort.PARITY_NONE);
					
					InputStream in = serialPort.getInputStream();
					out = serialPort.getOutputStream();
					
				}
			}
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		} catch (PortInUseException e) {
			e.printStackTrace();
		} catch (UnsupportedCommOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//
	public OutputStream getOutput() {
		return out;
	}
}
