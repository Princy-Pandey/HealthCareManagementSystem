package com.capgemini.healthcaresystem.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a entity class that provides the entites for 
 *                           appointment made by user .
 *          Version             1.0
 *          Created Date    20-APR-2020
 ************************************************************************************/



@Entity
@Table(name= "APPOINTMENT")
public class Appointment
{
	
	
	
	/*************Appointment Id ****************/
	@Id
	@Column(name= "APPOINTMENT_ID",length=10)
	private long appointmentId;
	
	/**************Appointment Date**************/
	@Column(name= "APPOINTMENT_DATE")
	private LocalDate appointmentDate;
	
	
	
	
    /**************Appointment Time**************/
	@Column(name= "APPOINTMENT_TIME")
	private String appointmentTime;
	

	
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name= "TEST",referencedColumnName = "test_id" )
		private Test test;
		
		
		
		/**************Getters and Setters***********/
		

		public Appointment() {}

		public long getAppointmentId() {
			return appointmentId;
		}

		public void setAppointmentId(long appointmentId) {
			this.appointmentId = appointmentId;
		}

		public LocalDate getAppointmentDate() {
			return appointmentDate;
		}

		public void setAppointmentDate(LocalDate appointmentDate) {
			this.appointmentDate = appointmentDate;
		}

		public String getAppointmentTime() {
			return appointmentTime;
		}

		public void setAppointmentTime(String appointmentTime) {
			this.appointmentTime = appointmentTime;
		}

		public Test getTest() {
			return test;
		}

		public void setTest(Test test) {
			this.test = test;
		}

		public Appointment(long appointmentId, LocalDate appointmentDate, String appointmentTime,Test test) {
			super();
			this.appointmentId = appointmentId;
			this.appointmentDate = appointmentDate;
			this.appointmentTime = appointmentTime;
			this.test=test;
		}

		@Override
		public String toString() {
			return "AddAppointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
					+ ", appointmentTime=" + appointmentTime + ", test= "+test+ "]";
		}

		
		
		
}
