package com.shop.tailors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.tailors.entity.Customer;
import com.shop.tailors.service.CustomerService;


@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
		Customer oneCustomer = customerService.getCustomerById(id);
		return new ResponseEntity<>(oneCustomer, HttpStatus.OK);
	}
	
	@GetMapping("/getallcustomer")
	public List<Customer> getAllCustomers(){
		List<Customer> allCustomers = customerService.getAllCustomers();
		return allCustomers;
	}

}
