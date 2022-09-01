package com.lti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.InsuranceClaim;



@Repository
public interface InsuranceClaimRepo extends JpaRepository<InsuranceClaim, Integer>{
	
	List<InsuranceClaim> findAll();
	
	InsuranceClaim save(InsuranceClaim insuranceClaim);
	

}
