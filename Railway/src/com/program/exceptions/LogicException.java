package com.program.exceptions;

import java.util.HashMap;
import java.util.Map;

public class LogicException extends Throwable{

	private static final long serialVersionUID = 8746588683429059328L;
	
	Map<Errors, ExceptionElement> log = new HashMap<Errors, ExceptionElement>();
	
	public LogicException(Errors error, ExceptionElement element){
		log = new HashMap<Errors, ExceptionElement>();
		log.put(error, element);
	}

	public Map<Errors, ExceptionElement> getLog() {
		return log;
	}

	public void setLog(Map<Errors, ExceptionElement> log) {
		this.log = log;
	}
}
