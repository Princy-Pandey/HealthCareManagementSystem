package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.exception.CentreException;


public interface CentreDaoInterface {
	
	boolean addCentre(Centre centre);
	Centre getCentre(int centre_id) throws CentreException;
	public List<Centre> getCentre();
}
