package com.program.navigation;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.program.exceptions.Errors;
import com.program.exceptions.ExceptionElement;
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
		if (button != null){
			if (listener != null){
				int position = getComponentIndex(button);
				
				if (position >= 0){
					try {
						AbstractButton temp = (AbstractButton)getComponent(position);
						temp.addActionListener(listener);
						return true;
					} catch (Exception e){
						return false;
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
