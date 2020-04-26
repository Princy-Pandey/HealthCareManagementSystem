/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A UserDao class that provides UserDao for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
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
	public User getUser(int user_id) throws UserException {
		// TODO Auto-generated method stub
		User user=em.find(User.class, user_id);
		if(user==null) throw new UserException("User Id not exist for "+ user_id);
		return user;
		
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		TypedQuery<User> query=em.createQuery("from User", User.class);
		return query.getResultList();	
		}

	

}
