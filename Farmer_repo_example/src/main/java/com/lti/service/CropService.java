package com.lti.service;

import java.util.List;

import com.lti.entity.Crop;


public interface CropService {
	Crop findById(int cropId);
	//public void updateCrop(Crop crop);
	void placeSellRequest(Crop crop);
	List<Crop> marketPlace();
}
