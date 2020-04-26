package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.TestException;



@Repository
public class TestDao implements TestDaoInterface {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void addTest(Test test) {
		// TODO Auto-generated method stub
		em.persist(test);
	}

	@Override
	public void deleteTest(String testId) {
		// TODO Auto-generated method stub
		Test obj=em.find(Test.class, testId);
		em.remove(obj);
		
	}

	@Override
	public Test getTest(String testId) throws TestException {
		// TODO Auto-generated method stub
		Test test=em.find(Test.class, testId);
		if(test==null) throw new TestException("Test Id does not exist for "+ testId);
		return test;
	}

	@Override
	public List<Test> getTest() {
		// TODO Auto-generated method stub
		TypedQuery<Test> query=em.createQuery("from Test", Test.class);
		return query.getResultList();
	}

	

}
