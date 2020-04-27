package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.entity.Login;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;

public interface HealthCareSystemServiceInterface 
{
	boolean addRegistration(User user) throws HealthCareSystemServiceException;
	List<User> viewUser();
	List<Login> viewLogin(); 
	User loginUser(String userMail, String userPassword) throws HealthCareSystemServiceException;
	String changePassword(String userMail, String secretWord) throws HealthCareSystemServiceException;

	//public void addLogin(Login login) throws HealthCareSystemServiceException, UserException;
}
