/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A TestDaoInterface class that provides TestDaoInterface for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.TestException;

public interface TestDaoInterface {
	
	
	Test getTest(String testId) throws TestException;
	public List<Test> getTest();


}
