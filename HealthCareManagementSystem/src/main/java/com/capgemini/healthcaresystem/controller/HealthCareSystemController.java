package com.capgemini.healthcaresystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;
import com.capgemini.healthcaresystem.exception.UserException;
import com.capgemini.healthcaresystem.service.HealthCareSystemServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
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
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<Boolean> delUser(@PathVariable("userId") String userId) throws UserException 
	{
		Boolean status = serviceInterfaceObject.deleteUser(userId);
		if(!status)throw new UserException("User not found.");
		
		return new ResponseEntity<Boolean>(status, HttpStatus.OK);
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
	
	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody User user) throws HealthCareSystemServiceException
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
	
	@PutMapping("/logout/{userId}")
	public ResponseEntity<String> logout(@PathVariable("id") String userId) throws UserException
	{
		serviceInterfaceObject.logout(userId);
		return new ResponseEntity<String>("Logged Out Successfully",HttpStatus.OK);
	}

	@GetMapping("/forgetPassword/{userMail}/{secretWord}")
	public ResponseEntity<String> forgetPassword(@PathVariable("userMail") String userMail,@PathVariable("secretWord") String secretWord) throws HealthCareSystemServiceException
	{
		String string = serviceInterfaceObject.changePassword(userMail, secretWord);
		return new ResponseEntity<String>(string,HttpStatus.OK);
	}
	
	@PutMapping("/updatePassword/{userMail}")
	public ResponseEntity<User> updatePassword(@PathVariable("userMail") String userMail,@RequestBody User User) throws HealthCareSystemServiceException
	{
	    if (serviceInterfaceObject.existsByMail(userMail))
	    {
	    	serviceInterfaceObject.updateData(User,userMail);
		    return new ResponseEntity<User>(User,HttpStatus.OK);
		}
   	 	return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
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
