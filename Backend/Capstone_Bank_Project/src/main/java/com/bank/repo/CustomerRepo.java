package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bank.model.Customer_Details;

@Repository
public interface CustomerRepo extends JpaRepository<Customer_Details, Integer>{
	
	Customer_Details findByuserName(String username);

}
