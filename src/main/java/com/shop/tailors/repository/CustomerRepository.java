package com.shop.tailors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.tailors.entity.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{


    @Query(value = "SELECT COUNT(*) FROM customers WHERE DATE(created_date) = CURRENT_DATE", nativeQuery = true)
    Long findTodaysCustomerCount();

}
