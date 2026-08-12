package com.shop.tailors.repository;

import com.shop.tailors.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query(value = "SELECT SUM(total_amount) FROM bills WHERE DATE(bill_date) = CURRENT_DATE", nativeQuery = true)
    Double getTodaysSalesAmount();

    @Query(value = "SELECT SUM(total_amount) FROM bills WHERE MONTH(bill_date) = MONTH(CURRENT_DATE) AND YEAR(bill_date) = YEAR(CURRENT_DATE)", nativeQuery = true)
    Double getMonthlySalesAmount();

    @Query(value = "SELECT count(delivery_date) FROM bills WHERE DATE(delivery_date) = CURRENT_DATE", nativeQuery = true)
    Double getTodaysDeliveryAmount();

    @Query(value = "SELECT SUM(paid_amount) FROM bills WHERE DATE(bill_date) = CURRENT_DATE", nativeQuery = true)
    Double getTodaysCollectionAmount();

    @Query(value = "SELECT COUNT(*) FROM customers WHERE balance > 0", nativeQuery = true)
    Integer getCustomerCountWithBalence();
}
