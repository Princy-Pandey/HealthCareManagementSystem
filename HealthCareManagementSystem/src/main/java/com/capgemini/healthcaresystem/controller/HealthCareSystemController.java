
package com.capgemini.healthcaresystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.entity.DiagnosticCentre;
import com.capgemini.healthcaresystem.entity.ShowAppointment;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.AppointmentException;
import com.capgemini.healthcaresystem.exception.CentreException;
import com.capgemini.healthcaresystem.exception.TestException;
import com.capgemini.healthcaresystem.service.HealthCareSystemServiceInterface;

/************************************************************************************
*          @author          Kiran Rajput
*          Description      It is a controller class that process action for 
*                           adding,removing and displaying centre,test,user and
*                           appointments
*          Version          1.0
*          Created Date     22-APR-2020
************************************************************************************/



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HealthCareSystemController {

	@Autowired
	private HealthCareSystemServiceInterface serviceinterfaceObject;
	
	
	/************************************************************************************
	 * Method:                       getAppointment
     * Description:                  To get appointment made by user
	 * @param getAppointment         Display appointment details
	 * @mapping GetMapping           Make HTTP request to get all appointments 
	************************************************************************************/

	//Appointment Controller
	@GetMapping("/getAppointment")
	public List<Appointment> getAppointment() throws AppointmentException
	{
		return serviceinterfaceObject.viewAppointment();
	}
	
	/************************************************************************************
	 * Method: addAppointment
     * Description: to add appointment to the healthcare system
	
	 * @param amt                           - to make an appointment 
	 * @returns Boolean                     - true, if transferred otherwise throws TestException
	 * @throws TestException                - It is raised when the appointment id is already present in the database
     * Created By                           - kiran Rajput
     * Created Date                         - 26-APR-2020                           
	 
	 ************************************************************************************/
	
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
	/************************************************************************************
	 * Method:                       getTest
     * Description:                  To get details of test present in centre
	 * @param getTest                Display test details
	 * @mapping GetMapping           Make HTTP request to get all test 
	************************************************************************************/
	
	@GetMapping("/getTest")
	public List<Test> getTest() throws TestException
	{
		return serviceinterfaceObject.viewTest();
	}
	
	
	
	//Centre Controller
	/************************************************************************************
	 * Method:                       getCentre
     * Description:                  To get details of  centre
	 * @param getCentre              Display centre details
	 * @mapping GetMapping           Make HTTP request to get all centre 
	************************************************************************************/
	
	@GetMapping("/getCentre")
	public List<DiagnosticCentre> getCentre() throws CentreException
	{
		return serviceinterfaceObject.viewCentre();
	}
	
	
	
	
	// Show Appointment

	/************************************************************************************
	 * Method:                       showAppointment
     * Description:                  To show appointment status
	 * @param showAppointment        Display appointment details
	 * @mapping GetMapping           Make HTTP request to get all appointments 
	************************************************************************************/
	
	@GetMapping("/showAppointment")
	public List<ShowAppointment> showAppointment() throws AppointmentException
	{
		return serviceinterfaceObject.showAppointment();
	}
	
}
