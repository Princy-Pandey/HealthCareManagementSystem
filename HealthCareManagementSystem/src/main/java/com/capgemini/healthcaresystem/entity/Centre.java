package com.capgemini.healthcaresystem.entity;

import java.util.HashSet;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;



@Data
@Entity()
@Table(name= "CENTRE")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Centre {
	
	//Id 
	@Id
	@Column(name= "CENTRE_ID")
	private int centre_id;
    
	
    @Column(name= "CENTRE_NAME")
	private String centre_name;
	
    
	
    

    
    
	
    //Getters and setters 
    public long getCentre_id() {
		return centre_id;
	}
	public void setCentre_id(int centre_id) {
		this.centre_id = centre_id;
	}

	public String getCentre_name() {
		return centre_name;
	}
	public void setCentre_name(String centre_name) {
		this.centre_name = centre_name;
	}
	
	
	public Centre() {}
	
	//Parameterized Constructor
	public Centre(int centre_id, String centre_name) {
		super();
		this.centre_id = centre_id;
		this.centre_name = centre_name;
		
	}
	
	
	@Override
	public String toString() {
		return "Centre [centre_id=" + centre_id + ", centre_name=" + centre_name +"]";
	}
	
	
}
