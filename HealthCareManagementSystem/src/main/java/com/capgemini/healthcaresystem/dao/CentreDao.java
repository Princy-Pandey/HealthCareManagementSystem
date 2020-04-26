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
	public void addCentre(Centre centre) {
		// TODO Auto-generated method stub
		em.persist(centre);
		
	}

	@Override
	public void deleteCentre(String centreId) {
		// TODO Auto-generated method stub
		Centre obj=em.find(Centre.class, centreId);
				em.remove(obj);
		
	}

	@Override
	public Centre getCentre(String centreId) throws CentreException {
		// TODO Auto-generated method stub
		Centre centre=em.find(Centre.class, centreId);
		if(centre==null) throw new CentreException("Centre Id does not exist for "+ centreId);
		return centre;
	}

	@Override
	public List<Centre> getCentre() {
		// TODO Auto-generated method stub
		TypedQuery<Centre> query=em.createQuery("from Centre", Centre.class);
		List<Centre> list1=query.getResultList();
		return list1;
	}

	

}
