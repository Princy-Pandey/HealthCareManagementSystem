package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.TestException;


/*****************Interface of Test ********************/

public interface TestDaoInterface {
	
	public boolean addTest(Test test);
	public boolean deleteTest(long testId);
	Test getTest(long testId) throws TestException;
	public List<Test> getTest();
	public Test viewTestById(long testId);

}
