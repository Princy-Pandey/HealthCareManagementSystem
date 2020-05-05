package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;

public interface HealthCareSystemServiceInterface 
{
	List<User> viewUser() throws UserException;
	boolean existsByMail(String userMail) throws UserException;
	void updatePassword(String userMail, String userPassword); 
	Boolean deleteUser(int userId);
	boolean addRegistration(User user);
	int validateLogin(String userMail, String userPassword);
	int verifyUserSecretWord(String userMail, String secretWord) throws UserException;
	User viewUserByMail(String userMail);
}
