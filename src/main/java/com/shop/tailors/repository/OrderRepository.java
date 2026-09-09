package com.shop.tailors.repository;

import com.shop.tailors.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.vender.venderId = :venderId")
    List<Order> findByVenderId(Long venderId);

    //  List<Order> findByVenderId(Long venderId);
}
