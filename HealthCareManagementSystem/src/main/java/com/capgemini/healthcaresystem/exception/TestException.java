/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A  TestException class that provides TestException for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.exception;

public class TestException extends Exception {


	private static final long serialVersionUID = 1L;

	public TestException(String msg) {
		super(msg);
	}
}