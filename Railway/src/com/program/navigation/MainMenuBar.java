package com.program.navigation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.program.exceptions.LogicException;


public class MainMenuBar extends JMenuBar implements IBar{
	private static final long serialVersionUID = 1L;

	public MainMenuBar(){
		setMenu();
		setVisible(true);
	}

    private void setMenu() {
        Font font = new Font("Verdana", Font.PLAIN, 12);
        setFont(font);
        
        JMenu fileMenu = new JMenu("Файл");
        	fileMenu.setName("filemenu");
        
        	JMenu newMenu = new JMenu("Новый");
        
		        JMenuItem DrawItem = new JMenuItem("Редактор построения схем");
		        newMenu.add(DrawItem);
 
		        JMenuItem DrawItemCom = new JMenuItem("Модуль маневрирования");
		         newMenu.add(DrawItemCom);

	        JMenuItem openItem = new JMenuItem("Открыть проект");
	        JMenuItem saveP = new JMenuItem("Сохранить");
	        JMenuItem saveA = new JMenuItem("Сохранить как");
            JMenuItem closeItem = new JMenuItem("Выход");
		    	closeItem.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    			System.exit(0);
		            }
		        });

        fileMenu.add(newMenu);
        fileMenu.add(openItem);
        fileMenu.add(saveP);
        fileMenu.add(saveA);
        fileMenu.add(closeItem); 
        add(fileMenu);
    }

    @Override
	public boolean addListenerToComponent(AbstractButton button, ActionListener listener) throws LogicException {
		AbstractButton menu = findElement(button);
    	
    	if (menu != null){
			if (listener != null){
				menu.addActionListener(listener);
				return true;
			} else {
				return false;
			}
		} else{
			return false;
		}
	}

	@Override
	public boolean addListenerToComponent(String buttonName, ActionListener listener) throws LogicException {
		JButton temp = new JButton();
		temp.setName(buttonName);
		AbstractButton menu = findElement(temp);
		if (menu != null){
			if (listener != null){
				menu.addActionListener(listener);
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
			int size = getMenuCount();
			for (int i =0; i < size; ++i){
				if (getMenu(i).getName().equalsIgnoreCase(button.getName())){
					return getMenu(i);
				} else{
					findElement(getMenu(i));
				}
			}
		}
		return null;
	}
}
