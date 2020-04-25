package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.entity.Login;
@Transactional
@Repository
public class LoginDao implements LoginDaoInterface
{
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Login> Login() 
	{
		// TODO Auto-generated method stub
		TypedQuery<Login> query = em.createQuery("from LOGIN",Login.class);
		return query.getResultList();
	}	
}
