package com.lti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.SellCrop;

@Repository
public interface SellCropRepo extends JpaRepository<SellCrop, Integer> {

	List<SellCrop> findAll();
}
