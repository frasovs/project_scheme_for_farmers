package com.lti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Crop;

@Repository
public interface CropRepository extends JpaRepository<Crop, Integer>{
	Crop getById(int cropId);
	//public void updateCrop(Crop crop);
	//void placeSellRequest(Crop crop);
	Crop save(Crop crop);
	//List<Crop> viewAllCrops();
	List<Crop> findAll();
}
