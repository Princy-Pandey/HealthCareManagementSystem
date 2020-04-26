/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A ShowAppointmentDaoInterface class that provides ShowAppointmentDaoInterface for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.dao;

import java.util.List;

import com.capgemini.healthcaresystem.entity.ShowAppointment;
import com.capgemini.healthcaresystem.exception.AppointmentException;

public interface ShowAppointmentDaoInterface {
	ShowAppointment showAppointment(int appointment_id) throws AppointmentException;
	public List<ShowAppointment> showAppointment();


}
