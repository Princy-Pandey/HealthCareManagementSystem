package com.capgemini.healthcaresystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@Table(name="LOGIN")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Login 
{
	@Column(name = "loginId")
	private int loginId;
	
	@Id
	@Column(name= "userMail")
	private String userMail;
	
	@Column(name= "userPassword")
	private String userPassword;
		
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "USER_ID", referencedColumnName ="USER_ID")
	private User userId;
	
	public Login()
	{
		
	}
	
	public Login(String userMail, String userPassword,User userId)
	{
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userId = userId;
	}

	public void setLoginId(int loginId) 
	{
		this.loginId = loginId;
	}
	public int getLoginId() 
	{
		return loginId;
	}

	public void setUserId(User userId)
	{
		this.userId = userId;
	}
	public User getUserId() 
	{
		return userId;
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

	
	@Override
	public String toString()
	{
		return userId + " " + userMail + " " + userPassword ;
	}
}
