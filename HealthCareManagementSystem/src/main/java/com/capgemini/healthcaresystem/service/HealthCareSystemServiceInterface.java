package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;

public interface HealthCareSystemServiceInterface 
{
	List<User> viewUser() throws UserException;
	Boolean deleteUser(int userId);
	User viewUserByMail(String userMail);
	boolean existsByMail(String userMail) throws UserException;
	void updatePassword(String userMail, String userPassword, int userId); 
	boolean addRegistration(User user);
	int validateLogin(String userMail, String userPassword);
	int verifyUserSecretWord(String userMail, String secretWord) throws UserException;
}
