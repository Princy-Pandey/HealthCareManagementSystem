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
