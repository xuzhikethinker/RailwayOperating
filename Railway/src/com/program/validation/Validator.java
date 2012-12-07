package com.program.validation;

import com.program.exceptions.Errors;
import com.program.exceptions.ExceptionElement;
import com.program.exceptions.LogicException;

public class Validator {
	
	public static String validateString(String str) throws LogicException{
		if (str != null){
			if (!str.isEmpty()){
				return str.trim();
			} else{
				throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", Validator.class.getClass()));
			}
		} else{
			throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", Validator.class.getClass()));
		}
	}
	
	public static Object validateObject(Object object) throws LogicException{
		if (object != null){
			return object;
		} else {
			throw new LogicException(Errors.NULL_ELEMENT, new ExceptionElement("Нулевой элемент", Validator.class.getClass()));
		}
	}
}
