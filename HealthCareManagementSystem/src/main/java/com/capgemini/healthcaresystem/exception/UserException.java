/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A  UserException class that provides UserException for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.exception;

public class UserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserException(String msg) {
		super(msg);
	}
}