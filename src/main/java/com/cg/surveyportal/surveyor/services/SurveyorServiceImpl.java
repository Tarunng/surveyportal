package com.cg.surveyportal.surveyor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.surveyportal.surveyor.entities.Surveyor;
import com.cg.surveyportal.surveyor.exceptions.InvalidSurveyorException;
import com.cg.surveyportal.surveyor.exceptions.SurveyorNotFoundException;
import com.cg.surveyportal.surveyor.repositories.ISurveyorRepository;
@Service
public class SurveyorServiceImpl  implements ISurveyorService
{
	
	@Autowired
	ISurveyorRepository isurveyorrepository;
	
	
	@Override
	public String register(Surveyor surveyor) throws InvalidSurveyorException 
	{
		isurveyorrepository.save(surveyor);
		return "Surveyor Added SuccessFully";
	}

	@Override
	public String authenticate(String username, String password) throws SurveyorNotFoundException
	{
		List<Surveyor> surveyor = isurveyorrepository.findByUsernameAndPassword(username,password);
		if(surveyor.isEmpty())
		{
			throw new SurveyorNotFoundException("Invalid Surveyor");
		}
		else
		{
			Surveyor s = surveyor.get(0);
			return "Valid Surveyor with details:"+s.toString();
		}
						
	}

	@Override
	public Surveyor findById(Long surveyorId) throws SurveyorNotFoundException {
		
		return isurveyorrepository.findById(surveyorId).orElseThrow(()-> new SurveyorNotFoundException("Invalid SurveyorId"));
	}

	@Override
	public String update(Surveyor surveyor) throws InvalidSurveyorException, SurveyorNotFoundException {
		 isurveyorrepository.save(surveyor);
		 return "Data Update Succesfully";
	}

	@Override
	public String delete(Long surveyorId) throws InvalidSurveyorException {
		Surveyor surveyor = isurveyorrepository.findById(surveyorId).orElseThrow(()-> new InvalidSurveyorException("Invalid SurveyorId"));
		isurveyorrepository.deleteById(surveyor.getId());
		return "Data Deleted Succesfully";
	}

	@Override
	public List<Surveyor> getAllSurveyor() {
		
		return isurveyorrepository.findAll();
	}
	
	public void storesurveyor()
	{	
		List<Surveyor> list = new ArrayList<>();
		
		Surveyor sv = new Surveyor();
		
		sv.setFirstName("Tarun");
		sv.setLastName("Jain");
		sv.setUsername("Rahul_123");
		sv.setPassword("Tarun@123");
		
		list.add(sv);
		
		sv = new Surveyor();
		sv.setFirstName("Rohit");
		sv.setLastName("patel");
		sv.setUsername("Rohit_123");
		sv.setPassword("Rohit@123");
		list.add(sv);
		
		sv = new Surveyor();
		sv.setFirstName("Rajan");
		sv.setLastName("Jain");
		sv.setUsername("Rajan_123");
		sv.setPassword("Rajan@123");
		
		list.add(sv);
		
		isurveyorrepository.saveAll(list);
		
		
	}

	@Override
	public Long getRecordsCount() {
		
		return isurveyorrepository.count();
	}
	@Override
	public List<Surveyor> getbylastname(String lastname)
	{
		return isurveyorrepository.findByLastName(lastname);
	}

	@Override
	public String deleteAll() {
		isurveyorrepository.deleteAll();
		return "All Records Deleted";
	}

	
	
	
	

}
