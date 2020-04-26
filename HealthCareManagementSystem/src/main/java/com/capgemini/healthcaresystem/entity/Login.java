package com.capgemini.healthcaresystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN")
public class Login 
{
	@Id
	@Column(name = "LOGIN_ID")
	private String loginId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "USER", referencedColumnName ="USER_ID")
	private User user;
	
	public enum login{loggedIn,LoggedOut};
	@Enumerated(EnumType.STRING)
	private login loginStatus=login.LoggedOut;
	
	//Default Constructor
	public Login()
	{
		
	}

	//Getters and Setters
	public String getLoginId() 
	{
		return loginId;
	}
	public void setLoginId(String loginId) 
	{
		this.loginId = loginId;
	}

	public User getUser() 
	{
		return user;
	}
	public void setUser(User user) 
	{
		this.user = user;
	}

	public login getLoginStatus() 
	{
		return loginStatus;
	}
	public void setLoginStatus(login loginStatus) 
	{
		this.loginStatus = loginStatus;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", user=" + user + ", loginStatus=" + loginStatus + "]";
	}

}
