package com.healthcare.program.enrollees.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.program.enrollees.model.Dependent;

@Repository("dependentDao")
public interface DependentDao extends JpaRepository<Dependent, Integer> {
	

}
