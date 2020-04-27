package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.Login;

public interface LoginDaoInterface 
{
	Login getLogin(String loginId);
	public List<Login> getLogin();
	public void addLogin(Login login);
	boolean checkUserByMail(String user_mail);
	Login getUserByMail(String user_mail);
	
	/*boolean findId(int userId);
	User findById(int userId);
	void update(User user);
	User findByEmail(String userMail);
	List<Login> login();
	boolean checkUserByMail(String user_mail);
	boolean findEmail(String user_mail);
	Login getUserByMail(String user_mail);
	*/
}
