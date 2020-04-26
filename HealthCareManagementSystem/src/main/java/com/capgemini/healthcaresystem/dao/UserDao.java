package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;



@Repository
public class UserDao implements UserDaoInterface{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public User getUser(String userId) throws UserException {
		// TODO Auto-generated method stub
		User user=em.find(User.class, userId);
		if(user==null) throw new UserException("User Id does not exist for "+ userId);
		return user;
		
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		TypedQuery<User> query=em.createQuery("from User", User.class);
		return query.getResultList();	
		}

	

}
