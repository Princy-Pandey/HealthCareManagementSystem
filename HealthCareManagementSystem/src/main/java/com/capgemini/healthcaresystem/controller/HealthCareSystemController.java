package com.capgemini.healthcaresystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HealthCareSystemController 
{
	@Autowired
	private HealthCareSystemServiceInterface serviceInterfaceObject;
	
	@PostMapping("/registration")
	public String addRegistration(@Valid @RequestBody User user, BindingResult br) throws HealthCareSystemServiceException
	{
		String err="";
		if(br.hasErrors())
		{
			List<FieldError> errors = br.getFieldErrors();
			for(FieldError error:errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new HealthCareSystemServiceException(err);
		}
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
	public ResponseEntity<Integer> login(@PathVariable("userMail") String userMail,@PathVariable("userPassword") String userPassword) throws HealthCareSystemServiceException
	{
		Integer userId=serviceInterfaceObject.loginUser(userMail, userPassword);
		return new ResponseEntity<Integer>(userId,HttpStatus.OK);
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
	}
}
