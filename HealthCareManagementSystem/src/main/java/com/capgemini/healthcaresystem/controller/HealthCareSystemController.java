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

import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.entity.ShowAppointment;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.AppointmentException;
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
	public List<Appointment> getAppointment() throws AppointmentException
	{
		return serviceinterfaceObject.viewAppointment();
	}
	
	
	
	@PostMapping("/addAppointment")
	public ResponseEntity<Object> addAppointment( @RequestBody Appointment appointment) throws TestException
	{
		
		try {
        serviceinterfaceObject.addAppointment(appointment);
		return new ResponseEntity<>("Appointment Added",HttpStatus.OK);
		}catch(DataIntegrityViolationException ex)
		{
			throw new TestException("Id already exists");
		}
		
	}
	
	
	
	//Test Controller
	
	@GetMapping("/getTest")
	public List<Test> getTest() throws TestException
	{
		return serviceinterfaceObject.viewTest();
	}
	
	
	
	//Centre Controller
	
	@GetMapping("/getCentre")
	public List<Centre> getCentre() throws CentreException
	{
		return serviceinterfaceObject.viewCentre();
	}
	
	// Show Appointment
	
	@GetMapping("/showAppointment")
	public List<ShowAppointment> showAppointment() throws AppointmentException
	{
		return serviceinterfaceObject.showAppointment();
	}
	
}
