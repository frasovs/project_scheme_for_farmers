package com.lti.service;

import java.util.List;

import com.lti.entity.Farmer;

public interface FarmerService {
	
	void register(Farmer farmer);
	Farmer farmerLogin(String email,String password );
	List<Farmer> viewAllUsers();
	Farmer findById(int farmerId);
}
