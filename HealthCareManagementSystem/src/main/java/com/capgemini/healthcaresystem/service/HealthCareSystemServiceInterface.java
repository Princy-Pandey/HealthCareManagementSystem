package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;
import com.capgemini.healthcaresystem.exception.UserException;

public interface HealthCareSystemServiceInterface 
{
	List<User> viewUser();
	boolean existsByMail(String userMail);
	String updateData(User user, String userMail) throws HealthCareSystemServiceException;
	Boolean deleteUser(String userId);
	boolean addRegistration(User user) throws HealthCareSystemServiceException;
	public int validateLogin(String userMail, String userPassword);
	int verifyUserSecretWord(String userMail, String secretWord) throws HealthCareSystemServiceException;
	void logout(String userId) throws UserException;
}
