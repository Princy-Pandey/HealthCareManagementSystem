package com.capgemini.healthcaresystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="USERDATA")
@DynamicUpdate(true)
@DynamicInsert(true)
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	private int userId;
	
	@Column(name= "userName")
	private String userName;
	
	@Column(name= "userPassword")
	private String userPassword;
		
	@Column(name= "userMail")
	private String userMail;
	
	@Column (name= "userContact")
	private long userContact;

	@Column(name= "userGender")
	private String userGender; 
	
	@Column(name= "userAge")
	private  int userAge;
	
	@Column(name = "secretMessage")
	private String secretMessage;

	public User() 
	{
		
	}

	public User(int userId, String userName, String userMail, String userPassword, long userContact, String userGender, int userAge, String secretMessage) 
	{
		super();
		this.userId = userId;
		this.userName = userName;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userContact = userContact;
		this.userGender = userGender;
		this.userAge = userAge;
		this.secretMessage = secretMessage;
	}

	public long getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public void setUserMail(String userMail) 
	{
		this.userMail = userMail;
	}
	public String getUserMail() 
	{
		return userMail;
	}
	
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}
	public String getUserPassword() 
	{
		return userPassword;
	}

	public long getUserContact() 
	{
		return userContact;
	}
	public void setUserContact(long userContact) 
	{
		this.userContact = userContact;
	}

	public String getUserGender() 
	{
		return userGender;
	}
	public void setUserGender(String userGender) 
	{
		this.userGender = userGender;
	}

	public int getUserAge() 
	{
		return userAge;
	}
	public void setUserAge(int userAge) 
	{
		this.userAge = userAge;
	}
	
	public void setSecretMessage(String secretMessage) 
	{
		this.secretMessage = secretMessage;
	}
	public String getSecretMessage() 
	{
		return secretMessage;
	}
	
	@Override
	public String toString()
	{
		return userId + " " + userName  + " "  + userMail + " "  + userPassword + " "  + userContact + " " + userGender + " " + userAge + " " + 			secretMessage;
	}
}
