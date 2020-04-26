package com.capgemini.healthcaresystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.AppointmentDaoInterface;
import com.capgemini.healthcaresystem.dao.CentreDaoInterface;
import com.capgemini.healthcaresystem.dao.UserDaoInterface;
import com.capgemini.healthcaresystem.dao.TestDaoInterface;
import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.AppointmentException;
import com.capgemini.healthcaresystem.exception.CentreException;
import com.capgemini.healthcaresystem.exception.TestException;
import com.capgemini.healthcaresystem.exception.UserException;
import com.capgemini.healthcaresystem.entity.Test;


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
	
	
	
	//User
	@Autowired
	private UserDaoInterface udao;
	
	@Override
	public List<User> viewUser() throws UserException {
		// TODO Auto-generated method stub
		return udao.getUser();	
	}
	
	
	
	//Test
	@Autowired
	private TestDaoInterface tdao;
	
	
	
	@Override
	public void addTest(Test test) throws TestException {
		// TODO Auto-generated method stub
		Centre cent=cdao.getCentre(test.getCentre().getCentreId());
		Test obj=new Test(test.getTestId(),test.getTestName(),cent);
		tdao.addTest(obj);

	}

	@Override
	public void deleteTest(String testId) throws TestException{
		// TODO Auto-generated method stub
		
		
		 tdao.deleteTest(testId);
	}

	@Override
	public List<Test> viewTest() throws TestException{
		// TODO Auto-generated method stub
		return tdao.getTest();	
		
	}

	

	
	
	//Centre
	@Autowired
	private CentreDaoInterface cdao;

	@Override
	public void addCentre(Centre centre) throws CentreException{
		// TODO Auto-generated method stub
		 cdao.addCentre(centre);
		
	}

	@Override
	public void deleteCentre(String centreId) throws CentreException{
		// TODO Auto-generated method stub
		 cdao.deleteCentre(centreId);
	}

	@Override
	public List<Centre> viewCentre() throws CentreException{
		// TODO Auto-generated method stub
		return cdao.getCentre();
	}

	

}



