package com.capgemini.healthcaresystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name= "USER")
public class User {
	
	
	//Id 
   
	@Id
	@Column(name= "USER_ID")
	private long user_id;
    
    //Name
    
	@Column(name= "USER_NAME")
	private String user_name;
    
    
    //Contact-number
    
	@Column(name= "USER_CONTACT_NO")
	private long user_contact_no;
	
    //Email ID
    
	@Column(name= "USER_EMAIL")
	private String user_email;
    
    //Age
    
	@Column(name= "USER_AGE")
	private int user_age;
	
    
    //Gender
    
	@Column(name= "USER_GENDER")
	private String user_gender;
    
    
    
    //Getters and Setters
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public long getUser_contact_no() {
		return user_contact_no;
	}
	public void setUser_contact_no(long user_contact_no) {
		this.user_contact_no = user_contact_no;
	}
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	
	
	
    //Default Constructor
	public User() {}
	
	
	
	//Parameterized Constructor
	public User( long user_id, String user_name, long user_contact_no,String user_email,int user_age,String user_gender) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_contact_no = user_contact_no;
		this.user_email = user_email;
		this.user_age = user_age;
		this.user_gender = user_gender;
	}
	
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_contact_no=" + user_contact_no
				+ ", user_email=" + user_email + ", user_age=" + user_age + ", user_gender=" + user_gender + "]";
	}
	
	
	
}
