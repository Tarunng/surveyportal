package com.cg.surveyportal.surveyor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.surveyportal.surveyor.entities.Surveyor;
import com.cg.surveyportal.surveyor.exceptions.InvalidSurveyorException;
import com.cg.surveyportal.surveyor.exceptions.SurveyorNotFoundException;
import com.cg.surveyportal.surveyor.services.SurveyorServiceImpl;

@RestController
@RequestMapping("/surveyor")
public class SurveyorController 
{
	@Autowired
	SurveyorServiceImpl surveyorserviceimpl;
	
	
	
	@GetMapping("/store")
	private void insert()
	{
		 surveyorserviceimpl.storesurveyor();
	}
	
	@GetMapping("/count")
	private ResponseEntity<Long> countRecords()
	{
		return new ResponseEntity<>(surveyorserviceimpl.getRecordsCount(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/bylastname/{lastname}")
	private List<Surveyor> getbyLastName(@PathVariable String lastname)
	{
		return surveyorserviceimpl.getbylastname(lastname);
	}
	
	
	
	//@GetMapping("/hello")
	//private String hello()
	//{
		//return "Hello World";
	//}
	
	
	@GetMapping("/check")
	private ResponseEntity<String> checkSurveyor( @RequestParam(value = "username") String username, @RequestParam(value="password") String password) throws SurveyorNotFoundException 
	{
		
		return new ResponseEntity<>(surveyorserviceimpl.authenticate(username, password),HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	
	@GetMapping("/allsurveyor")
	private List<Surveyor> getSurveyor()
	{
		return surveyorserviceimpl.getAllSurveyor();
	}
	
	@GetMapping("/{surveyorId}")
	private Surveyor getSurveyorbyid(@PathVariable("surveyorId") String surveyorId) throws NumberFormatException, SurveyorNotFoundException
	{
		return surveyorserviceimpl.findById(Long.parseLong(surveyorId));
	}
	
	@PostMapping("/add")
	private ResponseEntity<String> addSurveyor(@RequestBody Surveyor surveyor) throws InvalidSurveyorException
	{
		return new ResponseEntity<>(surveyorserviceimpl.register(surveyor),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	private ResponseEntity <String> updateSurveyor(@RequestBody Surveyor surveyor) throws InvalidSurveyorException, SurveyorNotFoundException
	{
		return new ResponseEntity<>(surveyorserviceimpl.update(surveyor),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{surveyorId}")
	 private ResponseEntity<String> deleteSurveyor(@PathVariable String surveyorId) throws NumberFormatException, InvalidSurveyorException
	{
		return new ResponseEntity<>( surveyorserviceimpl.delete(Long.parseLong(surveyorId)),HttpStatus.OK);
	}
	
	@DeleteMapping("deleteall")
	private ResponseEntity<String> deleteAllRecords()
	{
		return new ResponseEntity<>(surveyorserviceimpl.deleteAll(),HttpStatus.ACCEPTED);
	}
	
	

}
