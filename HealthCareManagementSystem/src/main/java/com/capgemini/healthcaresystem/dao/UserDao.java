package com.capgemini.healthcaresystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;



/************************************************************************************
 *          @author          Princy Pandey
 *          Description      It is a dao class that provides the methods to fetch 
 *                           user's details
 *          Version          1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/

@Repository("userdao")
public class UserDao implements UserDaoInterface{
	
	@PersistenceContext
	EntityManager em;

	
	/************************************************************************************
	 * Method:                        getUser
     * Description:                   To fetch the user details provided by him during 
     *                                registration 
	 * @param getUser                 Fetches all details of user  
	 * @throws UserException          It is raised due to user id does not exist
	 ************************************************************************************/
	
	@Override
	public User getUser(long userId) throws UserException {
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
