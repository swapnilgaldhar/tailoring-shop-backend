
package com.shop.tailors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.tailors.entity.PantMeasurement;


@Repository
public interface PantMeasurementRepo extends JpaRepository<PantMeasurement, Integer> {

}
