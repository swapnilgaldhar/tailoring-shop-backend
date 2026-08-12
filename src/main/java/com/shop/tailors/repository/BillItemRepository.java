package com.shop.tailors.repository;

import com.shop.tailors.entity.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillItemRepository extends JpaRepository<BillItem, Long> {

    // Custom query methods can be defined here if needed
}
