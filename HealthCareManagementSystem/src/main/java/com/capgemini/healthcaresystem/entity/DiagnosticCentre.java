package com.capgemini.healthcaresystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*****************************************************************************************************************
 *          @author       -  Princy Pandey
 *          Description   -  It is a entity class that provides the entites for diagnostic centre made by admin.
 *          Version       -  1.0
 *          Created Date  -  20-APR-2020
 *****************************************************************************************************************/

@Entity()
@Table(name= "DIAGNOSTICCENTRE")
public class DiagnosticCentre
{	
	/********** Centre Id **********/
	@Id
	@Column(name= "CENTRE_ID")
	private String centreId;
    
	/********** Centre Name **********/
    @Column(name= "CENTRE_NAME",length=25)
	private String centreName;
    
    /********** Centre Contact Number **********/
    @Column(name= "CENTRE_CONTACT_NUMBER",length=11)
   	private long centreContactNumber;
    
    /********** Centre Address **********/
    @Column(name= "CENTRE_ADDRESS",length=50)
   	private String centreAddress;

    
    /********** Default Constructor **********/
	public DiagnosticCentre() {}
	
	
	/********** Parameterized Constructor **********/
	public DiagnosticCentre(String centreId, String centreName, long centreContactNumber, String centreAddress) 
	{
		super();
		this.centreId = centreId;
		this.centreName = centreName;
		this.centreContactNumber = centreContactNumber;
		this.centreAddress = centreAddress;
	}

	
    /********** Getters and Setters **********/
    public String getCentreId() 
    {
		return centreId;
	}
	public void setCentreId(String centreId) 
	{
		this.centreId = centreId;
	}

	public String getCentreName() 
	{
		return centreName;
	}
	public void setCentreName(String centreName) 
	{
		this.centreName = centreName;
	}

	public long getCentreContactNumber() 
	{
		return centreContactNumber;
	}
	public void setCentreContactNumber(long centreContactNumber) 
	{
		this.centreContactNumber = centreContactNumber;
	}

	public String getCentreAddress() 
	{
		return centreAddress;
	}
	public void setCentreAddress(String centreAddress) 
	{
		this.centreAddress = centreAddress;
	}
	
	@Override
	public String toString() 
	{
		return "Centre [centreId=" + centreId + ", centreName=" + centreName + ", centreContactNumber="
					+ centreContactNumber + ", centreAddress=" + centreAddress + "]";
	}	
}
