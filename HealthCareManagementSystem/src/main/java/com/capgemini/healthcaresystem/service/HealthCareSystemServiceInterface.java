package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.AppointmentException;
import com.capgemini.healthcaresystem.exception.CentreException;
import com.capgemini.healthcaresystem.exception.TestException;
import com.capgemini.healthcaresystem.exception.UserException;


public interface HealthCareSystemServiceInterface {
	
	//Appointment
	List<Appointment> viewAppointment() throws AppointmentException;
	
	//User
	List<User> viewUser() throws UserException;
	
	//Test
	public void addTest(Test test) throws TestException;
	public void deleteTest(String testId) throws TestException;
	List<Test> viewTest() throws TestException;
	
	
	//Centre
	public void addCentre(Centre centre) throws CentreException;
	public void deleteCentre(String centreId) throws CentreException;
	List<Centre> viewCentre() throws CentreException;

	
}
