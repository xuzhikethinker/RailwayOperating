package com.navigation;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JMenu;

import org.junit.Before;
import org.junit.Test;

import com.program.exceptions.LogicException;
import com.program.navigation.MainMenuBar;

public class TestMainMenuBar{

	private MainMenuBar bar;
	private ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	};
	private AbstractButton button = new JButton("Кнопка");
	private String name = "filemenu";
	
	@Before
	public void setUp() throws Exception {
 		bar = new MainMenuBar();
	}

	/*
	 * testing addListenerToComponent methods
	 */
	@Test
	public void shouldReturnFalseOnNullAB() throws LogicException {
		button = null;
		assertFalse(bar.addListenerToComponent(button, listener));
	}
	
	@Test 
	public void shouldReturnFalseOnNullListener() throws LogicException {
		assertFalse(bar.addListenerToComponent(button, null));
	}
	
	@Test
	public void shouldReturnFalseOnNotExistingElement() throws LogicException {
		assertFalse(bar.addListenerToComponent(button, listener));
	}
	
	@Test
	public void shouldReturnTrueOnExistingElement() throws LogicException {
		button = new JMenu("Файл");
		button.setName(name);
		assertTrue(bar.addListenerToComponent(button, listener));
	}
	
	//-------------------------------------------
	
	@Test
	public void shouldReturnFalseOnEmptyString() throws LogicException {
		assertFalse(bar.addListenerToComponent("", listener));
	}
	
	@Test 
	public void shouldReturnFalseOnNullListenerWithString() throws LogicException {
		assertFalse(bar.addListenerToComponent(name, null));
	}
	
	@Test
	public void shouldReturnFalseOnNotExistingElementString() throws LogicException {
		name = "sdfdsf";
		assertFalse(bar.addListenerToComponent(name, listener));
	}
	
	@Test
	public void shouldReturnTrueOnExistingElementString() throws LogicException {
		assertTrue(bar.addListenerToComponent(name, listener));
	}
	//--------------------------------------------
	

		@Test
		public void shouldReturnElement() throws LogicException {
			button = new JMenu("Файл");
			button.setName(name);
			assertNotNull(bar.findElement(button));
		}
		
		@Test
		public void shouldReturnNullElement() throws LogicException {
			button = new JMenu("Файл");
			button.setName("filemsf");
			assertNull(bar.findElement(button));
		}
		
}
