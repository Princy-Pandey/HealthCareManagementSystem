package com.capgemini.healthcaresystem;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.healthcaresystem.dao.UserDaoInterface;
//import com.capgemini.healthcaresystem.entity.User;

@SpringBootApplication
public class HealthCareManagementSystemApplication // implements CommandLineRunner
{
	@Autowired
	UserDaoInterface userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(HealthCareManagementSystemApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception 
	{
		// TODO Auto-generated method stub
		User user = new User();
		userDao.addRegistration(user);
	}*/

}
