package com.capgemini.healthcaresystem.dao;

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
	public boolean addRegistration(User user) 
	{
		// TODO Auto-generated method stub
		em.persist(user);
		return true;
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
	public List<User> getUser() 
	{
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("from User", User.class);
		List<User> userList = query.getResultList();
		return userList;
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
}
