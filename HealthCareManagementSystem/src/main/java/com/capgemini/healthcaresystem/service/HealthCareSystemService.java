package com.capgemini.healthcaresystem.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.UserDaoInterface;
import com.capgemini.healthcaresystem.entity.Login;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;

@Service("healtcaresystemservice")
@Transactional
public class HealthCareSystemService implements HealthCareSystemServiceInterface
{
	@Autowired
	private UserDaoInterface userDao;
	
	@Override
	public boolean addRegistration(User user) throws HealthCareSystemServiceException
	{
		// TODO Auto-generated method stub
		return userDao.addRegistration(user);
	}
	
	public Login getLogin() throws HealthCareSystemServiceException {
		Login login = new Login();
		return login;
	}

	//return employee as null
	public Login getLoginNull() throws HealthCareSystemServiceException 
	{
		return null;
	}

    //throw exception
	public Login getLoginException() throws HealthCareSystemServiceException 
	{
		throw new HealthCareSystemServiceException();
	}
}
