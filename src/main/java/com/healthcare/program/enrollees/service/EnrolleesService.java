package com.healthcare.program.enrollees.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.program.enrollees.dao.DependentDao;
import com.healthcare.program.enrollees.dao.EnrolleeDao;
import com.healthcare.program.enrollees.model.Dependent;
import com.healthcare.program.enrollees.model.Enrollees;

/**
 * Service class contains service methods for all API methods that are in
 * controller
 * 
 * @author anil
 *
 */
@Service
public class EnrolleesService {

	@Autowired
	private EnrolleeDao enrolleeDao;

	@Autowired
	private DependentDao dependentDao;

	public Enrollees addEnrollee(Enrollees enrollee) {
		Enrollees enrolleeObj = enrolleeDao.save(enrollee);
		return enrolleeObj;
	}

	public Enrollees updateEnrollee(Enrollees enrollees) {
		Enrollees enrolleeObj = enrolleeDao.save(enrollees);
		return enrolleeObj;
	}

	public String removeEnrollee(int id) {
		Optional<Enrollees> enrollee = enrolleeDao.findById(id);
		if (enrollee.isPresent()) {
			enrolleeDao.deleteById(id);
			return "deleted successfully";
		} else {
			return "Id not found. Try different id";
		}
	}

	public Enrollees addDependent(int enrolleeId, Dependent dependent) {
		Optional<Enrollees> enrollees = enrolleeDao.findById(enrolleeId);
		Enrollees enrollee = null;
		if (enrollees.isPresent()) {
			enrollee = enrollees.get();
			enrollee.setDependent(dependent);
			dependent.setEnrollees(enrollee);
			dependentDao.save(dependent);
		}
		return enrollee;
	}

	public Dependent updateDependent(int enrolleeId, Dependent dependent) {
		Optional<Enrollees> enrollees = enrolleeDao.findById(enrolleeId);
		if (enrollees.isPresent()) {
			Enrollees enrollee = enrollees.get();
			enrollee.setDependent(dependent);
			dependent.setEnrollees(enrollee);
			dependentDao.save(dependent);
			return dependent;
		} else
			return null;
	}

	public String detachDependent(int enrolleeId) {
		Optional<Enrollees> enrollees = enrolleeDao.findById(enrolleeId);
		if (enrollees.isPresent()) {
			Enrollees enrollee = enrollees.get();
			enrollee.setDependent(null);
			enrollee = enrolleeDao.save(enrollee);
			return "dependencies removed from " + enrollee.getEnrolleeName();
		} else {
			return "Id not found. Try another one";
		}
	}

}
