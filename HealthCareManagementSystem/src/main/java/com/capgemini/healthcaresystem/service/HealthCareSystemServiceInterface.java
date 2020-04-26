package com.capgemini.healthcaresystem.service;

import java.util.List;

import javax.validation.Valid;

import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.entity.ShowAppointment;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.AppointmentException;
import com.capgemini.healthcaresystem.exception.CentreException;
import com.capgemini.healthcaresystem.exception.TestException;


public interface HealthCareSystemServiceInterface {
	
	//Appointment
	public void addAppointment( Appointment appointment) throws TestException;
	List<Appointment> viewAppointment() throws AppointmentException;
	
	
	//Test
	List<Test> viewTest() throws TestException;
	
	
	//Centre
	List<Centre> viewCentre() throws CentreException;
	
	List<ShowAppointment> showAppointment() throws AppointmentException;
	
	


	
}
