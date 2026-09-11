package com.shop.tailors.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import com.shop.tailors.dto.CustomerDTO;
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
//@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	//create customer
	@PostMapping("/create")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return new ResponseEntity<>("Customer created successfully", HttpStatus.CREATED);
	}

    //get customer with id
	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
		CustomerDTO oneCustomer = customerService.	getCustomerById(id);
		return new ResponseEntity<>(oneCustomer, HttpStatus.OK);
	}

    //get customer with mobile number
	@GetMapping("/getcustomer/withmobileno/{mobileNumber}")
	public ResponseEntity<CustomerDTO> getCustomerByMobileNo(@PathVariable Long mobileNumber){
		CustomerDTO oneCustomer = customerService.getCustomerByMobileNo(mobileNumber);
		return new ResponseEntity<>(oneCustomer, HttpStatus.OK);
	}

    //get all customer
	@GetMapping("/getallcustomer")
	public List<CustomerDTO> getAllCustomers(){
		List<CustomerDTO> allCustomers = customerService.getAllCustomers();
		return allCustomers;
	}

    //get customer count created today //todays new customer
	@GetMapping("/getCustomerCount")
	public ResponseEntity<Long> getCustomerCount() {
	    Long customerCount = customerService.getCustomerCount();
	    return new ResponseEntity<>(customerCount, HttpStatus.OK);
	}

    //update balence
    @PutMapping("/update/balence/{customerId}/{newBalance}")
    public ResponseEntity<String> updateCustomerBalance(@PathVariable Long customerId, @PathVariable Double newBalance) {
        customerService.updateCustomerBalance(customerId, newBalance);
        return new ResponseEntity<>("Customer balance updated successfully", HttpStatus.OK);
    }

    //get customer with balance
    @GetMapping("/getcustomer/withbalance")
    public ResponseEntity<List<CustomerDTO>> getCustomerWithBalence(){
		//withdraw
        List<CustomerDTO> customersWithBalence = customerService.getCustomerWithBalance();
        return new ResponseEntity<>(customersWithBalence, HttpStatus.OK);
    }

	//get customer with delivery date
	@GetMapping("/getCustomerwithdeliverydate/{deliveryDate}")
	public ResponseEntity<List<CustomerDetailsDTO>> getCustomerWithDeliveryDate(@PathVariable("deliveryDate") LocalDate deliveryDate) {
		List<CustomerDetailsDTO> customersDetails = customerService.getCustomerWithDeliveryDate(deliveryDate);
		return new ResponseEntity<>(customersDetails, HttpStatus.OK);
	}

}
