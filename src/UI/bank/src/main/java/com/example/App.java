package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.fazecast.jSerialComm.*;

public class App implements SerialPortDataListener {

	private InputStream input;
	private OutputStream output;
	private List<SerialPort> comPorts = new ArrayList<SerialPort>();
	private SerialPort comPort;
	private String text;

	private String iban;
	private String waarde;

	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 1000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;

	private static final String PORT_NAMES[] = {
			"/dev/tty.usbmodem411", // Mac OS X
			"/dev/ttyUSB0", // Linux
			"COM3",
			"COM4", // Windows
			"COM5",
			"COM6",
			"COM8",
			"COM17",
	};

	// zoek naar de com port
	public App() {
		SerialPort[] comPorts = SerialPort.getCommPorts();

		for (int i = 0; i < comPorts.length; i++) {
			SerialPort currPortId = (SerialPort) comPorts[i];
			String name = currPortId.getDescriptivePortName().substring(
					currPortId.getDescriptivePortName().length() - 5, currPortId.getDescriptivePortName().length() - 1);
			for (String portName : PORT_NAMES) {
				if (name.equals(portName)) {
					comPort = currPortId;
					break;
				}
			}

			name = currPortId.getDescriptivePortName().substring(currPortId.getDescriptivePortName().length() - 6,
					currPortId.getDescriptivePortName().length() - 1);
			for (String portName : PORT_NAMES) {
				if (name.equals(portName)) {
					comPort = currPortId;
					break;
				}
			}
		}

		if (comPort == null) {
			System.out.println("Could not find COM port.");
			System.out.println("Run without COM port.");
		} 

		if (comPort != null) {
			// set the baud rate to 9600 (same as the Arduino)
			comPort.setComPortParameters(DATA_RATE,
					8,
					SerialPort.TWO_STOP_BITS,
					SerialPort.NO_PARITY);
	
			// open the port
			comPort.openPort();
	
			input = comPort.getInputStream();
			output = comPort.getOutputStream();
	
			// create a listener and start listening
			comPort.addDataListener(this);
		} 


	}

	// deze fuctie kijkt of de text goed is
	public synchronized String[] isText() {

		String ar[] = new String[2];
		if (this.waarde != null && this.iban != null) {
			if (!this.waarde.equals("X")) {
				ar[0] = this.waarde;
				this.waarde = null;
			}

			if (!this.iban.equals("XXXXXXXXXXXXXX")) {

				ar[1] = this.iban;
				this.iban = null;
			}
		}
		notifyAll();

		return ar;
	}

	// stuurt text naar de aruino
	public synchronized void writetoport(String send) {
		try {
			try {
				output.write(send.getBytes());
				output.flush();
			} catch (IOException e) {
				System.exit(1);
			}
		} catch (Exception e) {
		}
	}

	// als er een bericht is kan dez de void serialEvent activeren
	@Override
	public synchronized int getListeningEvents() {
		return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
	}

	// de haalt de text op
	@Override
	public synchronized void serialEvent(SerialPortEvent event) {
		if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
			return;
		}
		int available = 0;
		try {
			available = input.available();
		} catch (IOException e) {
		}

		if (available != -1) {
			byte chunk[] = new byte[available];
			try {
				input.read(chunk, 0, available);
			} catch (IOException e) {
			} // read incoming bytes

			text = new String(chunk); // convert bytes to string
			text = text.replaceAll("(\\r|\\n)", "");
			try {
				iban = text.substring(0, 14);
				waarde = text.substring(15, 16);
			} catch (Exception e) {
			}

		}
		try {
			this.wait();
		} catch (InterruptedException e) {
		}
	}

	public void sleep(int x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
		}

	}
}
