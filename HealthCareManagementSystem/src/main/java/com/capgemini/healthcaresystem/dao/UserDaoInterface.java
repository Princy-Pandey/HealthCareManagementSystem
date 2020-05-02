package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;

public interface UserDaoInterface 
{
	public List<User> getUser();
	User getUser(String userId) throws UserException;
	boolean findMail(String userMail);
	Boolean delete(String userId);
	boolean update(User user, String userMail);
	boolean addRegistration(User user);
	boolean checkUserByMail(String email);
	User getUserByMail(String email);
	public int validateLogin(String userMail, String userPassword);
	int validateSecretWord(String userMail, String secretWord);	
}
