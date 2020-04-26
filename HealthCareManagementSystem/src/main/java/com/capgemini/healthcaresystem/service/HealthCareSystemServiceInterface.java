package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;

public interface HealthCareSystemServiceInterface 
{
	boolean addRegistration(User user) throws HealthCareSystemServiceException;
	public List<User> login();
	User findById(int userId);
	boolean existsById(int userId);
	void updateData(User user);
	User findByEmail(String userMail);
	boolean existsByEmail(String userMail);
	Integer loginUser(String userMail, String userPassword) throws HealthCareSystemServiceException;
}
