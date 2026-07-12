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
	public Customer createUser(Customer customer) {
		// TODO Auto-generated method stub
		
		Customer newCustomer =  customerRepository.save(customer);
		
		return newCustomer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> allCustomers =  customerRepository.findAll();
		return allCustomers;
	}

	@Override
    public Customer getCustomerById(Integer id) {

        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            return customer.get();
        }

        throw new RuntimeException("Customer not found with Id : " + id);
    }



}
