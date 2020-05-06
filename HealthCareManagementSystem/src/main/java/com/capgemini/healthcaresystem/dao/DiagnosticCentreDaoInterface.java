package com.capgemini.healthcaresystem.dao;

import java.util.List;
import com.capgemini.healthcaresystem.entity.DiagnosticCentre;
import com.capgemini.healthcaresystem.exception.CentreException;

/***************** Interface of Diagnostic Centre ********************/

public interface DiagnosticCentreDaoInterface {

	public boolean addCentre(DiagnosticCentre diagnosticCentre);

	public boolean deleteCentre(long centreId);

	DiagnosticCentre getCentre(long centreId) throws CentreException;

	public List<DiagnosticCentre> getCentre();

	public void updateCentre(long centreId, String centreName, long centreContactNumber, String centreAddress);

	public DiagnosticCentre viewCentreById(long centreId);
}
