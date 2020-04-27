/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A showAppointmentDao class that provides appointment for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.entity.ShowAppointment;
import com.capgemini.healthcaresystem.exception.AppointmentException;

@Repository
public class ShowAppointmentDao implements ShowAppointmentDaoInterface{
	
	@PersistenceContext
	EntityManager em;
	
	/************************************************************************************
	 * Method:                        showAppointment
     * Description:                   To fetch the appointment made by user 
	 * @param showAppointment          Appointment shown
	 * @throws AppointmentException   It is raised due to appointment id does not exist
	 ************************************************************************************/


	@Override
	public ShowAppointment showAppointment(int appointment_id) throws AppointmentException {
		// TODO Auto-generated method stub 
		ShowAppointment appointment=em.find(ShowAppointment.class, appointment_id);
		if(appointment==null) throw new AppointmentException("Appointment Id not exist for "+ appointment_id);
		return appointment;
	}

	@Override
	public List<ShowAppointment> showAppointment() {
		// TODO Auto-generated method stub
		TypedQuery<ShowAppointment> query=em.createQuery("from ShowAppointment", ShowAppointment.class);
		return query.getResultList();	
	}
}

