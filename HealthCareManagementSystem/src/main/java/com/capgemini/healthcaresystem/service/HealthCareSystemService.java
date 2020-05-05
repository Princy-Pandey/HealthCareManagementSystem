package com.capgemini.healthcaresystem.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.healthcaresystem.dao.AppointmentDaoInterface;
import com.capgemini.healthcaresystem.dao.DiagnosticCentreDaoInterface;
import com.capgemini.healthcaresystem.dao.UserDaoInterface;
import com.capgemini.healthcaresystem.dao.TestDaoInterface;
import com.capgemini.healthcaresystem.entity.Appointment;
import com.capgemini.healthcaresystem.entity.DiagnosticCentre;
import com.capgemini.healthcaresystem.entity.User;
import com.capgemini.healthcaresystem.exception.AppointmentException;
import com.capgemini.healthcaresystem.exception.CentreException;
import com.capgemini.healthcaresystem.exception.TestException;
import com.capgemini.healthcaresystem.exception.UserException;
import com.capgemini.healthcaresystem.entity.Test;


/************************************************************************************
*          @author          Princy Pandey
*          Description      It is a service class that provides the services for 
*                           adding,removing and displaying centre,test,user and
*                           appointments
*          Version          1.0
*          Created Date     20-APR-2020
************************************************************************************/


@Transactional
@Service
public class HealthCareSystemService implements HealthCareSystemServiceInterface{
	
	
	
	/************************************************************************************
	 * Method:                        viewAppointment
     * Description:                   To view appointment made by user
	 * @param viewAppointment         Display appointment details
	 * @throws AppointmentException   It is raised due to appointment id not present
	************************************************************************************/
	
	@Autowired
	private AppointmentDaoInterface adao;
	
	@Override
	public List<Appointment> viewAppointment() throws AppointmentException {
		// TODO Auto-generated method stub
		return adao.getAppointment();	
	}
	
	
	
	
	/************************************************************************************
	 * Method:                        viewUser
     * Description:                   To view user registered
	 * @param viewUser                Display user's details
	 * @throws UserException          It is raised due to user id not present
	************************************************************************************/
	
	@Autowired
	private UserDaoInterface udao;
	
	@Override
	public List<User> viewUser() throws UserException {
		// TODO Auto-generated method stub
		return udao.getUser();	
	}
	
	
	
	/************************************************************************************
	 * Method:                        Test
     * Description:                   To add,remove and display test
	 * @param addTest                 Adding test into a particular centre
	 * @param deleteTest              Deleting test into a particular centre
	 * @param viewTest                Display all test present
	 * @throws TestException          It is raised due to test id not present
	************************************************************************************/
	
	@Autowired
	private TestDaoInterface tdao;
	
	@Override
	public boolean addTest(Test test) throws TestException {
		// TODO Auto-generated method stub
		DiagnosticCentre cent=cdao.getCentre(test.getCentre().getCentreId());
		Test obj=new Test(test.getTestName(),cent);
		
		if(tdao.addTest(obj))
			return true;
		else
			throw new TestException("Cannot add test, check id");
	}

	@Override
	public boolean deleteTest(long testId) throws TestException {
		// TODO Auto-generated method stub
		if(tdao.deleteTest(testId))
			return true;
		else
			throw new CentreException("Cannot delete Test, check id");
			
	
	}

	@Override
	public List<Test> viewTest() throws TestException{
		// TODO Auto-generated method stub
		return tdao.getTest();	
		
	}
	
	@Override
	public Test viewTestById(long testId) {
		// TODO Auto-generated method stub
		Test test=tdao.viewTestById(testId);
		return test;
	}

	

	
	/************************************************************************************
	 * Method:                        Centre
     * Description:                   To add,remove and display centre
	 * @param addCentre               Adding centre
	 * @param deleteCentre            Deleting centre
	 * @param viewCentre              Display all centre present
	 * @param updateCentre            Update centre present
	 * @throws CentreException        It is raised due to centre id not present
	************************************************************************************/
	
	@Autowired
	private DiagnosticCentreDaoInterface cdao;

	@Override
	public boolean addCentre(DiagnosticCentre diagnosticCentre) throws CentreException{
		// TODO Auto-generated method stub
		if(cdao.addCentre(diagnosticCentre))
		{
		 return true;
		}
		else
			throw new CentreException("Cannot add Centre, check id");
	}

	@Override
	public boolean deleteCentre(long centreId) throws CentreException{
		// TODO Auto-generated method stub
		 if(cdao.deleteCentre(centreId))
		 {
			 return true;
		 }
		 else
				throw new CentreException("Cannot delete Centre, check id");
	}
	
	@Override
	public void updateCentre(long centreId, String centreName, long centreContactNumber, String centreAddress) {
		// TODO Auto-generated method stub
		cdao.updateCentre(centreId, centreName, centreContactNumber, centreAddress);
		
	}

	

	@Override
	public List<DiagnosticCentre> viewCentre() throws CentreException{
		// TODO Auto-generated method stub
		return cdao.getCentre();
	}

	

	@Override
	public DiagnosticCentre viewCentreById(long centreId) {
		// TODO Auto-generated method stub
		DiagnosticCentre diagnosticCentre=cdao.viewCentreById(centreId);
		return diagnosticCentre;
	}

	
}



