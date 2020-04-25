package com.capgemini.healthcaresystem.exception;

public class HealthCareSystemServiceException extends Exception
{
	private static final long serialVersionUID = -470180507998010368L;

	public HealthCareSystemServiceException() {
		super();
	}

	public HealthCareSystemServiceException(final String message) {
		super(message);
	}
}
