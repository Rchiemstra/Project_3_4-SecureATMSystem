package com.example;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Knop{
	//hier wordt de knop aan de pannel toegevoegt
	private String name;
	private JButton knop;
	private int[] size = new int[4];
	private JPanel panel;
	

	public Knop(String name, JPanel panel, ActionListener actionListener) {	
		this.panel = panel;
		this.name = name; 
		this.knop = new JButton(name);
		
		setSize();
		knop.setBounds(size[0], size[1], size[2], size[3]);
		knop.setFont(new Font("Dialog", Font.BOLD, 30));
		knop.addActionListener(actionListener); // haal weg wanneer klaar
		panel.add(this.knop);
	}
	
	public void setSize() {

		switch (name) {
		case "A":
			size[0] =1829; 
			size[1] =194;
			size[2] =79;
			size[3] =90;
			break;
			
		case "B":
			size[0] =1829; 
			size[1] =372;
			size[2] =79;
			size[3] =90;
			break;
			
		case "C":
			size[0] =1829; 
			size[1] =546;
			size[2] =79;
			size[3] =90;
			break;
			
		case "D":
			size[0] =1829; 
			size[1] =730;
			size[2] =79;
			size[3] =90;
			break;
			
		case "#":
			size[0] =12; 
			size[1] =194;
			size[2] =79;
			size[3] =90;
			break;
			
		case "*":
			size[0] =12; 
			size[1] =730;
			size[2] =79;
			size[3] =90;
			break;
		}

	}
	
	
	
}
