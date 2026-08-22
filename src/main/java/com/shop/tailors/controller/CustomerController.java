package com.shop.tailors.controller;

import java.util.List;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/getCustomerCount")
	public ResponseEntity<Long> getCustomerCount() {
	    Long customerCount = customerService.getCustomerCount();
	    return new ResponseEntity<>(customerCount, HttpStatus.OK);
	}

    @PutMapping("/update/balence/{customerId}/{newBalance}")
    public ResponseEntity<Customer> updateCustomerBalance(@PathVariable Long customerId, @PathVariable Double newBalance) {
        Customer updatedCustomer = customerService.updateCustomerBalance(customerId, newBalance);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    //needs to implement in UI
    @GetMapping("/getcustomer/withbalance")
    public ResponseEntity<List<Customer>> getCustomerWithBalence(){
        List<Customer> customersWithBalence = customerService.getCustomerWithBalance();
        return new ResponseEntity<>(customersWithBalence, HttpStatus.OK);
    }

}
