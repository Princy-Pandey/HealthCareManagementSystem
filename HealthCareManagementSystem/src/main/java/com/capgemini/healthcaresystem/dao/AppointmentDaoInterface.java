
package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.validation.Valid;

import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.exception.AppointmentException;


/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A AppointmentDaoInterface class that provides AppointmentDaoInterface for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/

public interface AppointmentDaoInterface {

	Appointment getAppointment(long appointmentId) throws AppointmentException;
	public List<Appointment> getAppointment();
	void addAppointment(Appointment appointment);

}

