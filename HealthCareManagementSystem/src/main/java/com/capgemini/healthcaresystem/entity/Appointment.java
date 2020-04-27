package com.capgemini.healthcaresystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/************************************************************************************
 *          @author       -  Kiran Rajput
 *          Description   -  It is a entity class that provides the entites for appointment made by user .
 *          Version       -  1.0
 *          Created Date  -  20-APR-2020
 ************************************************************************************/

@Entity
@Table(name= "APPOINTMENT")
public class Appointment 
{	
	/********** Appointment Id **********/
	@Id
	@Column(name= "APPOINTMENT_ID",length=10)
	private long appointmentId;
	
    /********** User Id **********/
	@ManyToOne()
	@JoinColumn(name= "USER_ID", referencedColumnName ="USER_ID")
	private User userId;
    
    /********** Test Id **********/ 
	@ManyToOne()
	@JoinColumn(name= "TEST_ID", referencedColumnName ="TEST_ID")
	private Test testId;
	
    /********** Centre Id **********/ 
	@ManyToOne()
	@JoinColumn(name= "CENTRE_ID", referencedColumnName ="CENTRE_ID")
	private DiagnosticCentre centreId;
    
    
	/********** Appointment Date **********/
	@Column(name= "APPOINTMENT_DATE")
	private String appointmentDate;
	
    /********** Appointment Time **********/
	@Column(name= "APPOINTMENT_TIME")
	private String appointmentTime;
	
    /********** Appointment Approval Status **********/
	@Column(name= "APPROVAL_STATUS")
	private boolean approvalStatus;
	
	
	/********** Default Constructor **********/
	public Appointment() {}
	
	
	/********** Parameterized Constructor **********/
	public Appointment(long appointmentId, User userId, Test testId, DiagnosticCentre centreId, 
			String appointmentDate, String appointmentTime, boolean approvalStatus) 
	{
		super();
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.testId = testId;
		this.centreId = centreId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.approvalStatus = approvalStatus;
	}
	
	
	/********** Getters and Setters **********/
	public long getAppointmentId() 
	{
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) 
	{
		this.appointmentId = appointmentId;
	}

	public User getUserId() 
	{
		return userId;
	}
	public void setUserId(User userId) 
	{
		this.userId = userId;
	}

	public Test getTestId() 
	{
		return testId;
	}
	public void setTestId(Test testId) 
	{
		this.testId = testId;
	}

	public DiagnosticCentre getCentreId() 
	{
		return centreId;
	}
	public void setCentreId(DiagnosticCentre centreId) 
	{
		this.centreId = centreId;
	}

	public String getAppointmentTime() 
	{
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) 
	{
		this.appointmentTime = appointmentTime;
	}

	public boolean isApprovalStatus() 
	{
		return approvalStatus;
	}
	public void setApprovalStatus(boolean approvalStatus) 
	{
		this.approvalStatus = approvalStatus;
	}

	@Override
	public String toString() 
	{
		return "Appointment [appointmentId=" + appointmentId + ", userId=" + userId + ", testId=" + testId
				+ ", centreId=" + centreId + ", appointmentDate=" + appointmentDate + ", appointmentTime="
				+ appointmentTime + ", approvalStatus=" + approvalStatus + "]";
	}
}