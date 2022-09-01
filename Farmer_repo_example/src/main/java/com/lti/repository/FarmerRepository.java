package com.lti.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.entity.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer>{

	Farmer save(Farmer farmer);
	
	@Query(value = "select count(f.farmerId) from Farmer f where f.email = :email")
    int isFarmerPresent(String email);
	@Query(value = "select b from Farmer b where b.email = :email and b.password = :password")
    Farmer farmerLogin(String email, String password);
	
	Farmer getById(int id);
	List<Farmer> findAll();
	
}
