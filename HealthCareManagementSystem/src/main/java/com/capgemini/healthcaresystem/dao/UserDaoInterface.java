package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;

public interface UserDaoInterface 
{
	boolean addRegistration(User user);
	User getUser(String userId) throws UserException;
	public List<User> getUser();
	boolean checkUserByMail(String email);
	User getUserByMail(String email);
	boolean update(User user, String userMail);
	boolean findMail(String userMail);
	Boolean delete(String userId);	
}
