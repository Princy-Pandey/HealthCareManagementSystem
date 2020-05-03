package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;


/*****************Interface of User ********************/

public interface UserDaoInterface {
	
	User getUser(long userId) throws UserException;
	public List<User> getUser();
}
