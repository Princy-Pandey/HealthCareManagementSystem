package com.capgemini.healthcaresystem;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.healthcaresystem.dao.UserDaoInterface;
import com.capgemini.healthcaresystem.entity.User;
//import com.capgemini.healthcaresystem.entity.User;

@Transactional
@SpringBootApplication
public class HealthCareManagementSystemApplication // implements CommandLineRunner
{
	
	@Autowired
	EntityManager em;
	
	public static void main(String[] args) {
		SpringApplication.run(HealthCareManagementSystemApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception 
	{
		// TODO Auto-generated method stub
		User user = new User("user","Maneesh","maani12k","user12",1890,"Male",21,"DodoMan");
		em.persist(user);
	}*/

}
