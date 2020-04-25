package com.capgemini.healthcaresystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.capgemini.healthcaresystem.entity.User;

@Transactional
@Repository("userdao")
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
	
}
