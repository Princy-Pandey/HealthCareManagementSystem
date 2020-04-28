package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.entity.DiagnosticCentre;
import com.capgemini.healthcaresystem.exception.CentreException;


/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a dao class that provides the methods for adding
 *                           and removing centre 
 *          Version             1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/


@Repository("centredao")
public class DiagnosticCentreDao implements DiagnosticCentreDaoInterface {
	
	@PersistenceContext
	private EntityManager em;

	
	/************************************************************************************
	 * Method:                        getCentre
     * Description:                   To fetch the centre made by admin 
	 * @param getCentre               Fetches all centre present 
	 * @throws CentreException        It is raised due to centre id does not exist
	 ************************************************************************************/
	
	
	@Override
	public DiagnosticCentre getCentre(String centreId) throws CentreException {
		// TODO Auto-generated method stub
		DiagnosticCentre diagnosticCentre=em.find(DiagnosticCentre.class, centreId);
		if(diagnosticCentre==null) throw new CentreException("Centre Id does not exist for "+ centreId);
		return diagnosticCentre;
	}

	@Override
	public List<DiagnosticCentre> getCentre() {
		// TODO Auto-generated method stub
		TypedQuery<DiagnosticCentre> query=em.createQuery("from DiagnosticCentre", DiagnosticCentre.class);
		List<DiagnosticCentre> list1=query.getResultList();
		return list1;
	}

	

}
