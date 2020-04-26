package com.capgemini.healthcaresystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="USERDATA")
public class User 
{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_ROLE", columnDefinition = "varchar(255) default 'User'")
	private String userRole;
	
	@Column(name= "USER_NAME", length=25)
    //@NotBlank(message = "Firstname is mandatory")
	private String userName;
	
	@Column(name= "USER_PASSWORD", length=50)
    //@NotBlank(message = "Password is mandatory")
	private String userPassword;
		
	@Column(name= "USER_MAIL", unique=true, length=50)
    //@NotBlank(message = "Email is mandatory")
	private String userMail;
	
	@Column (name= "USER_CONTACT", length=10)
    //@NotBlank(message = "Contact is mandatory")
	private long userContact;

	@Column(name= "USER_GENDER", length=10)
    //@NotBlank(message = "Gender is mandatory")
	private String userGender; 
	
	@Column(name= "USER_AGE", length=4)
    //@NotBlank(message = "Age is mandatory")
	private  int userAge;
	
	@Column(name = "SECRET_WORD", length=10)
    //@NotBlank(message = "Word is mandatory")
	private String secretWord;
	
	//Default Constructor
	public User() 
	{
		
	}
	
	//Parameterized Constructor
	public User(String userId,String userRole, String userName, String userMail, String userPassword, long userContact, 
			String userGender,int userAge, String secretWord) 
	{
		super();
		this.userId = userId;
		this.userRole = userRole;
		this.userName = userName;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userContact = userContact;
		this.userGender = userGender;
		this.userAge = userAge;
		this.secretWord = secretWord;
	}
	
	//Getters and Setters 
	public String getUserId() 
	{
		return userId;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserRole() 
	{
		return userRole;
	}
	public void setUserRole(String userRole) 
	{
		this.userRole = userRole;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserPassword() 
	{
		return userPassword;
	}
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}

	public String getUserMail() 
	{
		return userMail;
	}
	public void setUserMail(String userMail) 
	{
		this.userMail = userMail;
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

	public String getSecretWord() 
	{
		return secretWord;
	}
	public void setSecretWord(String secretWord) 
	{
		this.secretWord = secretWord;
	}

	@Override
	public String toString() 
	{
		return "User [userId=" + userId + ", userRole=" + userRole + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userMail=" + userMail + ", userContact=" + userContact + ", userGender="
				+ userGender + ", userAge=" + userAge + ", secretWord=" + secretWord + "]";
	}
}
