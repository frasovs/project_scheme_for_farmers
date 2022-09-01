package com.lti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.entity.Bidder;
import com.lti.entity.Farmer;

@Repository
public interface BidderRepo extends JpaRepository<Bidder, Integer> {
 
	Bidder save(Bidder bidder);
	
	@Query(value = "select count(f.bidderId) from Bidder f where f.email = :email")
    int isBidderPresent(String email);
	@Query(value = "select b from Bidder b where b.email = :email and b.password = :password")
    Bidder bidderLogin(String email, String password);
	
	Bidder getById(int id);
	List<Bidder> findAll();
	
}
