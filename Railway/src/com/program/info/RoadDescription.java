package com.program.info;

import java.awt.geom.Ellipse2D;

//класс описания дороги
public class RoadDescription {
	private Ellipse2D.Float start; // координата начала

	private Ellipse2D.Float end; // координата конца

	private float length; // длина пути

	// конструктор по умолчанию
	public RoadDescription() {
		start = null;
		end = null;
		length = 0.0f;
	}

	// конструктор с параметрами точек пути
	public RoadDescription(Ellipse2D.Float startPoint, Ellipse2D.Float endPoint) {
		start = startPoint;
		end = endPoint;
	}

	// конструктор со всеми параметрами
	public RoadDescription(Ellipse2D.Float startPoint, Ellipse2D.Float endPoint, float FullLength) {
		start = startPoint;
		end = endPoint;
		length = FullLength;
	}

	// установка начальной точки через Эллипс
	public void setStartPoint(Ellipse2D.Float el1) {
		start = el1;
	}

	// установка начальной точки через передачу координат
	public void setStartPoint(float x1, float y1) {
		start.x = x1;
		start.y = y1;
	}

	// получение начальной точки пути
	public Ellipse2D.Float getStartPoint() {
		return start;
	}

	// установка конечной точки через Эллипс
	public void setEndPoint(Ellipse2D.Float el2) {
		end = el2;
	}

	// установка конечной точки через передчу координат
	public void setEndPoint(float x2, float y2) {
		end.x = x2;
		end.y = y2;
	}

	// получение конечной точки
	public Ellipse2D.Float getEndPoint() {
		return end;
	}

	// задать длину пути
	public void setLength(float l) {
		length = l;
	}

	// получить длину пути
	public float getLength() {
		return length;
	}
}
