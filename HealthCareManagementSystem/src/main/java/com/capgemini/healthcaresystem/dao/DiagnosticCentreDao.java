/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A CentreDao class that provides CentreDao for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    20-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcaresystem.entity.DiagnosticCentre;
import com.capgemini.healthcaresystem.exception.CentreException;


/************************************************************************************
 *          @author          Princy Pandey
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
	 * Method:                        addCentre
     * Description:                   To add centre in diagnostic centre
	 * @param addCentre               Adding centre
	 * @returns Boolean               true, if centre added otherwise 
	 ************************************************************************************/

	
	@Override
	public boolean addCentre(DiagnosticCentre centre) {
		// TODO Auto-generated method stub
		em.persist(centre);
		return true;
	}

	

	/************************************************************************************
	 * Method:                        getCentre
     * Description:                   To fetch the centre made by admin 
	 * @param getCentre               Fetches all centre present 
	 * @throws CentreException        It is raised due to centre id does not exist
	 ************************************************************************************/
	
	
	@Override
	public DiagnosticCentre getCentre(int centre_id) throws CentreException {
		// TODO Auto-generated method stub
		DiagnosticCentre centre=em.find(DiagnosticCentre.class, centre_id);
		if(centre==null) throw new CentreException("Centre Id not exist for "+ centre_id);
		return centre;
	}

	@Override
	public List<DiagnosticCentre> getCentre() {
		// TODO Auto-generated method stub
		TypedQuery<DiagnosticCentre> query=em.createQuery("from Centre", DiagnosticCentre.class);
		return query.getResultList();
	}

	

}
