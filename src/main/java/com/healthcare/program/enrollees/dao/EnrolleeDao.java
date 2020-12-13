package com.healthcare.program.enrollees.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.program.enrollees.model.Enrollees;

@Repository("enrolleeDao")
public interface EnrolleeDao extends JpaRepository<Enrollees, Integer> {
	

}
