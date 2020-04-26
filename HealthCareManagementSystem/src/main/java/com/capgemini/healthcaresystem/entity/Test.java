package com.capgemini.healthcaresystem.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name= "TEST")
public class Test {
	
	//Id 
   
	@Id
	@Column(name= "TEST_ID",length=20)
	private String testId;
    
    
    //Name
   
    @Column(name= "TEST_NAME",length=25)
	private String testName;
	
    
	//Foreign key
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "CENTRE",referencedColumnName = "centre_id" )
	
	private Centre centre;


	//Getters and Setters
	public String getTestId() {
		return testId;
	}


	public void setTestId(String testId) {
		this.testId = testId;
	}


	public String getTestName() {
		return testName;
	}


	public void setTestName(String testName) {
		this.testName = testName;
	}


	public Centre getCentre() {
		return centre;
	}


	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	//Default Constructor
	public Test() {}

	
	//Parameterized Constructor
	public Test(String testId, String testName, Centre centre) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.centre = centre;
	}


	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + ", centre=" + centre + "]";
	}
	
	
	
	
}
