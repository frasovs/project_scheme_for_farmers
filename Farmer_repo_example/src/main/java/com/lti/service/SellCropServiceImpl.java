package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.SellCrop;
import com.lti.repository.SellCropRepo;

@Service
public class SellCropServiceImpl implements SellCropService {

	@Autowired
	SellCropRepo sellCropRepo;

	@Override
	public List<SellCrop> history() {
		// TODO Auto-generated method stub
		return sellCropRepo.findAll();
	}

}
