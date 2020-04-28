package com.capgemini.healthcaresystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




/************************************************************************************
 *          @author          Princy Pandey
 *          Description      It is a entity class that provides the entites for 
 *                           test inside diagnostic centre made by admin .
 *          Version             1.0
 *          Created Date    20-APR-2020
 ************************************************************************************/


@Entity
@Table(name= "TEST")
public class Test {
	
	
	/*************Test Id ****************/
	@Id
	@Column(name= "TEST_ID",length=20)
	private String testId;
	
	
	/*************Test Id ****************/
    @Column(name= "TEST_NAME",length=25)
	private String testName;
	
    
    /*************Centre Id ****************/
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "DIAGNOSTIC_CENTRE",referencedColumnName = "centre_id" )
	private DiagnosticCentre diagnosticCentre;


	/**************Getters and Setters***********/
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


	public DiagnosticCentre getCentre() {
		return diagnosticCentre;
	}


	public void setCentre(DiagnosticCentre diagnosticCentre) {
		this.diagnosticCentre = diagnosticCentre;
	}

	/**************Default Constructor**************/
	public Test() {}

	
	/************Parameterized Constructor***********/
	public Test(String testId, String testName, DiagnosticCentre diagnosticCentre) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.diagnosticCentre = diagnosticCentre;
	}


	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + ", centre=" + diagnosticCentre + "]";
	}
	
	
	
	
}
