package com.program.ruler;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//класс, расширяющий JmenuBar (создаёт основное меню программы)
public class MainMenu extends JMenuBar {
	private static final long serialVersionUID = 1L;

	public MainMenu(){
		setVisible(true);
	}

    public void setMenu() {
        Font font = new Font("Verdana", Font.PLAIN, 12);

        // File item from menuBar
        JMenu fileMenu = new JMenu("Файл");
        fileMenu.setFont(font);

        // menu item with 2 items
        JMenu newMenu = new JMenu("Новый");
        newMenu.setFont(font);
        fileMenu.add(newMenu);

        // draw with the help of lines item
        JMenuItem DrawItem = new JMenuItem("Редактор построения схем");
        DrawItem.setFont(font);
        newMenu.add(DrawItem);
 
        // draw with the help of ready components
        JMenuItem DrawItemCom = new JMenuItem("Модуль маневрирования");
        DrawItemCom.setFont(font);
        newMenu.add(DrawItemCom);

        // Open new project item
        JMenuItem openItem = new JMenuItem("Открыть проект");
        openItem.setFont(font);
        fileMenu.add(openItem);

        // Open new project item
        JMenuItem saveP = new JMenuItem("Сохранить");
        openItem.setFont(font);
        fileMenu.add(saveP);

        // Open new project item
        JMenuItem saveA = new JMenuItem("Сохранить как");
        openItem.setFont(font);
        fileMenu.add(saveA);

        // Exit item with Event to close program
        JMenuItem closeItem = new JMenuItem("Выход");
        closeItem.setFont(font);
        fileMenu.add(closeItem);
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(fileMenu);
    }

}
