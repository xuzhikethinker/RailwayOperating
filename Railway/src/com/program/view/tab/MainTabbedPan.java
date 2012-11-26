package com.program.view.tab;

import javax.swing.JTabbedPane;

public class MainTabbedPan extends JTabbedPane{

	private static final long serialVersionUID = 1L;
	
	public MainTabbedPan(){
		setAutoscrolls(true);
		setName("Editor");
		setVisible(false);
	}
	
	public void addTab(String title, EditorTabItem tab){
		addTab(title, tab);
	}
}
