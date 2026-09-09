package com.shop.tailors.service;

import java.time.LocalDate;
import java.util.List;

import com.shop.tailors.dto.CustomerDTO;
import com.shop.tailors.dto.CustomerDetailsDTO;
import org.springframework.stereotype.Service;

import com.shop.tailors.entity.Customer;


public interface CustomerService {



	List<CustomerDTO> getAllCustomers();

	CustomerDTO getCustomerById( Long id);

	Customer createCustomer(Customer customer);

    Long getCustomerCount();

    String updateCustomerBalance(Long customerId, Double newBalance);

	List<CustomerDTO> getCustomerWithBalance();

    CustomerDTO getCustomerByMobileNo(Long mobileNumber);

	List<CustomerDetailsDTO> getCustomerWithDeliveryDate(LocalDate deliveryDate);
}
