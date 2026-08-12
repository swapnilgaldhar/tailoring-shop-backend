package com.shop.tailors.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.tailors.entity.Customer;
import com.shop.tailors.repository.CustomerRepository;
import com.shop.tailors.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {

		Customer newCustomer =  customerRepository.save(customer);
		
		return newCustomer;
	}

	@Override
	public Long getCustomerCount() {
		Long customerCount = customerRepository.findTodaysCustomerCount();
		return customerCount;
	}

	@Override
	public Customer updateCustomerBalance(Long customerId, Double newBalance) {

		Optional<Customer> customerOptional = customerRepository.findById(customerId);

		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			customer.setBalance(newBalance);
			return customerRepository.save(customer);
		} else {
			throw new RuntimeException("Customer not found with Id : " + customerId);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> allCustomers =  customerRepository.findAll();
		return allCustomers;
	}

	@Override
    public Customer getCustomerById(Long customerId) {

        Optional<Customer> customer = customerRepository.findById(customerId);

        if (customer.isPresent()) {
            return customer.get();
        }

        throw new RuntimeException("Customer not found with Id : " + customerId);
    }



}
