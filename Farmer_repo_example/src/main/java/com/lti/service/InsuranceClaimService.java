package com.lti.service;

import java.util.List;

import com.lti.entity.InsuranceClaim;

public interface InsuranceClaimService {

	void claimInsurance(InsuranceClaim claim);
	List<InsuranceClaim> viewAllClaim();
}
