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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.CentreException;
import com.capgemini.healthcaresystem.exception.TestException;
import com.capgemini.healthcaresystem.service.HealthCareSystemServiceInterface;




//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HealthCareSystemController {

	@Autowired
	private HealthCareSystemServiceInterface serviceinterfaceObject;
	
	
	//Appointment Controller
	@GetMapping("/getAppointment")
	public ResponseEntity<Object> getAppointment()
	{
		return new ResponseEntity<>(serviceinterfaceObject.viewAppointment(),HttpStatus.OK);
	}
	
	
	
	//User Controller
	@GetMapping("/getUser")
	public ResponseEntity<Object> getUser()
	{
		return new ResponseEntity<>(serviceinterfaceObject.viewUser(),HttpStatus.OK);
	}
	
	
	
	//Test Controller
	@GetMapping("/getTest")
	public ResponseEntity<Object> getTest()
	{
		return new ResponseEntity<>(serviceinterfaceObject.viewTest(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addTest")
	public ResponseEntity<Object> addTest(@RequestBody Test test)
			throws TestException{
				
				try {
					//test.setCentre(centre);
					System.out.println("This is test id"+test.getTest_id());
					serviceinterfaceObject.addTest(test);
					
					return new ResponseEntity<>("Test Added",HttpStatus.OK);
				}
				catch(DataIntegrityViolationException ex)
				{
					throw new TestException("Id already exists");
				}
			}
	
	
	
	
	@DeleteMapping("/deleteTest/{test_id}")
	public String deleteTest(@PathVariable int test_id)
	{
		//test.getCentre();
		serviceinterfaceObject.deleteTest(test_id);
		return "Test deleted";
	}
	
	
	
	//Centre Controller
	
	@GetMapping("/getCentre")
	public ResponseEntity<Object> getCentre()
	{
		return new ResponseEntity<>(serviceinterfaceObject.viewCentre(),HttpStatus.OK);
	}
	
	
	
	//
	@PostMapping("/addCentre")
	public ResponseEntity<Object> addCentre(@Valid @RequestBody Centre centre, BindingResult br)
	throws CentreException{
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors=br.getFieldErrors();
			for(FieldError error:errors)
				err+=error.getDefaultMessage()+"<br/>";
			throw new CentreException(err);
		}
		try {
			serviceinterfaceObject.addCentre(centre);
			return new ResponseEntity<>("Centre Added",HttpStatus.OK);
		}
		catch(DataIntegrityViolationException ex)
		{
			throw new CentreException("Id already exists");
		}
	}
	
	
	
	
	
	@DeleteMapping("/deleteCentre/{centre_id}")
	public String deleteCentre(@PathVariable("centre_id") int centre_id)
	{
		//centre.setCentre_id(centre_id);
		serviceinterfaceObject.deleteCentre(centre_id);
		return "Centre deleted";
	}
	
	
}
