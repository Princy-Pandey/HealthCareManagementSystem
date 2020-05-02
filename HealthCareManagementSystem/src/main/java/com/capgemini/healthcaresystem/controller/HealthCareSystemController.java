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
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<Boolean> delUser(@PathVariable("userId") String userId) throws UserException 
	{
		Boolean status = serviceInterfaceObject.deleteUser(userId);
		if(!status)throw new UserException("User not found.");
		
		return new ResponseEntity<Boolean>(status, HttpStatus.OK);
	}
	
	@PutMapping("/logout/{userId}")
	public ResponseEntity<String> logout(@PathVariable("userId") String userId) throws UserException
	{
		serviceInterfaceObject.logout(userId);
		return new ResponseEntity<String>("Logged Out Successfully",HttpStatus.OK);
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

	@GetMapping("/viewUsers")
	public ResponseEntity<Object> getUser()
	{
		return new ResponseEntity<>(serviceInterfaceObject.viewUser(),HttpStatus.OK);
	}
	
	@GetMapping("/login/{userMail}/{userPassword}")
	public int validateLogin(@PathVariable String userMail, @PathVariable String userPassword)
	{
		return serviceInterfaceObject.validateLogin(userMail, userPassword);
	}
	
	@GetMapping("/verifyUser/{userMail}/{secretWord}")
	public int verifyUser(@PathVariable("userMail") String userMail,@PathVariable("secretWord") String secretWord) throws HealthCareSystemServiceException
	{
		return serviceInterfaceObject.verifyUserSecretWord(userMail, secretWord); 
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
}
