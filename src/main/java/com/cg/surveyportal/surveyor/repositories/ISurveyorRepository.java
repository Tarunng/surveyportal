package com.cg.surveyportal.surveyor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.surveyportal.surveyor.entities.Surveyor;

public interface ISurveyorRepository  extends JpaRepository<Surveyor , Long>{

}
