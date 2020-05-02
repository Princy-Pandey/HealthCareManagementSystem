package com.capgemini.healthcaresystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;

@Transactional
@Repository("UserDao")
public class UserDao implements UserDaoInterface
{
	@PersistenceContext
	EntityManager em;

	@Override
	public List<User> getUser() 
	{
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("from User", User.class);
		List<User> userList = query.getResultList();
		return userList;
	}
	
	@Override
	public User getUser(String userId) throws UserException 
	{
		// TODO Auto-generated method stub
		User user = em.find(User.class, userId);
		if(user==null) 
			throw new UserException("User Id does not exist for "+ userId);
		return user;
	}
	
	@Override
	public boolean findMail(String userMail) 
	{
		// TODO Auto-generated method stub
		if(em.contains(em.find(User.class, userMail)))
		{
			return true;
		}
		return false;
	}

	@Override
	public Boolean delete(String userId) 
	{
		// TODO Auto-generated method stub
		User user = em.find(User.class, userId);
		if(user!=null)
		{
			em.remove(user);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean update(User user, String userMail) 
	{
		// TODO Auto-generated method stub
		User updateUser =  em.find(User.class, userMail);
		updateUser.setUserName(user.getUserName());
		updateUser.setUserPassword(user.getUserPassword());
		updateUser.setUserContact(user.getUserContact());
		updateUser.setUserAge(user.getUserAge());
		updateUser.setSecretWord(user.getSecretWord());
		em.persist(updateUser);
		return true;
	}

	
	@Override
	public boolean addRegistration(User user) 
	{
		// TODO Auto-generated method stub
		em.persist(user);
		return true;
	}
	
	@Override
	public boolean checkUserByMail(String userMail) 
	{
		// TODO Auto-generated method stub
		String Qstr = "SELECT user.userMail FROM User user WHERE user.userMail = :USER_MAIL";
   		TypedQuery<String> query = em.createQuery(Qstr,String.class).setParameter("USER_MAIL",userMail);
   		try
   		{
   			query.getSingleResult();
   		}
   		catch(Exception ex)
   		{
   			return false;
   		}
   		return true;
	}
	
	@Override
	public User getUserByMail(String userMail) 
	{
		// TODO Auto-generated method stub
		String Qstr = "SELECT user FROM User user WHERE user.userMail = :USER_MAIL";
   		TypedQuery<User> query = em.createQuery(Qstr,User.class).setParameter("USER_MAIL",userMail);
   		return query.getSingleResult();
	}
	
	@Override
	public int validateLogin(String userMail, String userPassword)
	{
		List<User> loginList = new ArrayList();
		String Qstr = "SELECT user FROM User user WHERE user.userMail= :USER_MAIL";
		TypedQuery<User> query = em.createQuery(Qstr, User.class).setParameter("USER_MAIL",userMail);
		loginList = query.getResultList();
		
		if(loginList.size()>0)
		{
			if(loginList.get(0).getUserPassword().equals(userPassword) && loginList.get(0).getUserRole().equals("user"))
				return 1;
			else if(loginList.get(0).getUserPassword().equals(userPassword) && loginList.get(0).getUserRole().equals("admin"))
				return 2;
			else
				return 0;
		}
		else
			return 0;
	}
	
	@Override
	public int validateSecretWord(String userMail, String secretWord)
	{
		List<User> verifyList = new ArrayList();
		String Qstr = "SELECT user FROM User user WHERE user.userMail= :USER_MAIL";
		TypedQuery<User> query = em.createQuery(Qstr, User.class).setParameter("USER_MAIL",userMail);
		verifyList = query.getResultList();
		
		if(verifyList.size()>0)
		{
			if(verifyList.get(0).getSecretWord().equals(secretWord) && verifyList.get(0).getUserRole().equals("user"))
				return 1;
			else
				return 0;
		}
		else
			return 0;
	}
}
