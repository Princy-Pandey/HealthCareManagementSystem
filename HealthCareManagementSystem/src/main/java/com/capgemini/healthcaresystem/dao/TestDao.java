package com.capgemini.healthcaresystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.TestException;

/************************************************************************************
 * @author Princy Pandey Description It is a dao class that provides the methods
 *         for adding and removing test in a centre 
 *         
 * Version 1.0 
 * Created Date  20-APR-2020
 ************************************************************************************/

@Repository("testdao")
public class TestDao implements TestDaoInterface {

	@PersistenceContext
	EntityManager em;

	/************************************************************************************
	 * Method: addTest Description: To add test in diagnostic centre
	 * 
	 * @param addTest Adding test in a particular centre
	 * @returns Boolean true, if test added otherwise
	 ************************************************************************************/

	@Override
	public boolean addTest(Test test) {
		// TODO Auto-generated method stub
		em.persist(test);
		return true;
	}

	/************************************************************************************
	 * Method: deleteTest Description: To delete test in diagnostic centre
	 * 
	 * @param deleteCentre Deleting test in a particular centre
	 * @returns Boolean true, if test deleted otherwise
	 ************************************************************************************/

	@Override
	public boolean deleteTest(long testId) {
		// TODO Auto-generated method stub
		Test obj = em.find(Test.class, testId);
		em.remove(obj);
		return true;
	}

	/************************************************************************************
	 * Method: getTest Description: To fetch the centre made by admin
	 * 
	 * @param getTest Fetches all test
	 * @throws TestException It is raised due to test id does not exist
	 ************************************************************************************/

	@Override
	public Test getTest(long testId) throws TestException {
		// TODO Auto-generated method stub
		Test test = em.find(Test.class, testId);
		if (test == null)
			throw new TestException("Test Id does not exist for " + testId);
		return test;
	}

	/************************************************************************************
	 * Method: getTest Description: To fetch the centre made by admin
	 * 
	 * @param getTest Fetches all test
	 * @throws TestException It is raised due to test id does not exist
	 ************************************************************************************/

	@Override
	public List<Test> getTest() {
		// TODO Auto-generated method stub
		TypedQuery<Test> query = em.createQuery("from Test", Test.class);
		return query.getResultList();
	}

	/************************************************************************************
	 * Method: viewTestById Description: To fetch the Test made by admin
	 * 
	 * @param viewTestById Fetches all test
	 * @throws TestException It is raised due to test id does not exist
	 ************************************************************************************/

	@Override
	public Test viewTestById(long testId) {
		// TODO Auto-generated method stub
		return em.find(Test.class, testId);
	}

}
