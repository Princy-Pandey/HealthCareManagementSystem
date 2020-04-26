package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.TestException;



@Repository
public class TestDao implements TestDaoInterface {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Test getTest(int test_id) throws TestException {
		// TODO Auto-generated method stub
		Test test=em.find(Test.class, test_id);
		if(test==null) throw new TestException("Test Id not exist for "+ test_id);
		return test;
	}

	@Override
	public List<Test> getTest() {
		// TODO Auto-generated method stub
		TypedQuery<Test> query=em.createQuery("from Test", Test.class);
		return query.getResultList();
	}

	

}
