package com.lti.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.lti.entity.Farmer;
import com.lti.exception.FarmerServiceException;
import com.lti.repository.FarmerRepository;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FarmerRepository farmerRepo;

	@Override
	public void register(Farmer farmer) {
		if (farmerRepo.isFarmerPresent(farmer.getEmail()) == 0) {
			Farmer f = farmerRepo.save(farmer);
		} else
			throw new FarmerServiceException("Farmer already registered!");
	}

	@Override
	public Farmer farmerLogin(String email, String password) {
		try {
			if (farmerRepo.isFarmerPresent(email) == 0)
				throw new FarmerServiceException("Farmer not registered!");
			return farmerRepo.farmerLogin(email, password);

		} catch (EmptyResultDataAccessException e) {
			throw new FarmerServiceException("Incorrect email/password");
		}
	}

	@Override
	public List<Farmer> viewAllUsers() {
		return farmerRepo.findAll();
	}

	@Override
	public Farmer findById(int farmerId) {
		// TODO Auto-generated method stub
		return farmerRepo.getById(farmerId);
	}

}
