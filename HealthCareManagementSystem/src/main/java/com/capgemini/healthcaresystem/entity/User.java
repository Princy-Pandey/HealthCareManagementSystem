package com.capgemini.healthcaresystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;

/************************************************************************************
 *          @author          Princy Pandey
 *          Description      It is a entity class that provides the entites for 
 *                           user registered .
 *          Version             1.0
 *          Created Date    20-APR-2020
 ************************************************************************************/



@Entity
@Table(name= "USER")
public class User {
	
	/*************User Id ****************/
	@Id
	@Column(name= "USER_ID",length=20)
	private String userId;
    
	/*************User Name ****************/
	@Column(name= "USER_NAME",length=25)
	private String userName;
    
    
	/**********User Contact Number *********/
	@Column(name= "USER_CONTACT_NO",length=10)
	private long userContactNumber;
	
	/**********User Email Id **************/
	@Column(name= "USER_EMAIL",length=25)
	private String userEmail;
    
	/*************User Age****************/
	@Column(name= "USER_AGE",length=10)
	private int userAge;
	
    
	/*************User Gender****************/
	@Column(name= "USER_GENDER",length=25)
	private String userGender;

	
	/**************Getters and Setters***********/
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public long getUserContactNumber() {
		return userContactNumber;
	}


	public void setUserContactNumber(long userContactNumber) {
		this.userContactNumber = userContactNumber;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public int getUserAge() {
		return userAge;
	}


	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}


	public String getUserGender() {
		return userGender;
	}


	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	
	
	/**************Default Constructor**************/
	public User() {}


	/************Parameterized Constructor***********/
	public User(String userId, String userName, long userContactNumber, String userEmail, int userAge,
			String userGender) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userContactNumber = userContactNumber;
		this.userEmail = userEmail;
		this.userAge = userAge;
		this.userGender = userGender;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userContactNumber=" + userContactNumber
				+ ", userEmail=" + userEmail + ", userAge=" + userAge + ", userGender=" + userGender + "]";
	}
    
    
    
    
	
}
