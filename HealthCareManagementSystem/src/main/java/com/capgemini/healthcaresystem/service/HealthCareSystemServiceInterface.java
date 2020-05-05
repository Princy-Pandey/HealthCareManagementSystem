package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.entity.DiagnosticCentre;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.AppointmentException;
import com.capgemini.healthcaresystem.exception.CentreException;
import com.capgemini.healthcaresystem.exception.TestException;
import com.capgemini.healthcaresystem.exception.UserException;


/**********************Service Interface******************************/

public interface HealthCareSystemServiceInterface {
	
	//Appointment
	List<Appointment> viewAppointment() throws AppointmentException;
	
	//User
	List<User> viewUser() throws UserException;
	
	//Test
	public boolean addTest(Test test) throws TestException;
	public boolean deleteTest(long testId) ;
	List<Test> viewTest() throws TestException;
	public Test viewTestById(long testId);
	
	
	//Centre
	public boolean addCentre(DiagnosticCentre diagnosticCentre) throws CentreException;
	public boolean deleteCentre(long centreId) throws CentreException;
	List<DiagnosticCentre> viewCentre() throws CentreException;
	public void updateCentre(long centreId,String centreName, long centreContactNumber, String centreAddress);
	public DiagnosticCentre viewCentreById(long centreId);

	
}
