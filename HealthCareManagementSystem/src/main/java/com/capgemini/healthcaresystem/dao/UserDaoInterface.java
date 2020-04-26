package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;

public interface UserDaoInterface {
	
	User getUser(String userId) throws UserException;
	public List<User> getUser();
}
