package com.jobiak.empapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobiak.empapi.Customer;
import com.jobiak.empapi.repository.MobileRepository;

@Service
public class MobileService {

	
	@Autowired
	MobileRepository repo;
	
	public Customer addCustomer(Customer mobile) {
		
		Customer ref=repo.save(mobile);
		return ref;
	}
	
	public Customer modifyCustomer(Customer mobile) {
		Customer ref=repo.save(mobile);
		return ref;
	}
	
	public void removeCustomer(Long mid) {
	   
		repo.deleteById(mid);
	}
	
	public List<Customer> getAll(){
		return repo.findAll();
	}
}
