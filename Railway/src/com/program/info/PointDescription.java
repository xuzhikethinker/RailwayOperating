package com.program.info;
import com.program.exceptions.LogicException;
import com.program.validation.Validator;

public class PointDescription {
	private short number = 0;// номер (задается, если ссылается не меньше, чем на 3 пути)
	private boolean descript; // true - левосторонний, false - правосторонний
	private String mark; // марка стрелочного перевода
	private boolean normPosture; // нормальное положение + :true, - :false
	private short roadAmount = 0; // количество исходящих/входящих путей

	public PointDescription() {
		number++;
		descript = true;
		mark = "Default";
		normPosture = true;
		roadAmount = 0;
	}

	public PointDescription(short number, boolean descript, String mark,
			boolean normPosture, short roadAmount) throws LogicException {
		super();
		this.number = number;
		this.descript = descript;
		this.mark = Validator.validateString(mark);
		this.normPosture = normPosture;
		this.roadAmount = roadAmount;
	}

	// задать номер
	public void setNumber(short num) {
		number = num;
	}

	// получить номер
	public int getNumber() {
		return number;
	}

	// задать описание
	public void setDescription(boolean des) {
		if (roadAmount < 3)
			descript = des;
	}

	// получитеь описание
	public boolean getDescription() {
		return descript;
	}

	// задать марку
	public void setMark(String m) throws LogicException {
		if (roadAmount < 3)
			mark = Validator.validateString(m);
	}

	// получить марку
	public String getMark() {
		return mark;
	}

	// задать нормальное положение
	public void setPosture(boolean p) {
		if (roadAmount < 3)
			normPosture = p;
	}

	// получить нормальное положение
	public boolean getPosture() {
		return normPosture;
	}

	public void RoadAmountInc() {
		roadAmount++;
	}

	public void RoadAmountDec() {
		roadAmount--;
	}

	public short GetRoadAmount() {
		return roadAmount;
	}
}
