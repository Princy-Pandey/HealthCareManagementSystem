/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A AppointmentDaoInterface class that provides AppointmentDaoInterface for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.validation.Valid;

import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.exception.AppointmentException;

public interface AppointmentDaoInterface {
	
	void addAppointment(Appointment appointment);

	Appointment getAppointment(int appointment_id) throws AppointmentException;
	public List<Appointment> getAppointment();

}
