package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.healthcaresystem.entity.User;

@Transactional
@Repository("UserDao")
public class UserDao implements UserDaoInterface
{
	@PersistenceContext
	EntityManager em;

	/*@Override
	public boolean addRegistration(User user) 
	{
		// TODO Auto-generated method stub
		em.persist(user);
		return true;
	}*/

	@Override
	public void addUser(User user) 
	{
		// TODO Auto-generated method stub
		em.persist(user);
	}

	@Override
	public User getUser(String userId) 
	{
		// TODO Auto-generated method stub
		User user = em.find(User.class, userId);
		//if(user==null) 
			//throw new userException("User Id does not exist for "+ userId);
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
}
