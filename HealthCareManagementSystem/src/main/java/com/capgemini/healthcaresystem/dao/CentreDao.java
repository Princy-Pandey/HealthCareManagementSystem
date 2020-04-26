/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A CentreDao class that provides CentreDao for Healthcare system, 
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

import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.exception.CentreException;

@Repository("centredao")
public class CentreDao implements CentreDaoInterface {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean addCentre(Centre centre) {
		// TODO Auto-generated method stub
		em.persist(centre);
		return true;
	}

	

	@Override
	public Centre getCentre(int centre_id) throws CentreException {
		// TODO Auto-generated method stub
		Centre centre=em.find(Centre.class, centre_id);
		if(centre==null) throw new CentreException("Centre Id not exist for "+ centre_id);
		return centre;
	}

	@Override
	public List<Centre> getCentre() {
		// TODO Auto-generated method stub
		TypedQuery<Centre> query=em.createQuery("from Centre", Centre.class);
		return query.getResultList();
	}

	

}
