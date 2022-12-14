package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Crop;
import com.lti.repository.CropRepository;

@Service
public class CropServiceImpl implements CropService {

	@Autowired
	private CropRepository cropRepo;

//	@Override
//	public void updateCrop(Crop crop) {
//		cropRepo.updateCrop(crop);
//	}

	@Override
	public Crop findById(int cropId) {
		return cropRepo.getById(cropId);
	}

	@Override
	public void placeSellRequest(Crop crop) {
		// TODO Auto-generated method stub
		cropRepo.save(crop);

	}

	@Override
	public List<Crop> marketPlace() {
		// TODO Auto-generated method stub
		return cropRepo.findAll();
	}

}
