package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.entity.ShowAppointment;
import com.capgemini.healthcaresystem.exception.AppointmentException;

public interface ShowAppointmentDaoInterface {
	ShowAppointment showAppointment(int appointment_id) throws AppointmentException;
	public List<ShowAppointment> showAppointment();


}
