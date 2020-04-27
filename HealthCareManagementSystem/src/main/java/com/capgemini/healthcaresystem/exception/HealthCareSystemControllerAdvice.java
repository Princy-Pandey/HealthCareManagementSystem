package com.capgemini.healthcaresystem.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class HealthCareSystemControllerAdvice 
{
	@ExceptionHandler(HealthCareSystemServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final HealthCareSystemServiceException hcsexception,final UserException userexception , final HttpServletRequest request)
	{
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(hcsexception.getMessage());
		error.setErrorMessage(userexception.getMessage());
		error.callerURL(request.getRequestURI());
		return error;
	}
}
