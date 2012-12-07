package com.program.navigation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;

import com.program.exceptions.Errors;
import com.program.exceptions.ExceptionElement;
import com.program.exceptions.LogicException;


public class MainToolBar extends JToolBar implements IBar{

	private static final long serialVersionUID = 1L;
	private JButton toolDrawB = null;
	
	public MainToolBar(){
		setObjects();
		setFloatable(false);
		setVisible(true);
	}
	
	private String toolStartImage = "icons/draw.png";
	
	private ActionListener drawListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (toolStartImage.equalsIgnoreCase("icons/draw.png")){
				toolStartImage = "icons/stop.png";
			} 
			if (toolStartImage.equalsIgnoreCase("icons/stop.png")){
				toolStartImage = "icons/stART.png";
			}
			toolDrawB.setIcon(new ImageIcon(toolStartImage));
		}
	};

	private void setObjects(){
		JButton toolDeleteB = createButton("icons/delete.png", "Удалить линию");
		JButton toolSettingsB = createButton("icons/settings.png", "Настройки");
		
		toolDrawB = createButton(toolStartImage , "Начать рисование");
		toolDrawB.addActionListener(drawListener);
		
		JButton toolCancelB = createButton("icons/cancel.png", "Отмена (ctrl+z)");
		JButton toolNormalSizeB = createButton("icons/normal_size.png", "Начальные размеры картинки");
		JButton toolStretchLeftB = createButton("icons/wide.png", "Расширить");
		JButton toolStretchRightB = createButton("icons/narrow.png", "Сузить");
		JButton toolStretchUpB = createButton("icons/up.png", "Расширить вверх");
		JButton toolStretchDownB = createButton("icons/down.png", "Сузить вовнутрь");
		JButton toolConnectRoadB = createButton("icons/connect_road.png", "Выбрать маршрут");
		JCheckBox toolShowPicture = new JCheckBox("Показывать рисунок");
		toolShowPicture.setSelected(true);

		add(toolDrawB);
		add(toolCancelB);
		add(toolDeleteB);
		add(toolNormalSizeB);
		add(toolStretchLeftB);
		add(toolStretchRightB);
		add(toolStretchUpB);
		add(toolStretchDownB);
		add(toolSettingsB);
		add(toolConnectRoadB);
		add(toolShowPicture);
	}
	
	private JButton createButton(String iconPath, String toolTipText){
		JButton button = new JButton(new ImageIcon(iconPath));
		button.setToolTipText(toolTipText);
		return button;
	}

	@Override
	public boolean addListenerToComponent(AbstractButton button, ActionListener listener) throws LogicException {
		if (button != null){
			if (listener != null){
				int length = getComponentCount();
				for (int i=0; i< length; ++i){
					if (getComponent(i).equals(button)){
						AbstractButton temp = (AbstractButton)getComponent(i);
						temp.addActionListener(listener);
						return true;
					}
				}
				return false;
			} else {
				throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", this.getClass()));
			}
		} else{
			throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", this.getClass()));
		}
	}

	@Override
	public boolean addListenerToComponent(String buttonName, ActionListener listener) throws LogicException {
		if (buttonName != null){
			if (listener != null){
				int length = getComponentCount();
				for (int i=0; i< length; ++i){
					if (getComponent(i).getName().equals(buttonName)){
						AbstractButton temp = (AbstractButton)getComponent(i);
						temp.addActionListener(listener);
						return true;
					}
				}
				return false;
			} else{
				throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", this.getClass()));
			}
		} else{
			throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", this.getClass()));
		}
	}

	@Override
	public boolean addListenerToComponent(int position, ActionListener listener) throws LogicException {
		int length = getComponentCount();
		if ( position >= 0 && position < length ){
			if (listener != null){
				try{
					AbstractButton temp = (AbstractButton)getComponent(position);
					temp.addActionListener(listener);
					return true;
				} catch(Exception e){
					return false;
				}
			} else{
				throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", this.getClass()));
			}
		} else{
			throw new LogicException(Errors.OUT_OF_BOUNDS, new ExceptionElement("Позиция элемента не попадает в границы", this.getClass()));
		}
	}
}
