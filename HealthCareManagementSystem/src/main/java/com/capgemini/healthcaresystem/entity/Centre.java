package com.capgemini.healthcaresystem.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name= "CENTRE")
public class Centre{
	
	//Id 
   
	@Id
	@Column(name= "CENTRE_ID",length=20)
	private String centreId;
    
	
    //Name
   
    @Column(name= "CENTRE_NAME",length=25)
	private String centreName;


    //Getters and Setters
	public String getCentreId() {
		return centreId;
	}


	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}


	public String getCentreName() {
		return centreName;
	}


	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}

	
	//Default Constructor
	public Centre() {}

	//Parameterized Constructor
	public Centre(String centreId, String centreName) {
		super();
		this.centreId = centreId;
		this.centreName = centreName;
	}


	@Override
	public String toString() {
		return "Centre [centreId=" + centreId + ", centreName=" + centreName + "]";
	}
    
    
   
	
    
	
}
