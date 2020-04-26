package com.capgemini.healthcaresystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "SHOWAPPOINTMENT")
public class ShowAppointment {
	
	
	//Appointment Id 
    
	@Id
	@Column(name= "APPOINTMENT_ID")
	private int appointment_id;
	
    //User Id 
	@ManyToOne()
	@JoinColumn(name= "USER_ID", referencedColumnName ="USER_ID")
	
	private User user_id;
    
    //Test Id 
	@ManyToOne()
	@JoinColumn(name= "TEST_ID", referencedColumnName ="TEST_ID")
	
	private Test test_id;
	
    //Centre Id 
	@ManyToOne()
	@JoinColumn(name= "CENTRE_ID", referencedColumnName ="CENTRE_ID")
	
	private Centre centre_id;
    
    
	//Appointment Date
    
	@Column(name= "APPOINTMENT_DATE")
	private String appointment_date;
	
    //Appointment Time
    
	@Column(name= "APPOINTMENT_TIME")
	private String appointment_time;
	
    //Appointment Approval Status
    
	@Column(name= "APPROVAL_STATUS")
	private String approval_status;
    
    
    //Getters and Setters
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public Test getTest_id() {
		return test_id;
	}
	public void setTest_id(Test test_id) {
		this.test_id = test_id;
	}

	public Centre getCentre_id() {
		return centre_id;
	}
	public void setCentre_id(Centre centre_id) {
		this.centre_id = centre_id;
	}

	public String getAppointment_time() {
		return appointment_time;
	}
	public void setAppointment_time(String appointment_time) {
		this.appointment_time = appointment_time;
	}

	public String getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}
	
	//Default Constructor
	public ShowAppointment() {}
	
	
	//Parameterized Constructor
	public ShowAppointment(int appointment_id,User user_id,Test test_id,Centre centre_id,String appointment_date,String appointment_time,String approval_status) 
	{
		super();
		this.appointment_id = appointment_id;
		this.user_id = user_id;
		this.test_id = test_id;
		this.centre_id = centre_id;
		this.appointment_date = appointment_date;
		this.appointment_time = appointment_time;
		this.approval_status = approval_status;
	}
	
	
	
	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", user_id=" + user_id + ", test_id=" + test_id
				+ ", centre_id=" + centre_id + ", appointment_date=" + appointment_date + ", appointment_time="
				+ appointment_time + ", approval_status=" + approval_status + "]";
	}
	
	
}

