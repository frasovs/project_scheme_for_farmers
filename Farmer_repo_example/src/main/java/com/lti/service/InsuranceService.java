package com.lti.service;

import java.util.List;

import com.lti.entity.Insurance;

public interface InsuranceService {
	Insurance findById(int id); 
	void applyInsurance(Insurance insurance);
	List<Insurance> viewAllInsurance();
}
