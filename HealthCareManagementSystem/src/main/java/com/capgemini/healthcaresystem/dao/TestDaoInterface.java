package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.TestException;

public interface TestDaoInterface {
	
	
	Test getTest(int test_id) throws TestException;
	public List<Test> getTest();

}
