package com.shop.tailors.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import com.shop.tailors.dto.CustomerDetailsDTO;
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
	//create customer
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}

    //get customer with id
	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
		Customer oneCustomer = customerService.getCustomerById(id);
		return new ResponseEntity<>(oneCustomer, HttpStatus.OK);
	}

    //get customer with mobile number
	@GetMapping("/getcustomer/withmobileno/{mobileNumber}")
	public ResponseEntity<Customer> getCustomerByMobileNo(@PathVariable Long mobileNumber){
		Customer oneCustomer = customerService.getCustomerByMobileNo(mobileNumber);
		return new ResponseEntity<>(oneCustomer, HttpStatus.OK);
	}

    //get all customer
	@GetMapping("/getallcustomer")
	public List<Customer> getAllCustomers(){
		List<Customer> allCustomers = customerService.getAllCustomers();
		return allCustomers;
	}

    //get customer count
	@GetMapping("/getCustomerCount")
	public ResponseEntity<Long> getCustomerCount() {
	    Long customerCount = customerService.getCustomerCount();
	    return new ResponseEntity<>(customerCount, HttpStatus.OK);
	}

    //update balence
    @PutMapping("/update/balence/{customerId}/{newBalance}")
    public ResponseEntity<Customer> updateCustomerBalance(@PathVariable Long customerId, @PathVariable Double newBalance) {
        Customer updatedCustomer = customerService.updateCustomerBalance(customerId, newBalance);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    //get customer with balance
    @GetMapping("/getcustomer/withbalance")
    public ResponseEntity<List<Customer>> getCustomerWithBalence(){
		//withdraw
        List<Customer> customersWithBalence = customerService.getCustomerWithBalance();
        return new ResponseEntity<>(customersWithBalence, HttpStatus.OK);
    }

	//get customer with delivery date
	@GetMapping("/getCustomerwithdeliverydate/{deliveryDate}")
	public ResponseEntity<List<CustomerDetailsDTO>> getCustomerWithDeliveryDate(@PathVariable("deliveryDate") LocalDate deliveryDate) {
		List<CustomerDetailsDTO> customersDetails = customerService.getCustomerWithDeliveryDate(deliveryDate);
		return new ResponseEntity<>(customersDetails, HttpStatus.OK);
	}

}
