package com.cg.surveyportal.surveyor.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Surveyor {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(nullable = false, length = 20)
    private String username;
	@Column(nullable = false, length = 20)
    private String firstName;
	@Column(nullable = false, length = 20)
    private String lastName;
	@Column(nullable = false, length = 20)
    private String password;
	
	
	
    
	public Surveyor() {
		super();
		
	}

	public Surveyor(Long id, String username, String firstName, String lastName, String password) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "Surveyor [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + "]";
	}

	public void setPassword(String password) {
		this.password = password;
	}

    //private List<Survey>createdSurveys;

    

    //public List<Survey> getCreatedSurveys() {
      //  return createdSurveys;
    //}

    //public void setCreatedSurveys(List<Survey> createdSurveys) {
      //  this.createdSurveys = createdSurveys;
    //}
}
