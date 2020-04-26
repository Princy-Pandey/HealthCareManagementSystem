package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.entity.Login;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;

public interface HealthCareSystemServiceInterface 
{
	
	public void addUser(User user);
	List<User> viewUser();
	List<Login> viewLogin(); 
	public void addLogin(Login login);

	/*
	boolean addRegistration(User user) throws HealthCareSystemServiceException;
	public List<User> login();
	User findById(int userId);
	boolean existsById(int userId);
	void updateData(User user);
	User findByEmail(String userMail);
	boolean existsByEmail(String userMail);
	String loginUser(String userMail, String userPassword) throws HealthCareSystemServiceException;
	*/
}
