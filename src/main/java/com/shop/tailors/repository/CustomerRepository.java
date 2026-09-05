package com.shop.tailors.repository;

import com.shop.tailors.dto.CustomerDTO;
import com.shop.tailors.dto.CustomerDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.tailors.entity.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{


    @Query(value = "SELECT COUNT(*) FROM customers WHERE DATE(created_date) = CURRENT_DATE", nativeQuery = true)
    Long findTodaysCustomerCount();

    @Query(value = "SELECT * FROM customers WHERE balance > 0", nativeQuery = true)
    List<Customer> findCustomersWithBalance();

    @Query(value = "SELECT * FROM Customers WHERE mobile_number = :mobileNumber", nativeQuery = true)
    Optional<CustomerDTO> getCustomerByMobileNo(@Param("mobileNumber") Long mobileNumber);


    @Query(value = """
        SELECT 
            c.customer_id,
            c.customer_name,
            c.mobile_number,
            c.address,
            b.bill_number,
            b.delivery_date,
            b.total_amount,
            b.paid_amount,
            b.balance_amount,
            b.status    
        FROM customers c
        JOIN bills b 
            ON c.customer_id = b.customer_id
        WHERE b.delivery_date = :deliveryDate 
        """, nativeQuery = true)
    List<CustomerDetailsDTO> findCustomersByDeliveryDate(
            @Param("deliveryDate") LocalDate deliveryDate);
}
