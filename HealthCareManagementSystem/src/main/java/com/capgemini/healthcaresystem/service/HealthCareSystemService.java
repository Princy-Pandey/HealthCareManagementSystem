package com.capgemini.healthcaresystem.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.healthcaresystem.dao.UserDaoInterface;
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

	@Override
	public List<User> viewUser() 
	{
		// TODO Auto-generated method stub
		return userDaoInterface.getUser();	
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
	public Boolean deleteUser(String userId) {
		// TODO Auto-generated method stub
		return userDaoInterface.delete(userId);
	}
	
	@Override
	public boolean addRegistration(User user) throws HealthCareSystemServiceException
	{
		// TODO Auto-generated method stub
		return userDaoInterface.addRegistration(user);
	}
	
	@Override
	public int validateLogin(String userMail, String userPassword)
	{
		return userDaoInterface.validateLogin(userMail, userPassword);
	}

	@Override
	public int verifyUserSecretWord(String userMail, String secretWord) throws HealthCareSystemServiceException 
	{
		// TODO Auto-generated method stub
		if(userDaoInterface.checkUserByMail(userMail)==false)
			throw new HealthCareSystemServiceException(" This Mail Id doesn't exist, Please enter correct Mail Id! ");
		    	
		User user = userDaoInterface.getUserByMail(userMail);
		if(user.getSecretWord().equals(secretWord)==false || user.getUserRole().equals("admin"))
			return 0;
		else		
			return 1;
	}

	@Override
	public void logout(String userId) throws UserException
	{
		User user=userDaoInterface.getUser(userId);
	   	user.setLoginStatus(login.LoggedOut);
 	}
}
