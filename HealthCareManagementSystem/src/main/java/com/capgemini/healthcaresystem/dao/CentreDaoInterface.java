/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A CentreDaoInterface class that provides CentreDaoInterface for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.Centre;
import com.capgemini.healthcaresystem.exception.CentreException;


public interface CentreDaoInterface {
	
	boolean addCentre(Centre centre);
	Centre getCentre(int centre_id) throws CentreException;
	public List<Centre> getCentre();
}
