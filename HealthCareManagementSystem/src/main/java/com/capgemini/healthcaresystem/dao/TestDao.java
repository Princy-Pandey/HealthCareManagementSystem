package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.TestException;

/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a dao class that provides the methods for adding
 *                           and removing test in a centre 
 *          Version          1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/


@Repository
public class TestDao implements TestDaoInterface {
	
	@PersistenceContext
	EntityManager em;

	/************************************************************************************
	 * Method:                        getTest
     * Description:                   To fetch the centre made by admin 
	 * @param getTest                 Fetches all test  
	 * @throws TestException          It is raised due to test id does not exist
	 ************************************************************************************/
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
