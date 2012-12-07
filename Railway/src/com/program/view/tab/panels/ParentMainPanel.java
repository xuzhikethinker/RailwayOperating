package com.program.view.tab.panels;

import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JPanel;

import com.program.exceptions.Errors;
import com.program.exceptions.ExceptionElement;
import com.program.exceptions.LogicException;

public class ParentMainPanel extends JPanel{
	
	private static final long serialVersionUID = -2894350013906707911L;
	
	public final static float MAX_ZOOM = 5f; 
	public final static float MIN_ZOOM = 0.2f;
	
	private List<Point2D> points;
	private List<Line2D> lines;
	
	private float zoomHeigth=1.0f;
	private float zoomWidth = 1.0f;	
	
	private float translateX = 0.0f;
	private float translateY = 0.0f;
	
	public List<Point2D> getPoints() {
		return points;
	}
	public void setPoints(List<Point2D> points) {
		this.points = points;
	}
	public List<Line2D> getLines() {
		return lines;
	}
	public void setLines(List<Line2D> lines) {
		this.lines = lines;
	}
	public float getZoomHeigth() {
		return zoomHeigth;
	}
	public void setZoomHeigth(float zoomHeigth) {
		this.zoomHeigth = zoomHeigth;
	}
	public float getZoomWidth() {
		return zoomWidth;
	}
	public void setZoomWidth(float zoomWidth) {
		this.zoomWidth = zoomWidth;
	}
	public float getTranslateX() {
		return translateX;
	}
	public void setTranslateX(float translateX) {
		this.translateX = translateX;
	}
	public float getTranslateY() {
		return translateY;
	}
	public void setTranslateY(float translateY) {
		this.translateY = translateY;
	}
	
	public ParentMainPanel clone(ParentMainPanel panel) throws LogicException{
		if (panel != null){
			ParentMainPanel temp = new ParentMainPanel();
			temp.setZoomHeigth(panel.getZoomHeigth());
			temp.setZoomWidth(panel.getZoomWidth());
			
			temp.setTranslateX(panel.getTranslateX());
			temp.setTranslateY(panel.getTranslateY());
			
			temp.setPoints(panel.getPoints());
			temp.setLines(panel.getLines());
			
			return temp;
		} else{
			throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", this.getClass()));
		}
	}
	
	protected void paintComponent(Graphics g){
		super.paint(g);
	}
}
