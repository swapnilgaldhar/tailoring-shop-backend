package com.shop.tailors.repository;

import com.shop.tailors.entity.JacketMeasurement;
import com.shop.tailors.service.JacketMeasurementService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JacketMeasurementRepo  extends JpaRepository<JacketMeasurement, Integer> {

    @Query("SELECT jm FROM JacketMeasurement jm WHERE jm.measurement.measurementId = :measurementId")
    JacketMeasurement getJacketMeasurementLatestMeasurementNo(Long measurementId);
}
