package com.capgemini.healthcaresystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;



@Data
@Entity
@Table(name= "TEST")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Test {
	
	//Id 
	@Id
	@Column(name= "TEST_ID")
	private int test_id;
	
    @Column(name= "TEST_NAME")
	private String test_name;
	
    
    
    
    //Name
	
	
	
    
	//Foreign key
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "CENTRE",referencedColumnName = "centre_id" )
	private Centre centre;
	
	
	//Getters and Setters
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	
    public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public Centre getCenter() {
		return centre;
	}
	public void setCentre(Centre centre) {
		this.centre = centre;
		//centre.getTest().add(this);
	}

	
	//Default Constructors
	public Test() {}
	
	
	//Parameterized Constructors
	public Test(int test_id, String test_name, Centre centre) {
		super();
		this.test_id = test_id;
		this.test_name = test_name;
		this.centre=centre;
	}
	
	
	@Override
	public String toString() {
		return "Test [test_id=" + test_id + ", test_name=" + test_name+ ", centre="+ centre+ "]";
	}
	
	
}
