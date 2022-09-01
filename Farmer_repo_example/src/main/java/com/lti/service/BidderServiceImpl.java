package com.lti.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Bidder;
import com.lti.entity.Crop;
import com.lti.entity.Farmer;
import com.lti.entity.SellCrop;
import com.lti.exception.FarmerServiceException;
import com.lti.repository.BidderRepo;
import com.lti.repository.CropRepository;
import com.lti.repository.SellCropRepo;

@Service
public class BidderServiceImpl implements BidderService {

	@PersistenceContext
	EntityManager em;

	@Autowired
	BidderRepo bidderRepo;

	@Autowired
	CropRepository cropRepo;
	
	@Autowired
	SellCropRepo sellCropRepo;

	@Override
	public void register(Bidder bidder) {
		if (bidderRepo.isBidderPresent(bidder.getEmail()) == 0) {
			Bidder b = bidderRepo.save(bidder);
		} else
			throw new FarmerServiceException("Farmer already registered!");
	}

	@Override
	public Bidder login(String email, String password) {
		try {
			if (bidderRepo.isBidderPresent(email) == 0)
				throw new FarmerServiceException("Farmer not registered!");
			return bidderRepo.bidderLogin(email, password);

		} catch (EmptyResultDataAccessException e) {
			throw new FarmerServiceException("Incorrect email/password");
		}
	}

	@Override
	public List<Bidder> viewAllUsers() {
		// TODO Auto-generated method stub
		return bidderRepo.findAll();
	}

	@Override
	public void placeBid(Crop crop) {
		// TODO Auto-generated method stub
		cropRepo.save(crop);
	}

	@Override
	public Bidder findById(int bidderId) {
		// TODO Auto-generated method stub
		return bidderRepo.getById(bidderId);
	}

	@Override
	public void bidApprove(Crop crop) {

	Crop c1 = cropRepo.save(crop);
		 
		if(crop.isStatus() == true)
		{
			SellCrop s = new SellCrop();
			s.setBidder(crop.getBidder());
			s.setBidprice(crop.getBaseprice());
			s.setCrop(crop);
			s.setFarmer(crop.getFarmer());
			s.setSold(true);
			sellCropRepo.save(s);
		}
	}

}
