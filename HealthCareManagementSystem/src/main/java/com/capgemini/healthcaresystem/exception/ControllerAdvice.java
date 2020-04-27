package com.capgemini.healthcaresystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.healthcaresystem.exception.CentreException;



/************************************************************************************
*          @author          Princy Pandey
*          Description      It is a rest controller advice class for exceptions
*          Version          1.0
*          Created Date     23-APR-2020
************************************************************************************/


@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(value= CentreException.class)
	public ResponseEntity<Object> handleException(CentreException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= TestException.class)
	public ResponseEntity<Object> handleException(TestException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= UserException.class)
	public ResponseEntity<Object> handleException(UserException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= AppointmentException.class)
	public ResponseEntity<Object> handleException(AppointmentException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserDefinedException.class)
	public ResponseEntity<Object> handleException1(UserDefinedException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	
	
	
}
