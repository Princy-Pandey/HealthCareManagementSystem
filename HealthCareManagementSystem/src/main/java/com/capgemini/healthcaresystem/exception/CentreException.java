package com.capgemini.healthcaresystem.exception;



/************************************************************************************
*          @author          Princy Pandey
*          Description      It is a exception class for centre
*          Version          1.0
*          Created Date     23-APR-2020
************************************************************************************/

public class CentreException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CentreException(String msg) {
		super(msg);
	}
}

