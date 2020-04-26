/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A  CentreException class that provides CentreException for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.exception;

public class CentreException extends Exception {

	private static final long serialVersionUID = 1L;

	public CentreException(String msg) {
		super(msg);
	}
}

