package com.healthcare.program.enrollees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.program.enrollees.model.Dependent;
import com.healthcare.program.enrollees.model.Enrollees;
import com.healthcare.program.enrollees.service.EnrolleesService;
/**
 * Controller for Enrollee and Dependent API methods
 * @author anil
 *
 */
@RestController
@RequestMapping("/api/v1")
public class HealthCareController {
	
	@Autowired
	private EnrolleesService enrolleesService;
	
	/**
	 * Adds given Enrollee 
	 * @param enrollee
	 * @return
	 */
	@PostMapping("/enrollee")
	public ResponseEntity<Enrollees> addEnrollee(@RequestBody Enrollees enrollee){
		Enrollees addedEnrollees=enrolleesService.addEnrollee(enrollee);
		return new ResponseEntity<Enrollees>(addedEnrollees,HttpStatus.OK);
	}
	
	/**
	 * Updates Enrollee details
	 * @param enrollee
	 * @return
	 */
	@PutMapping("/enrollee/update")
	public ResponseEntity<Enrollees> updateEnrollee(@RequestBody Enrollees enrollee){
		Enrollees updatedEnrollees=enrolleesService.updateEnrollee(enrollee);
		return new ResponseEntity<Enrollees>(updatedEnrollees,HttpStatus.OK);
	}
	
	/**
	 * Delete Enrollee for given Id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/enrollee/{id}")
	public ResponseEntity<String> removeEnrollee(@PathVariable int id){
		String response = enrolleesService.removeEnrollee(id);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	/**
	 * Adds dependent  to the Enrollee for given enrolle id
	 * @param enrolleeId
	 * @param dependent
	 * @return
	 */
	@PostMapping("/enrollee/dependent/{enrolleeId}")
	public ResponseEntity<Enrollees> addDependent(@PathVariable int enrolleeId,@RequestBody Dependent dependent){
		Enrollees enrollee=enrolleesService.addDependent(enrolleeId, dependent);
		return new ResponseEntity<Enrollees>(enrollee,HttpStatus.OK);
	}
	
	/**
	 * Updates dependent details for given Enrollee Id
	 * @param enrolleeId
	 * @param dependent
	 * @return
	 */
	@PutMapping("/enrollee/dependent/update/{enrolleeId}")
	public ResponseEntity<Dependent> updateDependent(@PathVariable int enrolleeId,@RequestBody Dependent dependent){
		Dependent updatedDependent = enrolleesService.updateDependent(enrolleeId,dependent);
		return new ResponseEntity<Dependent>(updatedDependent,HttpStatus.OK);
	}
	
	/**
	 * Removes the dependent info from enrollee for given enrollee Id
	 * @param enrolleeId
	 * @return
	 */
	@DeleteMapping("/enrollee/dependent/{enrolleeId}")
	public ResponseEntity<String> detachDependent(@PathVariable int enrolleeId){
		String response = enrolleesService.detachDependent(enrolleeId);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}

}
