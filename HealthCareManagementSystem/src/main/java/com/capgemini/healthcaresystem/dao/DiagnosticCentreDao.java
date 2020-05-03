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
	public boolean addCentre(DiagnosticCentre diagnosticCentre) {
		// TODO Auto-generated method stub
		em.persist(diagnosticCentre);
		return true;
		
	}

	
	/************************************************************************************
	 * Method:                        deleteCentre
     * Description:                   To delete centre in diagnostic centre
	 * @param deleteCentre            Deleting centre
	 * @returns Boolean               true, if centre deleted otherwise 
	 ************************************************************************************/
	
	@Override
	public boolean deleteCentre(long centreId) {
		// TODO Auto-generated method stub
		DiagnosticCentre obj=em.find(DiagnosticCentre.class, centreId);
				em.remove(obj);
				return true;
		
	}
	
	
	/************************************************************************************
	 * Method:                        updateCentre
     * Description:                   To update centre in diagnostic centre
	 * @param updateCentre            Update centre
	 
	 ************************************************************************************/
	
	@Override
	public void updateCentre(long centreId, String centreName, long centreContactNumber, String centreAddress) {
		// TODO Auto-generated method stub
		DiagnosticCentre obj=em.find(DiagnosticCentre.class, centreId);
		obj.setCentreId(centreId);
		obj.setCentreName(centreName);
		obj.setCentreContactNumber(centreContactNumber);
		obj.setCentreAddress(centreAddress);
		
	}

	
	
	/************************************************************************************
	 * Method:                        getCentre
     * Description:                   To fetch the centre made by admin 
	 * @param getCentre               Fetches all centre present 
	 * @throws CentreException        It is raised due to centre id does not exist
	 ************************************************************************************/
	
	
	@Override
	public DiagnosticCentre getCentre(long centreId) throws CentreException {
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
