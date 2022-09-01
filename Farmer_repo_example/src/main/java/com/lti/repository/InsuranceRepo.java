package com.lti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Insurance;

@Repository
public interface InsuranceRepo extends JpaRepository<Insurance, Integer> {
	Insurance getById(int id); 
	List<Insurance> findAll();
	Insurance save(Insurance insurance);
}
