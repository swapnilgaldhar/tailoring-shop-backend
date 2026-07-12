package com.shop.tailors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.tailors.entity.ShirtMeasurement;

@Repository
public interface ShirtMeasurementRepo extends JpaRepository<ShirtMeasurement, Integer> {

}
