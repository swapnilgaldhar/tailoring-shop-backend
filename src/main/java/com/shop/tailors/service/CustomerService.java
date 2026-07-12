package com.shop.tailors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.tailors.entity.Customer;


public interface CustomerService {

	Customer createUser(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerById( Integer id);

}
