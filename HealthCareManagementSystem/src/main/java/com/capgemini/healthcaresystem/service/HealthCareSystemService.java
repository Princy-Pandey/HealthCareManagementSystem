package com.capgemini.healthcaresystem.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.LoginDaoInterface;
import com.capgemini.healthcaresystem.dao.UserDaoInterface;
import com.capgemini.healthcaresystem.entity.Login;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;

@Service("healtcaresystemservice")
@Transactional
public class HealthCareSystemService implements HealthCareSystemServiceInterface
{
	@Autowired
	private UserDaoInterface userDaoInterface;
	
	@Autowired
	private LoginDaoInterface loginDaoInterface;

	@Override
	public void addUser(User user) 
	{
		// TODO Auto-generated method stub
		userDaoInterface.addUser(user);
	}

	@Override
	public List<User> viewUser() 
	{
		// TODO Auto-generated method stub
		return userDaoInterface.getUser();	
	}

	@Override
	public List<Login> viewLogin() 
	{
		// TODO Auto-generated method stub
		return loginDaoInterface.getLogin();	
	}
	
	
	/*
	@Override
	public boolean addRegistration(User user) throws HealthCareSystemServiceException
	{
		// TODO Auto-generated method stub
		return userDaoInterface.addRegistration(user);
	}

	
	
	@Override
	public List<User> login() 
	{
		// TODO Auto-generated method stub
		System.out.println(userDaoInterface.login());
		return userDaoInterface.login();
	}

	@Override
	public User findById(int userId) 
	{
		// TODO Auto-generated method stub
		return userDaoInterface.findById(userId);
	}

	@Override
	public boolean existsById(int userId) 
	{
		// TODO Auto-generated method stub
		return userDaoInterface.findId(userId);
	}

	@Override
	public void updateData(User user) 
	{
		// TODO Auto-generated method stub
		userDaoInterface.update(user);		
	}

	@Override
	public User findByEmail(String userMail) 
	{
		// TODO Auto-generated method stub
		return userDaoInterface.findByEmail(userMail);
	}

	@Override
	public boolean existsByEmail(String userMail) 
	{
		// TODO Auto-generated method stub
		return userDaoInterface.findEmail(userMail);
	}

	@Override
	public String loginUser(String user_mail, String user_password) throws HealthCareSystemServiceException 
	{
		// TODO Auto-generated method stub
		if(userDaoInterface.checkUserByMail(user_mail)==false)
    		throw new HealthCareSystemServiceException("The entered User does not exist, Please enter a valid email");
    	
		User user=userDaoInterface.getUserByMail(user_mail);
		if(user.getUserPassword().equals(user_password)==false)
    		throw new HealthCareSystemServiceException("The email and password Combination does not match");
		
		//user.setLoginStatus(login0.loggedIn);
		return user.getUserId();
	}
	*/
	
}
