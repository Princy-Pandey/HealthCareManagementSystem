/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A UserDaoInterface class that provides UserDaoInterface for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;

public interface UserDaoInterface {
	
	User getUser(int user_id) throws UserException;
	public List<User> getUser();
}
