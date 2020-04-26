package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.exception.CentreException;


public interface CentreDaoInterface {
	
	public void addCentre(Centre centre);
	public void deleteCentre(String centreId);
	Centre getCentre(String centreId) throws CentreException;
	public List<Centre> getCentre();
}
