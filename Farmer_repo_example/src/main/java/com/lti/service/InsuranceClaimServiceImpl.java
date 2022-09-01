package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.InsuranceClaim;
import com.lti.repository.InsuranceClaimRepo;

@Service
public class InsuranceClaimServiceImpl implements InsuranceClaimService {

	@Autowired
	InsuranceClaimRepo insuranceClaimRepo;
	
	@Override
	public void claimInsurance(InsuranceClaim claim) {
		// TODO Auto-generated method stub
		InsuranceClaim ic = insuranceClaimRepo.save(claim);
		
	}

	@Override
	public List<InsuranceClaim> viewAllClaim() {
		// TODO Auto-generated method stub
		return insuranceClaimRepo.findAll();
	}

}
