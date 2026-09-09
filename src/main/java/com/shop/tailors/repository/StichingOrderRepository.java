package com.shop.tailors.repository;

import com.shop.tailors.dto.StichingDetailsDTO;
import com.shop.tailors.entity.StichingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StichingOrderRepository extends JpaRepository<StichingOrder,Long> {

    @Query(value = "SELECT\n" +
            "        b.bill_date,\n" +
            "        c.customer_id,\n" +
            "        c.customer_name,\n" +
            "        b.delivery_date,\n" +
            "        b.notes\n" +
            "    FROM customers c\n" +
            "    JOIN bills b ON c.customer_id = b.customer_id\n" +
            "    WHERE b.bill_number = :billNo", nativeQuery = true)
    StichingDetailsDTO findByBillNo(String billNo);

    @Query(value = "SELECT * FROM stiching_order WHERE bill_No = :billNo", nativeQuery = true)
    StichingOrder findByBillNumber(String billNo);
}
