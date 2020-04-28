package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.exception.AppointmentException;


/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a dao class that provides the methods for showing
 *                           and adding appointment 
 *          Version             1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/

@Repository
public class AppointmentDao implements AppointmentDaoInterface{
	
	@PersistenceContext
	EntityManager em;
	
	/************************************************************************************
	 * Method:                        getAppointment
     * Description:                   To fetch the appointment made by user 
	 * @param getAppointment          Appointment made
	 * @throws AppointmentException   It is raised due to appointment id does not exist
	 ************************************************************************************/


	@Override
	public Appointment getAppointment(long appointmentId) throws AppointmentException {
		// TODO Auto-generated method stub 
		Appointment appointment=em.find(Appointment.class, appointmentId);
		if(appointment==null) throw new AppointmentException("Appointment Id does not exist for "+ appointmentId);
		return appointment;
	}

	@Override
	public List<Appointment> getAppointment() {
		// TODO Auto-generated method stub
		TypedQuery<Appointment> query=em.createQuery("from Appointment", Appointment.class);
		return query.getResultList();	
	}


	@Override
	public void addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		em.persist(appointment);
		
		
	}

	
}
