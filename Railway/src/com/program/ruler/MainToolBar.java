package com.program.ruler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;


public class MainToolBar extends JToolBar{

	private static final long serialVersionUID = 1L;
	
	public MainToolBar(){
		setFloatable(false);
		setVisible(true);
	}
	
	private String toolStartImage = "icons/draw.png";
	private ImageIcon toolStart = new ImageIcon(toolStartImage);
	
	
	public void SwitchStartImage(){
		if (toolStartImage.equalsIgnoreCase("icons/draw.png")){
			toolStart = new ImageIcon("icons/stop.png");
			toolStartImage = "icons/stop.png";
		}
		if (toolStartImage.equalsIgnoreCase("icons/stop.png")){
			toolStart = new ImageIcon("icons/draw.png");
			toolStartImage = "icons/draw.png";
		}
		
	}
	
	public void setToolBar(){

		JButton toolDeleteB = new JButton(new ImageIcon("icons/delete.png"));
		toolDeleteB.setToolTipText("Удалить линию");
//		toolDeleteB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				addFunc.Delete(masPanels.get(selectedTab));
//				requestFocus();
//			}
//		});

		JButton toolSettingsB = new JButton(new ImageIcon("icons/settings.png"));
		toolSettingsB.setToolTipText("Настройки");
//		toolSettingsB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				optionsDialog = new OptionsDialog(masPanels.get(selectedTab));
//				optionsDialog.addWindowListener(new WindowListener() {
//					public void windowOpened(WindowEvent arg0) {
//					}
//
//					public void windowIconified(WindowEvent arg0) {
//					}
//
//					public void windowDeiconified(WindowEvent arg0) {
//					}
//
//					public void windowDeactivated(WindowEvent arg0) {
//					}
//
//					public void windowClosing(WindowEvent arg0) {
//					}
//
//					public void windowClosed(WindowEvent arg0) {
//						requestFocus();
//					}
//
//					public void windowActivated(WindowEvent arg0) {
//					}
//				});
//			}
//		});

		JButton toolDrawB = new JButton(toolStart);
		toolDrawB.setToolTipText("Начать рисование");
//		toolDrawB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if (masPanels.get(selectedTab).ListenerOff == true) {
//					addFunc.StartDraw(masPanels.get(selectedTab));
//					requestFocus();
//				} else { // наоборот
//					addFunc.StopDraw(masPanels.get(selectedTab));
//					requestFocus();
//				}
//			}
//		});

		JButton toolCancelB = new JButton(new ImageIcon("icons/cancel.png"));
		toolCancelB.setToolTipText("Отмена (ctrl+z)");
//		toolCancelB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				addFunc.CtrlZ(masPanels.get(selectedTab));
//				requestFocus();
//			}
//		});

		JButton toolNormalSizeB = new JButton(new ImageIcon("icons/normal_size.png"));
		toolNormalSizeB.setToolTipText("Начальные размеры картинки");
//		toolNormalSizeB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				masPanels.get(selectedTab).zoomUp = 1f;
//				masPanels.get(selectedTab).zoomLeft = 1f;
//				masPanels.get(selectedTab).translateX = 1f;
//				masPanels.get(selectedTab).translateY = 1f;
//				masPanels.get(selectedTab).repaint();
//				requestFocus();
//			}
//		});

		JButton toolStretchLeftB = new JButton(new ImageIcon("icons/wide.png"));
		toolStretchLeftB.setToolTipText("Расширить");
//		toolStretchLeftB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if (masPanels.get(selectedTab).zoomLeft < masPanels
//						.get(selectedTab).maxZoom)
//					masPanels.get(selectedTab).zoomLeft += 0.1d; 
//				// наращиваем зум на 0,1
//				else
//					masPanels.get(selectedTab).zoomLeft -= 0.01;
//				// иначе уменьшаем на 0,1
//				masPanels.get(selectedTab).wasClik = false;
//				masPanels.get(selectedTab).repaint(); // перерисовываем
//				requestFocus();
//			}
//		});

		JButton toolStretchRightB = new JButton(new ImageIcon("icons/narrow.png"));
		toolStretchRightB.setToolTipText("Сузить");
//		toolStretchRightB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if (masPanels.get(selectedTab).zoomLeft > masPanels
//						.get(selectedTab).minZoom)
//					masPanels.get(selectedTab).zoomLeft -= 0.1d; 
//				// наращиваем зум на 0,1
//				else
//					masPanels.get(selectedTab).zoomLeft += 0.01; 
//				// иначе уменьшаем на 0,1
//				masPanels.get(selectedTab).wasClik = false;
//
//				masPanels.get(selectedTab).repaint(); // перерисовываем
//				requestFocus();
//			}
//		});

		JButton toolStretchUpB = new JButton(new ImageIcon("icons/up.png"));
		toolStretchUpB.setToolTipText("Расширить вверх");
//		toolStretchUpB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if (masPanels.get(selectedTab).zoomUp < masPanels
//						.get(selectedTab).maxZoom)
//					masPanels.get(selectedTab).zoomUp += 0.1d; 
//				else
//					masPanels.get(selectedTab).zoomUp -= 0.01; 
//				masPanels.get(selectedTab).wasClik = false;
//
//				masPanels.get(selectedTab).repaint(); // перерисовываем
//				requestFocus();
//			}
//		});

		JButton toolStretchDownB = new JButton(new ImageIcon("icons/down.png"));
		toolStretchDownB.setToolTipText("Сузить вовнутрь");
//		toolStretchDownB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if (masPanels.get(selectedTab).zoomUp > masPanels
//						.get(selectedTab).minZoom)
//					masPanels.get(selectedTab).zoomUp -= 0.1d; 
//				else
//					masPanels.get(selectedTab).zoomUp += 0.01; 
//				masPanels.get(selectedTab).wasClik = false;
//
//				masPanels.get(selectedTab).repaint(); // перерисовываем
//				requestFocus();
//			}
//		});

		JButton toolConnectRoadB = new JButton(new ImageIcon("icons/connect_road.png"));
		toolConnectRoadB.setToolTipText("Выбрать маршрут");
//		toolConnectRoadB.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				PanelDrawOnImage temp = masPanels.get(selectedTab);
//				if (temp.pathChoose == 0) {
//					if (temp.masLines.isEmpty() == false) {
//
//						masPanels.get(selectedTab).repaint();
//
//						temp.pathChoose = 1;
//						masPanels.get(selectedTab).infoPanel.SetType((byte) 3);
//						temp.paths.clear();
//					}
//				} else {
//					temp.pathChoose = 0;
//					temp.paths.clear();
//				}
//				temp.repaint();
//				requestFocus();
//			}
//		});
		
		JCheckBox toolShowPicture = new JCheckBox("Показывать рисунок");
		toolShowPicture.setEnabled(true);
//		toolShowPicture.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent arg0) {
//				if (masPanels.get(selectedTab).getShowPictureStatus() == 1){
//					masPanels.get(selectedTab).setShowPicture((byte)0);
//					masPanels.get(selectedTab).repaint();
//				} else{
//					masPanels.get(selectedTab).setShowPicture((byte)1);
//					masPanels.get(selectedTab).repaint();
//				}
//			}
//		});	

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
}
