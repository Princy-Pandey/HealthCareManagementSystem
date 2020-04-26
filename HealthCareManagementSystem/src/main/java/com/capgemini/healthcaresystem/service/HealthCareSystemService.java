package com.capgemini.healthcaresystem.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.AppointmentDaoInterface;
import com.capgemini.healthcaresystem.dao.CentreDaoInterface;
import com.capgemini.healthcaresystem.dao.ShowAppointmentDaoInterface;
import com.capgemini.healthcaresystem.dao.TestDaoInterface;
import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.entity.ShowAppointment;
import com.capgemini.healthcaresystem.entity.Test;
import com.capgemini.healthcaresystem.exception.AppointmentException;
import com.capgemini.healthcaresystem.exception.CentreException;
import com.capgemini.healthcaresystem.exception.TestException;


@Transactional
@Service
public class HealthCareSystemService implements HealthCareSystemServiceInterface{
	
	//Appointment
	@Autowired
	private AppointmentDaoInterface adao;
	
	@Override
	public List<Appointment> viewAppointment() throws AppointmentException {
		// TODO Auto-generated method stub
		return adao.getAppointment();	
	}
	
	
	

	
	
	
	//Test
	@Autowired
	private TestDaoInterface tdao;

	
	@Override
	public List<Test> viewTest() throws TestException{
		// TODO Auto-generated method stub
		return tdao.getTest();	
		
	}

	

	
	
	//Centre
	@Autowired
	private CentreDaoInterface cdao;

	
	
	@Override
	public List<Centre> viewCentre() throws CentreException{
		// TODO Auto-generated method stub
		return cdao.getCentre();
	}


	@Override
	public void addAppointment( Appointment appointment) throws TestException{
		// TODO Auto-generated method stub
		Test tobj=tdao.getTest(appointment.getTest().getTest_id());
		Appointment obj=new Appointment(appointment.getAppointment_id(),appointment.getAppointment_date(),appointment.getAppointment_time(),tobj);
		adao.addAppointment(obj);
	}

    //Show Appointment
	@Autowired
	private ShowAppointmentDaoInterface sdao;
	
	
	@Override
	public List<ShowAppointment> showAppointment() throws AppointmentException {
		// TODO Auto-generated method stub
		return sdao.showAppointment();
	}

	

}


