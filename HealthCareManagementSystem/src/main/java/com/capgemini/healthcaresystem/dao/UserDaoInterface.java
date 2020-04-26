package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.entity.User;

public interface UserDaoInterface 
{
	//boolean addRegistration(User user);
	
	public void addUser(User user);
	User getUser(String userId);
	public List<User> getUser();

	
}
