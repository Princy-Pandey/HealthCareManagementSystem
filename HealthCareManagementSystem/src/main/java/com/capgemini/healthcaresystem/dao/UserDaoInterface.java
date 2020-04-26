package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.User;

public interface UserDaoInterface 
{
	boolean addRegistration(User user);
	List<User> login();
	boolean findId(int userId);
	User findById(int userId);
	void update(User user);
	boolean checkUserByMail(String userMail);
	User getUserByMail(String userMail);
	boolean findEmail(String userMail);
	User findByEmail(String userMail);
}
