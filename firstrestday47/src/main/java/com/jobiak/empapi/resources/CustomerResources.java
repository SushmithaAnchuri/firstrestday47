package com.jobiak.empapi.resources;

import org.springframework.web.bind.annotation.RequestMapping;	
import org.springframework.web.bind.annotation.RestController;

import com.jobiak.empapi.Customer;
import com.jobiak.empapi.service.MobileService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

	@CrossOrigin("http://localhost:4200")
	@RestController
	@RequestMapping("/customer")
	public class CustomerResources {
		
		@Autowired
		MobileService service;
		@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
		@GetMapping(value="/display",produces= MediaType.APPLICATION_JSON_VALUE)
		public List<Customer>showAll(){
			System.out.println("Received......");
			return service.getAll();
		}
		
		@GetMapping(value="/show", produces= MediaType.APPLICATION_JSON_VALUE)
		public Customer showCatalog() {
			Customer customer = new Customer();
			customer.setId(101L);
			customer.setName("Meghana");
			customer.setBalance(23412);
			return customer;
		}
		
		@GetMapping("/intro")
		public String introduction() {
			return new String("The APIs for Customer Relationships");
		}
		
		@GetMapping("/search/{custId}")
		public String searchModel(@PathVariable(value="custId")String custId) {
			return new String(custId + " is available only in Blue and black colors, can be deliver in 24 hours ");
		}

		@GetMapping("/search/{custId}/brand/{brand}")
		public String searchModel(@PathVariable(value="modelId")String custId,@PathVariable(value="brand")String brand) {
			return new String(custId+brand+"Currently not available for your location");
		}
		@PostMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE)
		public Customer addCustomer(@RequestBody Customer customer) {
			//System.out.println(mobile);
			Customer ref =service.addCustomer(customer);
			return ref;
		}
		
		@PutMapping(value="/modify",consumes = MediaType.APPLICATION_JSON_VALUE,produces= MediaType.APPLICATION_JSON_VALUE)
		public Customer modifyCustomer(@RequestBody Customer customer) {
			Customer ref =service.modifyCustomer(customer);
			return ref;
		}
		/*
		 * @DeleteMapping(value="/remove/{custId}") public void
		 * removeCustomer(@PathVariable(value="remove")Long custId) {
		 * service.removeCustomer(custId); }
		 */
		
}
