package com.shop.tailors.repository;

import com.shop.tailors.entity.BlazerMeasurement;
import com.shop.tailors.entity.ShirtMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BlazerMeasurementRepository extends JpaRepository<BlazerMeasurement, Integer> {


    @Query("SELECT pm FROM BlazerMeasurement pm WHERE pm.measurement.measurementId = :measurementId")
    BlazerMeasurement getBlazerMeasurementLatestBlazerMeasurementNo(Long measurementId);

}
