package com.example;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


// hier wordt een titel aan de pannel toegevoegt 
public class LabelTitel extends LabelTextElement{
	
	
	private JLabel label;
	private JPanel panel;
	private int fontsize = 50;
	private String text;

	public LabelTitel(String text, JPanel panel) {
		this.text=text;
		this.panel = panel;
		this.label = new JLabel(text);
		
		newText(text);
		
		setFont();
		
		setSize(text);

		panel.add(this.label);
	    
	}

	void setSize(String text) {
		label.setBounds((1920/2)-((text.length()*(fontsize+50))/2),(1080/2)-(fontsize/2)-300,text.length()*(fontsize+50),400);
	}

	@Override
	void setFont() {
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Dialog", Font.BOLD, fontsize));
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.CENTER);
		
	}

	public void newText(String string) {
		
		if (string!=null) {
			label.setText(string);	
			setSize(string);
		}
		
	}

	@Override
	void addpanel() {}



	
	
}
