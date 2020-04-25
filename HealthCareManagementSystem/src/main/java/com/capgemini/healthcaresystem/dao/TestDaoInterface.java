package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.TestException;

public interface TestDaoInterface {
	
	public void addTest(Test test);
	public void deleteTest(int test_id);
	Test getTest(int test_id) throws TestException;
	public List<Test> getTest();

}
