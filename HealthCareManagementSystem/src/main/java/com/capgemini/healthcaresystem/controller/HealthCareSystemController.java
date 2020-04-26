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
					
					System.out.println("This is test id"+test.getTestId());
					serviceinterfaceObject.addTest(test);
					
					return new ResponseEntity<>("Test Added",HttpStatus.OK);
				}
				catch(DataIntegrityViolationException ex)
				{
					throw new TestException("Id already exists");
				}
			}
	
	
	
	
	@DeleteMapping("/deleteTest/{testId}")
	public String deleteTest(@PathVariable String testId)
	{
		
		serviceinterfaceObject.deleteTest(testId);
		return "Test deleted";
	}
	
	
	
	//Centre Controller
	
	@GetMapping("/getCentre")
	public ResponseEntity<Object> getCentre()
	{
		return new ResponseEntity<>(serviceinterfaceObject.viewCentre(),HttpStatus.OK);
	}
	
	
	
	
	@PostMapping("/addCentre")
	public ResponseEntity<Object> addCentre( @RequestBody Centre centre)
	throws CentreException{
		
		try {
			serviceinterfaceObject.addCentre(centre);
			return new ResponseEntity<>("Centre Added",HttpStatus.OK);
		}
		catch(DataIntegrityViolationException ex)
		{
			throw new CentreException("Id already exists");
		}
	}
	
	
	
	
	
	@DeleteMapping("/deleteCentre/{centreId}")
	public String deleteCentre(@PathVariable("centreId") String centreId)
	{
		serviceinterfaceObject.deleteCentre(centreId);
		return "Centre deleted";
	}
	
	
}
