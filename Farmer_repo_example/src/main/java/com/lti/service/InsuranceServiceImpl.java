package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Insurance;
import com.lti.repository.InsuranceRepo;
@Service
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	private InsuranceRepo insuranceRepo;
	@Override
	public Insurance findById(int id) {
		return insuranceRepo.getById(id);
	}
	@Override
	public void applyInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		Insurance i = insuranceRepo.save(insurance);
		
	}
	@Override
	public List<Insurance> viewAllInsurance() {
		// TODO Auto-generated method stub
		return insuranceRepo.findAll();
	}

}
