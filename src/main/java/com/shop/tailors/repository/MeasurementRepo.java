package com.shop.tailors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.tailors.entity.Measurement;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurement, Integer> {

	Measurement save(Measurement measurement);

}
