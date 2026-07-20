
package com.shop.tailors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.tailors.entity.PantMeasurement;

import java.util.Optional;


@Repository
public interface PantMeasurementRepo extends JpaRepository<PantMeasurement, Integer> {


    @Query("SELECT pm FROM PantMeasurement pm WHERE pm.measurement.measurementId = :measurementId")
    PantMeasurement getPantMeasurementLatestPantMeasurementNo(Long measurementId);
}
