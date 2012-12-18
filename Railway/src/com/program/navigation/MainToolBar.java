package com.program.navigation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;

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
		JButton toolDeleteB = createButton("icons/delete.png","deleteButton", "Удалить линию");
		JButton toolSettingsB = createButton("icons/settings.png", "settingsButton", "Настройки");
		
		toolDrawB = createButton(toolStartImage , "drawButton","Начать рисование");
		toolDrawB.addActionListener(drawListener);
		
		JButton toolCancelB = createButton("icons/cancel.png",  "cancelButton", "Отмена (ctrl+z)");
		JButton toolNormalSizeB = createButton("icons/normal_size.png", "normalizeButton","Начальные размеры картинки");
		JButton toolStretchLeftB = createButton("icons/wide.png", "widingButtong","Расширить");
		JButton toolStretchRightB = createButton("icons/narrow.png", "narrowingButtong","Сузить");
		JButton toolStretchUpB = createButton("icons/up.png", "stretchingUpButton","Расширить вверх");
		JButton toolStretchDownB = createButton("icons/down.png", "stretchingDownButton","Сузить вовнутрь");
		JButton toolConnectRoadB = createButton("icons/connect_road.png", "choosePathButton","Выбрать маршрут");
		
		JCheckBox toolShowPicture = new JCheckBox("Показывать рисунок");
		toolShowPicture.setName("showPictureCheck");
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
	
	private JButton createButton(String iconPath, String name, String toolTipText){
		JButton button = new JButton(new ImageIcon(iconPath));
		button.setName(name);
		button.setToolTipText(toolTipText);
		return button;
	}

	@Override
	public boolean addListenerToComponent(AbstractButton button, ActionListener listener) throws LogicException {
		AbstractButton tool = findElement(button);
		if (tool != null){
			if (listener != null){
					tool.addActionListener(listener);
					return true;
				}
				return false;
			} else {
				return false;
		}
	}

	@Override
	public boolean addListenerToComponent(String buttonName, ActionListener listener) throws LogicException {
		JButton temp = new JButton();
		temp.setName(buttonName);
		AbstractButton tool = findElement(temp);
		if (tool != null){
			if (listener != null){
				tool.addActionListener(listener);
				return true;
			} else{
				return false;
			}
		} else{
			return false;
		}
	}
	
	public AbstractButton findElement(AbstractButton button){
		if (button != null){
			int size = getComponentCount();
			for (int i =0; i < size; ++i){
				if (getComponent(i).getName().equalsIgnoreCase(button.getName())){
					return (AbstractButton)getComponent(i);
				} 
			}
		}
		return null;
	}
}
