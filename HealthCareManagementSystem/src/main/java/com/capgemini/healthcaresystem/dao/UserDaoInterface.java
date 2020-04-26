package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.UserException;

public interface UserDaoInterface {
	
	User getUser(int user_id) throws UserException;
	public List<User> getUser();
}
