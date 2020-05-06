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
import com.capgemini.healthcaresystem.entity.DiagnosticCentre;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.CentreException;
import com.capgemini.healthcaresystem.exception.TestException;
import com.capgemini.healthcaresystem.service.HealthCareSystemServiceInterface;

/************************************************************************************
 * @author Princy Pandey Description It is a controller class that process
 *         action for adding,removing and displaying centre,test,user and
 *         appointments 
 * Version 1.0 
 * Created Date 22-APR-2020
 ************************************************************************************/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HealthCareSystemController {

	@Autowired
	private HealthCareSystemServiceInterface service;

	/************************************************************************************
	 * Method: getAppointment Description: To get appointment made by user
	 * 
	 * @param getAppointment Display appointment details
	 * @mapping GetMapping Make HTTP request to get all appointments
	 ************************************************************************************/

	@GetMapping("/getAppointment")
	public ResponseEntity<Object> getAppointment() {
		return new ResponseEntity<>(service.viewAppointment(), HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getUser Description: To get details of user present
	 * 
	 * @param getUser Display user details
	 * @mapping GetMapping Make HTTP request to get all user
	 ************************************************************************************/

	@GetMapping("/getUser")
	public ResponseEntity<Object> getUser() {
		return new ResponseEntity<>(service.viewUser(), HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getTest Description: To get details of test present in centre
	 * 
	 * @param getTest Display test details
	 * @mapping GetMapping Make HTTP request to get all test
	 ************************************************************************************/

	@GetMapping("/getTest")
	public ResponseEntity<Object> getTest() {
		return new ResponseEntity<>(service.viewTest(), HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: addTest Description: To add details of test present in centre
	 * 
	 * @param addTest Add test details
	 * @mapping PostMapping Make HTTP request to post onto test
	 * @throws TestException It is raised due to test id not present
	 ************************************************************************************/

	@PostMapping("/addTest")
	public ResponseEntity<Object> addTest(@RequestBody Test test) throws TestException {

		try {

			service.addTest(test);
			return new ResponseEntity<>("Test Added", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new TestException("Test Id already exists");
		}
	}

	/************************************************************************************
	 * Method: deleteTest Description: To delete details of test present in centre
	 * 
	 * @param deleteTest Delete test details
	 * @mapping @DeleteMapping Make HTTP request to delete test by test id
	 * @throws TestException It is raised due to test id not present
	 ************************************************************************************/

	@DeleteMapping("/deleteTest/{testId}")
	public ResponseEntity<Object> deleteTest(@PathVariable long testId) throws TestException {
		try {
			service.deleteTest(testId);
			return new ResponseEntity<>("Test Deleted", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new TestException("Can't delete test");
		}
	}

	@GetMapping("/viewtestbyid/{testId}")
	public ResponseEntity<Object> viewTestById(@PathVariable("testId") long testId) {
		Test test = service.viewTestById(testId);
		return new ResponseEntity<Object>(test, HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: getCentre Description: To get details of centre
	 * 
	 * @param getCentre Display centre details
	 * @mapping GetMapping Make HTTP request to get all centre
	 ************************************************************************************/

	@GetMapping("/getCentre")
	public ResponseEntity<Object> getCentre() {
		return new ResponseEntity<>(service.viewCentre(), HttpStatus.OK);
	}

	/************************************************************************************
	 * Method: addCentre Description: To add details of centre
	 * 
	 * @param addCentre Add centre details
	 * @mapping PostMapping Make HTTP request to post onto centre
	 * @throws CentreException It is raised due to centre id not present
	 ************************************************************************************/

	@PostMapping("/addCentre")
	public ResponseEntity<Object> addCentre(@RequestBody DiagnosticCentre diagnosticCentre) throws CentreException {

		try {
			service.addCentre(diagnosticCentre);
			return new ResponseEntity<>("Centre Added", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new CentreException("Centre Id already exists");
		}
	}

	/************************************************************************************
	 * Method: deleteCentre Description: To delete details of centre
	 * 
	 * @param deleteCentre Delete centre details
	 * @mapping @DeleteMapping Make HTTP request to delete centre by centre id
	 * @throws CentreException It is raised due to centre id not present
	 ************************************************************************************/

	@DeleteMapping("/deleteCentre/{centreId}")
	public ResponseEntity<Object> deleteCentre(@PathVariable("centreId") long centreId) throws CentreException {
		try {
			service.deleteCentre(centreId);
			return new ResponseEntity<>("Centre Deleted", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new CentreException("Can't delete centre");
		}

	}

	/************************************************************************************
	 * Method: updateCentre Description: To update details of centre
	 * 
	 * @param updateCentre Update centre details
	 * @mapping @DeleteMapping Make HTTP request to update centre by centre id
	 * @throws CentreException It is raised due to centre id not present
	 ************************************************************************************/

	@PutMapping("/updateCentre/{centreId}")
	public ResponseEntity<Object> updateCentre(@PathVariable("centreId") int centreId,
			@RequestBody DiagnosticCentre diagnosticCentre) throws CentreException {
		try {
			service.updateCentre(centreId, diagnosticCentre.getCentreName(), diagnosticCentre.getCentreContactNumber(),
					diagnosticCentre.getCentreAddress());
			return new ResponseEntity<>("Centre Updated", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new CentreException("Can't update centre");
		}
	}

	/************************************************************************************
	 * Method: viewCentreById Description: To get details of centre by id
	 * 
	 * @param viewCentreById Display centre details by id
	 * @mapping GetMapping Make HTTP request to get all centre
	 ************************************************************************************/

	@GetMapping("/viewcentrebyid/{centreId}")
	public ResponseEntity<Object> viewCentreById(@PathVariable("centreId") long centreId) {
		DiagnosticCentre diagnosticCentre = service.viewCentreById(centreId);
		return new ResponseEntity<Object>(diagnosticCentre, HttpStatus.OK);
	}

}
