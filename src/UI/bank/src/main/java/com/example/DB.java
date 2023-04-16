package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DB {

	private String serverName = "localhost";
	private int port = 8080;


	Socket client ;    
	//output server
	OutputStream outToServer ;
	DataOutputStream out;

	//input server
	InputStream inFromServer;
	DataInputStream in;


	public void dbConnection() {
		try {
			System.out.println("Connecting to " + serverName + " on port " + port);

			client = new Socket(serverName, port);    
			System.out.println("Just connected to " + client.getRemoteSocketAddress());

			//output server
			outToServer = client.getOutputStream();
			out = new DataOutputStream(outToServer);

			//input server
			inFromServer = client.getInputStream(); 
			in = new DataInputStream(inFromServer);
		} catch (Exception e) {
			System.out.println("Not connecting ");
		}

	}

	//sluit de verbeding met de Socket
	private void dbClose() {
		try {
			if (client != null) {
				client.close();
			}
		} catch (IOException e) {}
	}


	//read de String van de Socket
	private String read() {
		String tekst = null;
		try {
			tekst = in.readUTF();			
		} catch (Exception e) {}
		return tekst;
	}

	//read de boolean van de Socket
	private boolean readBoolean() {
		boolean b = false;
		try {
			b = in.readBoolean();			
		} catch (Exception e) {}
		return b;
	}

	//verzend naar de Socket
	private void send(String string) {
		try {
			out.writeUTF(string);
		} catch (Exception e) {}
	}

	//haalt de pin de pin uit de
	public boolean dbPin(String pin,String useriban) {
		System.out.println("PIN");
		dbConnection();
		send("PIN");
		send(useriban);
		send(pin);
		boolean b = readBoolean();
		dbClose();
		return b;
	}

	

	//houdt de pogingen bij in de databes
	public boolean dbPogingen(String iban) {
		boolean b =false;
		dbConnection();
		send("POGINGEN");
		send(iban);
		b = readBoolean();
		dbClose();
		return b;
	}
	
	//kan gelad uit de databes halen
	public boolean dbwithdrawal(String iban,String pin,int amount) {
		boolean b =false;
		dbConnection();

		send("WHITHDRAWAL");

		send(iban);
		send(pin);
		send(Integer.toString(amount));
		
		b = readBoolean();

		dbClose();
		return b;
	}    

}