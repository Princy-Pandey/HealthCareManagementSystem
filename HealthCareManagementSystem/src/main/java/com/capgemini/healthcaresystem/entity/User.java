package com.capgemini.healthcaresystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
	private int user_id;
	
	@Column(name = "USER_ROLE")
	private String user_role;
	
	@Column(name= "USER_NAME", length=25)
    @NotBlank(message = "Firstname is mandatory")
	private String user_name;
	
	@Column(name= "USER_PASSWORD", length=50)
    @NotBlank(message = "Password is mandatory")
	private String user_password;
		
	@Column(name= "_USER_MAIL", unique=true, length=50)
    @NotBlank(message = "Email is mandatory")
	private String user_mail;
	
	@Column (name= "USER_CONTACT", length=10)
    @NotBlank(message = "Contact is mandatory")
	private long user_contact;

	@Column(name= "USER_GENDER", length=10)
    @NotBlank(message = "Gender is mandatory")
	private String user_gender; 
	
	@Column(name= "USER_AGE", length=4)
    @NotBlank(message = "Age is mandatory")
	private  int user_age;
	
	@Column(name = "SECRET_MESSAGE", length=10)
    @NotBlank(message = "Password is mandatory")
	private String secret_message;
	
	@Column(name = "active",length=1)
	private int active;
	
	public enum type{admin,user};
	@Enumerated(EnumType.STRING)
	private type userType=type.user;
	
	public enum login{loggedIn,LoggedOut};
	@Enumerated(EnumType.STRING)
	private login loginStatus=login.LoggedOut;
	
	//Default Constructor
	public User() 
	{
		
	}
	
	//Parameterized Constructor
	public User(String user_mail,String user_password) 
	{
		this.user_mail = user_mail;
		this.user_password = user_password;
	}

	public User(int user_id,String user_role, String user_name, String user_mail, String user_password, long user_contact, 
			String user_gender,int user_age, String secret_message) 
	{
		super();
		this.user_id = user_id;
		this.user_role = user_role;
		this.user_name = user_name;
		this.user_mail = user_mail;
		this.user_password = user_password;
		this.user_contact = user_contact;
		this.user_gender = user_gender;
		this.user_age = user_age;
		this.secret_message = secret_message;
	}
	
	//Getters and Setters 
	public int getUser_id() 
	{
		return user_id;
	}
	public void setUser_id(int user_id) 
	{
		this.user_id = user_id;
	}

	public String getUser_role() 
	{
		return user_role;
	}
	public void setUser_role(String user_role) 
	{
		this.user_role = user_role;
	}

	public String getUser_name() 
	{
		return user_name;
	}
	public void setUser_name(String user_name) 
	{
		this.user_name = user_name;
	}

	public String getUser_password() 
	{
		return user_password;
	}
	public void setUser_password(String user_password) 
	{
		this.user_password = user_password;
	}

	public String getUser_mail() 
	{
		return user_mail;
	}
	public void setUser_mail(String user_mail) 
	{
		this.user_mail = user_mail;
	}

	public long getUser_contact() 
	{
		return user_contact;
	}
	public void setUser_contact(long user_contact) 
	{
		this.user_contact = user_contact;
	}

	public String getUser_gender() 
	{
		return user_gender;
	}
	public void setUser_gender(String user_gender) 
	{
		this.user_gender = user_gender;
	}

	public int getUser_age() 
	{
		return user_age;
	}
	public void setUser_age(int user_age) 
	{
		this.user_age = user_age;
	}

	public String getSecret_message() 
	{
		return secret_message;
	}
	public void setSecret_message(String secret_message) 
	{
		this.secret_message = secret_message;
	}

	public int getActive() 
	{
		return active;
	}
	public void setActive(int active) 
	{
		this.active = active;
	}

	public type getUserType() 
	{
		return userType;
	}
	public void setUserType(type userType) 
	{
		this.userType = userType;
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
		return "User [user_id=" + user_id + ", user_role=" + user_role + ", user_name=" + user_name + ", user_contact_no=" + user_contact
				+ ", user_email=" + user_mail + ", user_password=" + user_password + ", user_age=" + user_age + ", user_gender=" + user_gender + "]";
	}
}
