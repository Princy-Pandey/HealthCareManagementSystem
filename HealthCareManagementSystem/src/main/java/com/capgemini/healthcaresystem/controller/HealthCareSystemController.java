package com.capgemini.healthcaresystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/viewUsers")
	public ResponseEntity<Object> getUser()
	{
		return new ResponseEntity<>(serviceInterfaceObject.viewUser(),HttpStatus.OK);
	}

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
	public ResponseEntity<User> login(@PathVariable("userMail") String userMail,@PathVariable("userPassword") String userPassword) throws HealthCareSystemServiceException
	{
		User user = serviceInterfaceObject.loginUser(userMail, userPassword);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@GetMapping("/forgetPassword/{userMail}/{secretWord}")
	public ResponseEntity<String> forgetPassword(@PathVariable("userMail") String userMail,@PathVariable("secretWord") String secretWord) throws HealthCareSystemServiceException
	{
		String string = serviceInterfaceObject.changePassword(userMail, secretWord);
		return new ResponseEntity<String>(string,HttpStatus.OK);
	}
	
	
	/*
	@GetMapping("/viewLogin")
	public ResponseEntity<Object> getLogin()
	{
		return new ResponseEntity<>(serviceInterfaceObject.viewLogin(),HttpStatus.OK);
	}
	
	@PostMapping("/Login")
	public ResponseEntity<Object> addLogin(@RequestBody Login login) throws HealthCareSystemServiceException
	{	
		try 
		{
			serviceInterfaceObject.addLogin(login);
			return new ResponseEntity<>("User Logged In",HttpStatus.OK);
		}
		catch(DataIntegrityViolationException ex)
		{
			throw new HealthCareSystemServiceException("Id doesn't exists");
		}
	}
	*/
}
