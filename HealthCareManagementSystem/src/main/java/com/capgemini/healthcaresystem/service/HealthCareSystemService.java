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
	public boolean addRegistration(User user) throws HealthCareSystemServiceException
	{
		// TODO Auto-generated method stub
		return userDaoInterface.addRegistration(user);
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

	@Override
	public User loginUser(String userMail, String userpassword) throws HealthCareSystemServiceException 
	{
		// TODO Auto-generated method stub
		if(userDaoInterface.checkUserByMail(userMail)==false)
    		throw new HealthCareSystemServiceException(" This Mail Id doesn't exist, Please enter correct Mail Id! ");
    	
		User user = userDaoInterface.getUserByMail(userMail);
		if(user.getUserPassword().equals(userpassword)==false)
    		throw new HealthCareSystemServiceException(" Password doesn't match with the existing one! ");
		
		return user;
	}

	@Override
	public String changePassword(String userMail, String secretWord) throws HealthCareSystemServiceException 
	{
		// TODO Auto-generated method stub
		if(userDaoInterface.checkUserByMail(userMail)==false)
			throw new HealthCareSystemServiceException(" This Mail Id doesn't exist, Please enter correct Mail Id! ");
		    	
		User user = userDaoInterface.getUserByMail(userMail);
		if(user.getSecretWord().equals(secretWord)==false)
			throw new HealthCareSystemServiceException(" Secret word doesn't match with the one you provided! ");
				
		return user.getUserPassword();
	}
	
	/*@Override
	public void addLogin(Login login) throws HealthCareSystemServiceException, UserException 
	{
		// TODO Auto-generated method stub
		
		User user = userDaoInterface.getUser(login.getUser().getUserId());
		Login login1 = new Login(login.getLoginId(), user);
		loginDaoInterface.addLogin(login1);		
	}*/	
}
