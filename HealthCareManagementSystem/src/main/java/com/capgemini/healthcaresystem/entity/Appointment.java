package com.capgemini.healthcaresystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a entity class that provides the entites for 
 *                           appointment made by user .
 *          Version             1.0
 *          Created Date    20-APR-2020
 ************************************************************************************/


@Data
@Entity
@Table(name= "APPOINTMENT")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Appointment
{
	
	/*************Appointment Id ****************/
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	/*************Appointment Id ****************/
	@Id
	@Column(name= "APPOINTMENT_ID",length=10)
	private long appointmentId;
	
	/**************Appointment Date**************/
	@Column(name= "APPOINTMENT_DATE")
	private String appointmentDate;
	
	
	
	
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

		public String getAppointmentDate() {
			return appointmentDate;
		}

		public void setAppointmentDate(String appointmentDate) {
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

		public Appointment(long appointmentId, String appointmentDate, String appointmentTime,Test test) {
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
