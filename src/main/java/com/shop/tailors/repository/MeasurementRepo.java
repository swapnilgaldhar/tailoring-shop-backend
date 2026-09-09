package com.shop.tailors.repository;

import com.shop.tailors.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurement, Long> {

	// --- Shirt Queries ---
	@Query("SELECT MAX(m.shirtMeasurementNo) FROM Measurement m WHERE m.customer.customerId = :customerId")
	Integer findLatestShirtMeasurementNoByCustomerId(@Param("customerId") Long customerId);

	@Query("SELECT m FROM Measurement m WHERE m.customer.customerId = :customerId AND m.shirtMeasurementNo = :shirtMeasurementNo")
	Measurement findMeasurementByCustomerIdAndLatestShirtMeasurementNo(
			@Param("customerId") Long customerId,
			@Param("shirtMeasurementNo") Integer shirtMeasurementNo
	);

	// --- Sherwani Queries ---
	@Query("SELECT MAX(m.sherwaniMeasurementNo) FROM Measurement m WHERE m.customer.customerId = :customerId")
	Integer findLatestSherwaniMeasurementNoByCustomerId(@Param("customerId") Long customerId);

	@Query("SELECT m FROM Measurement m WHERE m.customer.customerId = :customerId AND m.sherwaniMeasurementNo = :sherwaniMeasurementNo")
	Measurement findMeasurementByCustomerIdAndLatestSherwaniMeasurementNo(
			@Param("customerId") Long customerId,
			@Param("sherwaniMeasurementNo") Integer sherwaniMeasurementNo
	);

	// --- Pant Queries ---
	@Query("SELECT MAX(m.pantMeasurementNo) FROM Measurement m WHERE m.customer.customerId = :customerId")
	Integer findLatestPantMeasurementNoByCustomerId(@Param("customerId") Long customerId);

	@Query("SELECT m FROM Measurement m WHERE m.customer.customerId = :customerId AND m.pantMeasurementNo = :pantMeasurementNo")
	Measurement findMeasurementByCustomerIdAndLatestPantMeasurementNo(
			@Param("customerId") Long customerId,
			@Param("pantMeasurementNo") Integer pantMeasurementNo
	);

	@Query("SELECT MAX(m.jacketMeasurementNo) FROM Measurement m WHERE m.customer.customerId = :customerId")
    Integer findLatestJacketMeasurementNoByCustomerId(@Param("customerId") Long customerId);

	@Query("SELECT m FROM Measurement m WHERE m.customer.customerId = :customerId AND m.jacketMeasurementNo = :latestJacketMeasurementNo")
	Measurement findMeasurementByCustomerIdAndLatestJacketMeasurementNo(@Param("customerId") Long customerid, @Param("latestJacketMeasurementNo") Integer latestJacketMeasurementNo);

	@Query("SELECT MAX(m.blazerMeasurementNo) FROM Measurement m WHERE m.customer.customerId = :customerId")
	Integer findLatestBlazerMeasurementNoByCustomerId(@Param("customerId") Long customerId);

	@Query("SELECT m FROM Measurement m WHERE m.customer.customerId = :customerId AND m.blazerMeasurementNo = :latestBlazerMeasurementNo")
	Measurement findMeasurementByCustomerIdAndLatestBlazerMeasurementNo(@Param("customerId") Long customerid, @Param("latestBlazerMeasurementNo") Integer latestBlazerMeasurementNo);
}
