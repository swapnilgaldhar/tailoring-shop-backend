package com.shop.tailors.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.shop.tailors.dto.CustomerDTO;
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
	public String updateCustomerBalance(Long customerId, Double newBalance) {

		Optional<Customer> customerOptional = customerRepository.findById(customerId);



		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			Double prevBalence = customer.getBalance();
			if((newBalance > prevBalence ) ||  (newBalance < 0)) {
				throw new RuntimeException("Invalid balance update. Previous balance: " + prevBalence + ", New balance: " + newBalance);
			}
			Double updatedBalance = prevBalence - newBalance;
			customer.setBalance(updatedBalance);

			customer.setLastUpdateDate(LocalDate.now());
			customerRepository.save(customer);
			return "Customer balance updated successfully";
		} else {
			throw new RuntimeException("Customer not found with Id : " + customerId);
		}
	}

	@Override
	public List<CustomerDTO> getCustomerWithBalance() {
		return customerRepository.findCustomersWithBalance().stream().map(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setMobileNumber(customer.getMobileNumber());
			customerDTO.setAddress(customer.getAddress());
			customerDTO.setBalance(customer.getBalance());
			customerDTO.setCreatedDate(customer.getCreatedDate());
			customerDTO.setLastUpdateDate(customer.getLastUpdateDate());
			return customerDTO;
		}).toList();
	}

	@Override
	public CustomerDTO getCustomerByMobileNo(Long mobileNumber) {
		Optional<CustomerDTO> customer = customerRepository.getCustomerByMobileNo(mobileNumber);

		if (customer.isPresent()) {
			return customer.get();
		}

		throw new RuntimeException("Customer not found with MobileNumber : " + mobileNumber);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {

		List<Customer> allCustomers =  customerRepository.findAll();
		return allCustomers.stream().map(customer -> {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setMobileNumber(customer.getMobileNumber());
			customerDTO.setAddress(customer.getAddress());
			customerDTO.setBalance(customer.getBalance());
			customerDTO.setCreatedDate(customer.getCreatedDate());
			customerDTO.setLastUpdateDate(customer.getLastUpdateDate());
			return customerDTO;
		}).toList();
	}

	@Override
    public CustomerDTO getCustomerById(Long customerId) {

        Optional<Customer> customer = Optional.of(customerRepository.findById(customerId).
                orElseThrow(() -> new CustomerNotFoundException("Customer not found with Id : " + customerId)));

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.get().getCustomerId());
        customerDTO.setCustomerName(customer.get().getCustomerName());
        customerDTO.setMobileNumber(customer.get().getMobileNumber());
        customerDTO.setAddress(customer.get().getAddress());
        customerDTO.setBalance(customer.get().getBalance());
        customerDTO.setCreatedDate(customer.get().getCreatedDate());
        customerDTO.setLastUpdateDate(customer.get().getLastUpdateDate());

        return customerDTO;
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
