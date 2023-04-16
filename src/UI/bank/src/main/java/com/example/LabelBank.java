package com.example;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelBank extends LabelTextElement {

	// hier wordt de text van de label bank gemaakt en op elke scherm gezet
	
	JLabel label;
	public LabelBank(JPanel panel) {
		this.label = new JLabel("F.A.I.L.");
		setSize();
		setFont();
		
		panel.add(this.label);
	}

	void setSize() {
		label.setBounds(86,52,405,98);
	}
	@Override
	void setFont() {
		label.setForeground(Color.BLACK);
		label.setFont(new Font("DialogInput", Font.BOLD, 80));
		
	}
	@Override
	void addpanel() {
		// TODO Auto-generated method stub
		
	}
	



}
