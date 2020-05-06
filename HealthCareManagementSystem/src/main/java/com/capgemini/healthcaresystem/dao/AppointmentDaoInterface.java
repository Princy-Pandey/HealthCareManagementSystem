package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.exception.AppointmentException;

/***************** Interface of Appointment ********************/

public interface AppointmentDaoInterface {

	Appointment getAppointment(long appointmentId) throws AppointmentException;

	public List<Appointment> getAppointment();

}
