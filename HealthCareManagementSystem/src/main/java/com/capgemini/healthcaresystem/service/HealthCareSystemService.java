package com.capgemini.healthcaresystem.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.healthcaresystem.dao.UserDaoInterface;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;

@Service("healtcaresystemservice")
@Transactional
public class HealthCareSystemService implements HealthCareSystemServiceInterface
{
	@Autowired
	private UserDaoInterface userDaoInterface;
	
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
	public Boolean delete(int userId) {
		// TODO Auto-generated method stub
		return userDaoInterface.delete(userId);
	}

	@Override
	public User findById(int userId) {
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
		return userDaoInterface.findEmail(userMail);}

	@Override
	public Integer loginUser(String userMail, String userPassword) throws HealthCareSystemServiceException 
	{
		// TODO Auto-generated method stub
		if(userDaoInterface.checkUserByMail(userMail)==false)
    		throw new HealthCareSystemServiceException("The entered User does not exist, Please enter a valid email");
    	
		User user=userDaoInterface.getUserByMail(userMail);
		if(user.getUser_password().equals(userPassword)==false)
    		throw new HealthCareSystemServiceException("The email and password Combination does not match");
		
		//user.setLoginStatus(login0.loggedIn);
		return user.getUser_id();
	}
	
	
}
