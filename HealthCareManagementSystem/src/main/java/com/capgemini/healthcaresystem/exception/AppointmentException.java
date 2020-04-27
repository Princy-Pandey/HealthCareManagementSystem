package com.capgemini.healthcaresystem.exception;
/************************************************************************************
*          @author         Kiran Rajput
*          Description      It is a exception class for appointments
*          Version          1.0
*          Created Date     23-APR-2020
************************************************************************************/


public class AppointmentException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public AppointmentException(String msg) {
		super(msg);
	}
}

