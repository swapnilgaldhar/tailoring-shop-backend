package com.shop.tailors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.tailors.entity.ShirtMeasurement;

import java.util.Optional;

@Repository
public interface ShirtMeasurementRepo extends JpaRepository<ShirtMeasurement, Integer> {

    @Query("SELECT sm FROM ShirtMeasurement sm WHERE sm.measurement.measurementId = :measurementId")
    ShirtMeasurement getShirtMeasurementLatestShirtMeasurementNo(Long measurementId);
}
