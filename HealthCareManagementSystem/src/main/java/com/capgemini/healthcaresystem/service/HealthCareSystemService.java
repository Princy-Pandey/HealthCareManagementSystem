package com.capgemini.healthcaresystem.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.healthcaresystem.dao.LoginDaoInterface;
import com.capgemini.healthcaresystem.dao.UserDaoInterface;
import com.capgemini.healthcaresystem.entity.Login;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.entity.User.login;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;
import com.capgemini.healthcaresystem.exception.UserException;

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
		user.setLoginStatus(login.loggedIn);
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

	@Override
	public boolean existsByMail(String userMail) 
	{
		// TODO Auto-generated method stub
		return userDaoInterface.findMail(userMail);
	}

	@Override
	public String updateData(User user, String userMail) throws HealthCareSystemServiceException 
	{
		// TODO Auto-generated method stub
		if (userDaoInterface.update(user,userMail)==true)
			return "updated";
		else 
			throw new HealthCareSystemServiceException("Error");
	}
	
	@Override
	public void logout(String userId) throws UserException
	{
		User user=userDaoInterface.getUser(userId);
	   	user.setLoginStatus(login.LoggedOut);
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
