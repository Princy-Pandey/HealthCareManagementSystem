package com.capgemini.healthcaresystem.service;

import com.capgemini.healthcaresystem.entity.Login;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;

public interface HealthCareSystemServiceInterface 
{
	boolean addRegistration(User user) throws HealthCareSystemServiceException;

	Login getLoginException() throws HealthCareSystemServiceException;

	Login getLoginNull() throws HealthCareSystemServiceException;

	Login getLogin() throws HealthCareSystemServiceException;
}
