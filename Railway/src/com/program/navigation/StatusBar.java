package com.program.navigation;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class StatusBar extends JLabel {
	private static final long serialVersionUID = 1L;
	
	private List<String> errorsLog;
	private List<String> messageLog;

	public StatusBar() {
		super();
		errorsLog = new ArrayList<String>();
		messageLog = new ArrayList<String>();
		setBorder(BorderFactory.createLineBorder(Color.black));
		setPreferredSize(new Dimension(100, 16));
		setMessage("Пустой проект");
	}

	public void setMessage(String message) {
		setForeground(Color.BLUE);
		setText(" " + message);
		messageLog.add(message);
	}
	
	public void setException(String message){
		setForeground(Color.RED);
		setText(message);
		errorsLog.add(message);
	}
	
	public List<String> getErrorsLog(){
		return errorsLog;
	}
	
	public List<String> getMessagesLog(){
		return messageLog;
	}
}
