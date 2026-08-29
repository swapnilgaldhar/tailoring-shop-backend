package com.shop.tailors.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.tailors.entity.Measurement;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurement, Long> {
	@EntityGraph(attributePaths = {"pantMeasurement", "shirtMeasurement"})

	@Query("SELECT COALESCE(MAX(m.pantMeasurementNo), 0) FROM Measurement m WHERE m.customer.customerId = :customerId")
	Integer findLatestPantMeasurementNoByCustomerId(Long customerId);

	@Query("SELECT m FROM Measurement m WHERE m.customer.customerId = :customerId AND m.pantMeasurementNo = :latestPantMeasurementNo")
	Measurement findMeasurementByCustomerIdAndLatestPantMeasurementNo(Long customerId, Integer latestPantMeasurementNo);

	@Query("SELECT COALESCE(MAX(m.shirtMeasurementNo), 0) FROM Measurement m WHERE m.customer.customerId = :customerId")
	Integer findLatestShirtMeasurementNoByCustomerId(Long customerId);

	@Query("SELECT m FROM Measurement m WHERE m.customer.customerId = :customerId AND m.shirtMeasurementNo = :latestShirtMeasurementNo")
	Measurement findMeasurementByCustomerIdAndLatestShirtMeasurementNo(Long customerId, Integer latestShirtMeasurementNo);

	@Query("SELECT COALESCE(MAX(m.jacketMeasurementNo), 0) FROM Measurement m WHERE m.customer.customerId = :customerId")
	Integer findLatestJacketMeasurementNoByCustomerId(Long customerId);

	@Query("SELECT COALESCE(MAX(m.blazerMeasurementNo), 0) FROM Measurement m WHERE m.customer.customerId = :customerId")
    Integer findLatestBlazerMeasurementNoByCustomerId(Long customerId);

	@Query("SELECT m FROM Measurement m WHERE m.customer.customerId = :customerId AND m.jacketMeasurementNo = :latestJacketMeasurementNo")
	Measurement findMeasurementByCustomerIdAndLatestJacketMeasurementNo(Long customerId, Integer latestJacketMeasurementNo);

	@Query("SELECT m FROM Measurement m WHERE m.customer.customerId = :customerId AND m.blazerMeasurementNo = :latestBlazerMeasurementNo")
	Measurement findMeasurementByCustomerIdAndLatestBlazerMeasurementNo(Long customerId, Integer latestBlazerMeasurementNo);
}
