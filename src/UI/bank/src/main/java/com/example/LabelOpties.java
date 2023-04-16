package com.example;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LabelOpties {

	//alle buttons hebben een vaste plaats op het scherm hier worden ze toegevoegt aan de pannel 
	
	private JLabel label;
	private int[] size = new int[4];
	
	
	public LabelOpties(String name, String type, JPanel panel) {
		this.label = new JLabel(name);
		label.setText(name);
		setSize(type);
		
		label.setBounds(size[0], size[1], size[2], size[3]);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Dialog", Font.BOLD, 30));

		panel.add(this.label);
		
	}


	void setSize(String type) {
		
		
		switch (type) {

			case "A":
				size[0] =1525; 
				size[1] =194;
				size[2] =300;
				size[3] =90;
				label.setHorizontalAlignment(SwingConstants.RIGHT);
				break;
				
			case "B":
				size[0] =1525; 
				size[1] =372;
				size[2] =300;
				size[3] =90;
				label.setHorizontalAlignment(SwingConstants.RIGHT);
				break;
				
			case "C":
				size[0] =1525; 
				size[1] =546;
				size[2] =300;
				size[3] =90;
				label.setHorizontalAlignment(SwingConstants.RIGHT);
				break;
				
			case "D":
				size[0] =1525; 
				size[1] =730;
				size[2] =300;
				size[3] =90;
				label.setHorizontalAlignment(SwingConstants.RIGHT);
				break;
				
			case "#":
				size[0] =95; 
				size[1] =194;
				size[2] =300;
				size[3] =90;
				label.setHorizontalAlignment(SwingConstants.LEFT);
				break;
				
			case "*":
				size[0] =95; 
				size[1] =730;
				size[2] =300;
				size[3] =90;
				label.setHorizontalAlignment(SwingConstants.LEFT);
				break;
			}
			
		
	}

	void newText(String string){
		
		label.setText(string);
		
		
	}
	

}
