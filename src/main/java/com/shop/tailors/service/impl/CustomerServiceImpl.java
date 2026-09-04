package com.shop.tailors.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.shop.tailors.dto.CustomerDetailsDTO;
import com.shop.tailors.exceptions.CustomerNotFoundException;
import com.shop.tailors.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.tailors.entity.Customer;
import com.shop.tailors.repository.CustomerRepository;
import com.shop.tailors.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BillRepository billRepository;

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
			Double prevBalence = customer.getBalance();
			Double updatedBalance = prevBalence - newBalance;
			customer.setBalance(updatedBalance);

			customer.setLastUpdateDate(LocalDate.now());
			return customerRepository.save(customer);
		} else {
			throw new RuntimeException("Customer not found with Id : " + customerId);
		}
	}

	@Override
	public List<Customer> getCustomerWithBalance() {
		return customerRepository.findCustomersWithBalance();
	}

	@Override
	public Customer getCustomerByMobileNo(Long mobileNumber) {
		Optional<Customer> customer = Optional.ofNullable(customerRepository.getCustomerByMobileNo(mobileNumber));

		if (customer.isPresent()) {
			return customer.get();
		}

		throw new RuntimeException("Customer not found with MobileNumber : " + mobileNumber);
	}

	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> allCustomers =  customerRepository.findAll();
		return allCustomers;
	}

	@Override
    public Customer getCustomerById(Long customerId) {

        Optional<Customer> customer = Optional.of(customerRepository.findById(customerId).
                orElseThrow(() -> new CustomerNotFoundException("Customer not found with Id : " + customerId)));

        return customer.get();
    }

	@Override
	public List<CustomerDetailsDTO> getCustomerWithDeliveryDate(LocalDate deliveryDate) {

		List<CustomerDetailsDTO> customersWithDeleverydate = customerRepository.findCustomersByDeliveryDate(deliveryDate);
		// Convert List<Customer> to List<CustomerDetailsDTO>
		List<CustomerDetailsDTO> customersDetails = customersWithDeleverydate.stream().map(customer -> {
			CustomerDetailsDTO customerDetailsDTO = new CustomerDetailsDTO();
			customerDetailsDTO.setCustomerId(customer.getCustomerId());
			customerDetailsDTO.setCustomerName(customer.getCustomerName());
			customerDetailsDTO.setMobileNumber(customer.getMobileNumber());
			customerDetailsDTO.setAddress(customer.getAddress());
			customerDetailsDTO.setBillNumber(customer.getBillNumber());
			customerDetailsDTO.setDeliveryDate(customer.getDeliveryDate());
			customerDetailsDTO.setTotalAmount(customer.getTotalAmount());
			customerDetailsDTO.setPaidAmount(customer.getPaidAmount());
			customerDetailsDTO.setBalanceAmount(customer.getBalanceAmount());
            customerDetailsDTO.setStatus(customer.getStatus());

			return customerDetailsDTO;
		}).toList();

		return customersDetails;
	}



}
