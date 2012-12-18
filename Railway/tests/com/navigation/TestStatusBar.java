package com.navigation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.program.navigation.StatusBar;

public class TestStatusBar {

	StatusBar bar;
	
	@Before
	public void setUp() throws Exception {
		bar = new StatusBar();
	}

	@Test
	public void testAddError() {
		assertEquals(0, bar.getErrorsLog().size());
		bar.setException("Wrong");
		assertEquals(1, bar.getErrorsLog().size());
		assertEquals("Wrong", bar.getErrorsLog().get(0));
	}
	
	@Test
	public void testAddMessage() {
		assertEquals(1, bar.getMessagesLog().size());
		bar.setMessage("Wrong");
		assertEquals(2, bar.getMessagesLog().size());
		assertEquals("Wrong", bar.getMessagesLog().get(1));
	}
}
