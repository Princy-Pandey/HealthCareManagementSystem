package com.capgemini.healthcaresystem.exception;


public class UserDefinedException extends Exception{       //RuntimeException

	private static final long serialVersionUID = 1L;

	public UserDefinedException(String msg) {
		super(msg);
	}
}