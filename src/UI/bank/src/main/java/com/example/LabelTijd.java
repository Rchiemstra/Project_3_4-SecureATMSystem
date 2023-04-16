package com.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LabelTijd extends LabelTextElement {
	
	//hier de tijd aan de pannel toegevoegt  
	private JLabel label;
	private String name;
	
	final DateFormat dateFormat = new SimpleDateFormat(	" %dd-MM-yy#/HH:mm:ss ");
    int interval = 1000; // 1000 ms
    Instant now = Instant.now();
    
    
    public LabelTijd(JPanel panel) {
		this.label = new JLabel();
		setSize();
		setFont();	
		
	    new Timer(interval, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Calendar now = Calendar.getInstance();
	            String textTijd = dateFormat.format(now.getTime());     
	            label.setText(textTijd.replaceFirst(" ", "<html><body>").replaceFirst("/", "<br>").replaceFirst("%", "<font size=\"40\">").replaceFirst("#", "</font>")  );
	        }
	    }).start();

	    panel.add(this.label);
	}

	void setSize() {
		label.setBounds(1718,0,202,108);
	}

	void setFont() {
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Dialog", Font.BOLD, 30));
	}
	
	@Override
	void addpanel() {}
}
