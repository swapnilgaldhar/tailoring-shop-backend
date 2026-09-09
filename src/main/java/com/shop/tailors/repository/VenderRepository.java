package com.shop.tailors.repository;

import com.shop.tailors.entity.Vender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenderRepository extends JpaRepository<Vender,Long> {
    Vender findByVenderId(Long venderId);
}
