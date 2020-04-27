/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A CentreDaoInterface class that provides CentreDaoInterface for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    20-APR-2020
 ************************************************************************************/
package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.DiagnosticCentre;
import com.capgemini.healthcaresystem.exception.CentreException;


public interface DiagnosticCentreDaoInterface {
	
	public boolean addCentre(DiagnosticCentre diagnosticCentre);
	DiagnosticCentre getCentre(String centreId) throws CentreException;
	public List<DiagnosticCentre> getCentre();
}

