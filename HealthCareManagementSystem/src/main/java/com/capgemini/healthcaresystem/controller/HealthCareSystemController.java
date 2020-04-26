package com.capgemini.healthcaresystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;
import com.capgemini.healthcaresystem.service.HealthCareSystemServiceInterface;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HealthCareSystemController 
{
	@Autowired
	private HealthCareSystemServiceInterface serviceInterfaceObject;
	
	@GetMapping("/getLogin")
	public ResponseEntity<Object> getLogin()
	{
		return new ResponseEntity<>(serviceInterfaceObject.viewLogin(),HttpStatus.OK);
	}
	
	@GetMapping("/getUser")
	public ResponseEntity<Object> getUser()
	{
		return new ResponseEntity<>(serviceInterfaceObject.viewUser(),HttpStatus.OK);
	}

	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser( @RequestBody User user) throws HealthCareSystemServiceException
	{	
		try 
		{
			serviceInterfaceObject.addUser(user);
			return new ResponseEntity<>("User Added",HttpStatus.OK);
		}
		catch(DataIntegrityViolationException ex)
		{
			throw new HealthCareSystemServiceException("Id already exists");
		}
	}

	
	
	/*
	@PostMapping("/registration")
	public String addRegistration(@RequestBody User user) throws HealthCareSystemServiceException
	{
		try
		{
			serviceInterfaceObject.addRegistration(user);
			return "New Registration";
		}
		catch(DataIntegrityViolationException ex)
		{
			throw new HealthCareSystemServiceException("ID already Exists");
		}	
	}
	
	@GetMapping("/login/{userMail}/{userPassword}")
	public ResponseEntity<String> login(@PathVariable("userMail") String userMail,@PathVariable("userPassword") String userPassword) throws HealthCareSystemServiceException
	{
		String userId=serviceInterfaceObject.loginUser(userMail, userPassword);
		return new ResponseEntity<String>(userId,HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser (@PathVariable("userId") int userId) 
	{
		if(serviceInterfaceObject.existsById(userId))
		{
			User user = serviceInterfaceObject.findById(userId);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") int userId,@RequestBody User User)
	{
	    if (serviceInterfaceObject.existsById(userId)==false)
	    {
	    	 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	    serviceInterfaceObject.updateData(User);
	    return new ResponseEntity<User>(User,HttpStatus.OK);	
	}
	
	@GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<User> getUserByEmail (@PathVariable("userMail") String userMail) 
	{
		if(serviceInterfaceObject.existsByEmail(userMail))
		{
			User user = serviceInterfaceObject.findByEmail(userMail);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}*/
}
