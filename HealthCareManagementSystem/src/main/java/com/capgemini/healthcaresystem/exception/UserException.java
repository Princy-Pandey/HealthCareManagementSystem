package com.capgemini.healthcaresystem.exception;



/************************************************************************************
*          @author          Princy Pandey
*          Description      It is a exception class for user
*          Version          1.0
*          Created Date     23-APR-2020
************************************************************************************/

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserException(String msg) {
		super(msg);
	}
}