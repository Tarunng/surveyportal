package com.cg.surveyportal.surveyor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.surveyportal.surveyor.entities.Surveyor;

public interface ISurveyorRepository  extends JpaRepository<Surveyor , Long>{
	// Derived Query method
	public List<Surveyor> findByUsernameAndPassword(String username, String password);
	public List<Surveyor> findByLastName(String lastname);

}
