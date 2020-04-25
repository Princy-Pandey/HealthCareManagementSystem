package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.exception.CentreException;


public interface CentreDaoInterface {
	
	public void addCentre(Centre centre);
	public void deleteCentre(int centre_id);
	Centre getCentre(int centre_id) throws CentreException;
	public List<Centre> getCentre();
}
