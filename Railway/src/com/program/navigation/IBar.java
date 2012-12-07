package com.program.navigation;

import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import com.program.exceptions.LogicException;

public interface IBar{
	public boolean addListenerToComponent(AbstractButton button, ActionListener listener) throws LogicException;
	public boolean addListenerToComponent(String buttonName, ActionListener listener) throws LogicException;
	public boolean addListenerToComponent(int position, ActionListener listener) throws LogicException;
}
