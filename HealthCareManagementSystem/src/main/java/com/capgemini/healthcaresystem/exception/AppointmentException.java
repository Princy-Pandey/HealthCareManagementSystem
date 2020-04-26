/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A  AppointmentException class that provides AppointmentException for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.exception;

public class AppointmentException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public AppointmentException(String msg) {
		super(msg);
	}
}

