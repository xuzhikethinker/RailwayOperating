package com.program.exceptions;

public class ExceptionElement {
	private String description;
	private Class<?> element;
	
	public ExceptionElement(String description, Class<?> element) {
		super();
		this.description = description;
		this.element = element;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Class<?> getElement() {
		return element;
	}

	public void setElement(Class<?> element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "ExceptionElement [description=" + description + ", element="+ element + "]";
	}	
}
