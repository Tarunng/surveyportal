package com.cg.surveyportal.surveyor.services;

import java.util.List;

import com.cg.surveyportal.surveyor.entities.Surveyor;
import com.cg.surveyportal.surveyor.exceptions.InvalidSurveyorException;
import com.cg.surveyportal.surveyor.exceptions.SurveyorNotFoundException;

public interface ISurveyorService {

	public String register(Surveyor surveyor) throws InvalidSurveyorException;

    public String authenticate(String username, String password) throws SurveyorNotFoundException;

    public Surveyor findById(Long surveyorId) throws SurveyorNotFoundException;

    public String update(Surveyor surveyor)throws InvalidSurveyorException,SurveyorNotFoundException;
    
    public String delete(Long surveyorId) throws InvalidSurveyorException;
    
    public List<Surveyor> getAllSurveyor();
    
    public Long getRecordsCount();
    
    public List<Surveyor> getbylastname(String lastname);
    
    public String deleteAll();

}

