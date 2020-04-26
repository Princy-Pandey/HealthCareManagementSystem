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

