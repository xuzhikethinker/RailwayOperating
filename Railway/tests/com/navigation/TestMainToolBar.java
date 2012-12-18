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
import com.program.navigation.MainToolBar;

public class TestMainToolBar {

	private MainToolBar bar;
	private ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	};
	private AbstractButton button = new JButton("Кнопка");
	private String name = "drawButton";
	
	@Before
	public void setUp() throws Exception {
		bar = new MainToolBar();
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
		JButton but1 = new JButton();
		but1.setName(name);
		assertTrue(bar.addListenerToComponent(but1, listener));
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
			button = new JButton();
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
