/************************************************************************************
 *          @author          Kiran Rajput
 *          Description      It is a A  appointmentEntity class that provides appointmentEntity for Healthcare system, 
                                         and viewing all its conponents  
  *         Version             1.0
  *         Created Date    26-APR-2020
 ************************************************************************************/
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

@Data
@Entity
@Table(name= "APPOINTMENT")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Appointment
{
	

	//Appointment Id
	
	@Id
	private int appointment_id;
	
    //Appointment Date
    
	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	@Column(name= "APPOINTMENT_DATE")
	private String appointment_date;
	
    //Appointment Time
    
	@Column(name= "APPOINTMENT_TIME")
	private String appointment_time;
	
	//Centre NAme 
		/*@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name= "CENTRE",referencedColumnName = "centre_id" )
		private Centre centre;
		*/
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name= "TEST",referencedColumnName = "test_id" )
		private Test test;
		
		
		
		

		public String getAppointment_date() {
			return appointment_date;
		}

		public void setAppointment_date(String appointment_date) {
			this.appointment_date = appointment_date;
		}

		public String getAppointment_time() {
			return appointment_time;
		}

		public void setAppointment_time(String appointment_time) {
			this.appointment_time = appointment_time;
		}

		/*public Centre getCentre() {
			return centre;
		}

		public void setCentre(Centre centre) {
			this.centre = centre;
		}*/
		
		public Test getTest() {
			return test;
		}

		public void setTest(Test test) {
			this.test = test;
		}
		
		
		public Appointment() {}

		public Appointment(int appointment_id, String appointment_date, String appointment_time,Test test) {
			super();
			this.appointment_id = appointment_id;
			this.appointment_date = appointment_date;
			this.appointment_time = appointment_time;
			//this.centre = centre;
			this.test=test;
		}

		@Override
		public String toString() {
			return "AddAppointment [appointment_id=" + appointment_id + ", appointment_date=" + appointment_date
					+ ", appointment_time=" + appointment_time + ", test= "+test+ "]";
		}

		
		
		
}
