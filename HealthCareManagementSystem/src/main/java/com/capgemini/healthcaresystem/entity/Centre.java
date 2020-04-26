package com.capgemini.healthcaresystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name= "CENTRE")
public class Centre
{
	
	//Id    
	@Id
	@Column(name= "CENTRE_ID")
	private int centre_id;
    
    //Name
    @Column(name= "CENTRE_NAME")
	private String centre_name;
    
    //Getters and setters 
    public void setCentre_id(int centre_id) 
    {
		this.centre_id = centre_id;
	}
    public int getCentre_id() 
    {
		return centre_id;
	}
    
    public void setCentre_name(String centre_name) 
	{
		this.centre_name = centre_name;
	}
	public String getCentre_name() 
	{
		return centre_name;
	}
	
	//Default Constructor
	public Centre() {}
	
	//Parameterized Constructor
	public Centre(int centre_id, String centre_name) {
		super();
		this.centre_id = centre_id;
		this.centre_name = centre_name;
	}
	
	@Override
	public String toString() {
		return "Centre [centre_id=" + centre_id + ", centre_name=" + centre_name + "]";
	}
	
	
}
