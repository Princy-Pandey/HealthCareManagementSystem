package com.capgemini.healthcaresystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.entity.Login;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.HealthCareSystemServiceException;
import com.capgemini.healthcaresystem.exception.ResourceNotFoundException;
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
	
	 //Happy path, an employee is returned as response
		@RequestMapping(value = "/employee", method = RequestMethod.GET)
		public Login getEmpl() throws ResourceNotFoundException, HealthCareSystemServiceException {
			try
			{
				Login login = serviceInterfaceObject.getLogin();
				if (login == null) 
				{
					throw new ResourceNotFoundException("Login not found");
				}
				return login;
			} 
			catch (HealthCareSystemServiceException e) 
			{
				throw new HealthCareSystemServiceException("Internal Server Exception while getting exception");
			}
		}

	    //no employee found so ResourceNotFoundException is thrown
		@RequestMapping(value = "/employee2", method = RequestMethod.GET)
		public Login getEmp2() throws ResourceNotFoundException, HealthCareSystemServiceException {
			try 
			{
				Login login = serviceInterfaceObject.getLoginNull();
				if (login == null) 
				{
					throw new ResourceNotFoundException("Login not found");
				}
				return login;
			} 
			catch (HealthCareSystemServiceException e) 
			{
				throw new HealthCareSystemServiceException("Internal Server Exception while getting exception");
			}
		}

	    //Some exception is thrown by service layer
		@RequestMapping(value = "/employee3", method = RequestMethod.GET)
		public Login getEmp3() throws ResourceNotFoundException, HealthCareSystemServiceException {
			try 
			{
				Login login = serviceInterfaceObject.getLoginException();
				if (login == null) 
				{
					throw new ResourceNotFoundException("Login not found");
				}
				return login;
			} 
			catch (HealthCareSystemServiceException e) 
			{
				throw new HealthCareSystemServiceException("Internal Server Exception while getting exception");
			}
		}
}
