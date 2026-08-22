package com.shop.tailors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.tailors.entity.Customer;


public interface CustomerService {



	List<Customer> getAllCustomers();

	Customer getCustomerById( Long id);

	Customer createCustomer(Customer customer);

    Long getCustomerCount();

    Customer updateCustomerBalance(Long customerId, Double newBalance);

	List<Customer> getCustomerWithBalance();
}
