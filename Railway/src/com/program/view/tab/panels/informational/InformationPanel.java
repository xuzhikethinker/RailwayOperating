package com.program.view.tab.panels.informational;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.program.exceptions.Errors;
import com.program.exceptions.ExceptionElement;
import com.program.exceptions.LogicException;
import com.program.info.PointDescription;
import com.program.info.RoadDescription;

public class InformationPanel extends JPanel{

	private static final long serialVersionUID = 4425811893238216781L;
	
	private final int LABEL_X_SIZE = 60;
	private final int FIELD_Y_SIZE = 20;
	
	private InfoRegimes regime = InfoRegimes.UNDEFINED;
	private PointDescription pd = new PointDescription();
	private RoadDescription rd = new RoadDescription();
	
	public InformationPanel(InfoRegimes regime){
		this.regime = regime;
		drawObjects(regime);
	}
	
	public PointDescription getPointDescr() {
		return pd;
	}

	public InformationPanel setPointDescription(PointDescription pointDescription) throws LogicException {
		if (pointDescription != null){
			this.pd = pointDescription;
			drawObjects(InfoRegimes.POINT);
			this.regime = InfoRegimes.POINT;
			return this;
		} else{
			throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", this.getClass()));
		}
	}

	public RoadDescription getRoadDescr() {
		return rd;
	}

	public InformationPanel setRoadDescr(RoadDescription roadDescription) throws LogicException {
		if (roadDescription != null){
			this.rd = roadDescription;
			drawObjects(InfoRegimes.LINE);
			this.regime = InfoRegimes.LINE;
			return this;
		} else{
			throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", this.getClass()));
		}
	}

	public InformationPanel(){
		drawObjects(regime);
	}
	
	private void drawObjects(InfoRegimes regime){
		if (regime == InfoRegimes.LINE){
			drawLineInfo();
		} else{
			if (regime == InfoRegimes.POINT){
				drawPointInfo();
			} else{
				
			}
		}
	}
	
	private void drawLineInfo(){
		removeAll();
		
		JLabel point1 = setLabel(100, FIELD_Y_SIZE, 100, 10, "Первая точка");
		
		//start point ----------------
		JLabel x1 = setLabel(20, FIELD_Y_SIZE, 25, 35, "X1");
		JTextField x1T = setTextField(45, FIELD_Y_SIZE, 70, 35, String.valueOf(rd.getStartPoint().getX()));
		JLabel y1 = setLabel(20, FIELD_Y_SIZE, 25, 60, "Y1");
		JTextField y1T = setTextField(45, FIELD_Y_SIZE, 70, 60, String.valueOf(rd.getStartPoint().getY()));
		
		//end point --------------
		JLabel point2 = setLabel(100, FIELD_Y_SIZE, 100, 85, "Вторая точка");
		JLabel x2 = setLabel(20, FIELD_Y_SIZE, 25, 110, "X2");
		JTextField x2T = setTextField(45, FIELD_Y_SIZE, 70, 110, String.valueOf(rd.getEndPoint().getX()));
		JLabel y2 = setLabel(20, FIELD_Y_SIZE, 25, 135, "Y2");
		JTextField y2T = setTextField(45, FIELD_Y_SIZE, 70, 135, String.valueOf(rd.getEndPoint().getY()));
				
		JLabel length = setLabel(40, FIELD_Y_SIZE, 25, 170, "Длина");
		JTextField lengthT = setTextField(45, FIELD_Y_SIZE, 70, 170, String.valueOf(rd.getLength()));
				
		JButton changeRoadB = setButton("Изменить", 120, 30, 100, 240);

		add(point1);
		add(x1);
		add(x1T);
		add(y1);
		add(y1T);
		add(point2);
		add(x2);
		add(x2T);
		add(y2);
		add(y2T);
		add(length);
		add(lengthT);
		add(changeRoadB);
	}
	
	private void drawPointInfo(){
		removeAll();
		
		JLabel numberSP = setLabel(LABEL_X_SIZE, FIELD_Y_SIZE, 10, 20, "Номер: ");
		JTextField spNumberT = setTextField(30, FIELD_Y_SIZE, 130, 20, String.valueOf(pd.getNumber()));		
		JLabel descriptSP = setLabel(80, FIELD_Y_SIZE, 10, 45, "Описание: ");
								
	    boolean gd = pd.getDescription();
	    String descr;
        if (gd)
            descr = "Left";
        else
            descr = "Right";
        JTextField spDescriptionT = setTextField(60, 20, 130, 45, descr);	
		JLabel markSP = setLabel(LABEL_X_SIZE, FIELD_Y_SIZE, 10, 70, "Марка: ");		
		JTextField spMarkT = setTextField(60, FIELD_Y_SIZE, 130, 70, pd.getMark());	
		JLabel postSP = setLabel(120, FIELD_Y_SIZE, 10, 95, "Нормальное положение: ");
		
		
		boolean p = pd.getPosture();
        if (p)
            descr = "+";
        else
            descr = "-";
		
        JTextField spPositionT = setTextField(30, FIELD_Y_SIZE, 130, 95, descr);
		JButton changeSpB = setButton("Изменить",120, 30, 100, 170);
		
		add(numberSP);
		add(spNumberT);
		add(descriptSP);
		add(spDescriptionT);
		add(markSP);
		add(spMarkT);
		add(postSP);
		add(spPositionT);
		add(changeSpB);
	}

	public InfoRegimes getRegime() {
		return regime;
	}

	public InformationPanel setRegime(InfoRegimes regime) {
		this.regime = regime;
		return this;
	}	
	
	private JTextField setTextField(int sizeX, int sizeY, int locX, int locY, String text){
	    JTextField field = new JTextField(text);
		field.setSize(sizeX, sizeY);
	    field.setBorder(BorderFactory.createLineBorder(Color.black));
	    field.setLocation(locX, locY);
	    field.setVisible(true);
	    return field;
	}
	
    private JButton setButton(String name, int sizeX, int sizeY, int locX, int locY){
        JButton button = new JButton(name);
    	button.setSize(100, 30);
        button.setLocation(locX, locY);
        button.setVisible(true);
        return button;
    }
    
    private JLabel setLabel(int sizeX, int sizeY, int locX, int locY, String text){
    	JLabel label = new JLabel(text);
		label.setSize(sizeX, sizeY);
	    label.setLocation(locX, locY);
	    label.setVisible(true);
	    return label;
    }
}
