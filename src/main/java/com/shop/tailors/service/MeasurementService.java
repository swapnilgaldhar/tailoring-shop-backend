package com.shop.tailors.service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.tailors.dto.MeasurementRequest;
import com.shop.tailors.entity.Customer;
import com.shop.tailors.entity.Measurement;
import com.shop.tailors.entity.PantMeasurement;
import com.shop.tailors.entity.ShirtMeasurement;
import com.shop.tailors.repository.CustomerRepository;
import com.shop.tailors.repository.MeasurementRepo;

@Service
public class MeasurementService {
	private final MeasurementRepo measurementRepo;
	private final CustomerRepository customerRepository;

	public MeasurementService(MeasurementRepo measurementRepo, CustomerRepository customerRepository) {
		this.measurementRepo = measurementRepo;
		this.customerRepository = customerRepository;
	}

	@Transactional
	public Measurement createMeasurementFromDto(MeasurementRequest request) {
		if (request == null || request.getCustId() == null) {
			throw new IllegalArgumentException("custId is required");
		}
		if (request.getShirtMeasurements() == null && request.getPantMeasurements() == null) {
			throw new IllegalArgumentException("At least one shirtMeasurements or pantMeasurements object is required");
		}

		Customer customer = customerRepository.findById(request.getCustId())
				.orElseThrow(() -> new NoSuchElementException("Customer not found"));

		Measurement measurement = new Measurement();
		measurement.setCustomer(customer);
		measurement.setMeasurementDate(LocalDate.now());
		measurement.setNotes(request.getNotes());

		if (request.getShirtMeasurements() != null) {
			addShirtMeasurement(request.getShirtMeasurements(), measurement);
		}
		if (request.getPantMeasurements() != null) {
			addPantMeasurement(request.getPantMeasurements(), measurement);
		}

		return measurementRepo.save(measurement);
	}

	private void addShirtMeasurement(MeasurementRequest.ShirtMeasurements source, Measurement measurement) {
		ShirtMeasurement shirtMeasurement = new ShirtMeasurement();
		shirtMeasurement.setLength(source.getLength());
		shirtMeasurement.setChest(source.getChest());
		shirtMeasurement.setWaist(source.getWaist());
		shirtMeasurement.setHip(source.getHip());
		shirtMeasurement.setShoulder(source.getShoulder());
		shirtMeasurement.setSleeve(source.getSleeve());
		shirtMeasurement.setNeck(source.getNeck());
		shirtMeasurement.setCuff(source.getCuff());
		shirtMeasurement.setMeasurement(measurement);
		measurement.setShirtMeasurement(shirtMeasurement);
	}

	private void addPantMeasurement(MeasurementRequest.PantMeasurements source, Measurement measurement) {
		PantMeasurement pantMeasurement = new PantMeasurement();
		pantMeasurement.setLength(source.getLength());
		pantMeasurement.setWaist(source.getWaist());
		pantMeasurement.setHip(source.getHip());
		pantMeasurement.setThigh(source.getThigh());
		pantMeasurement.setKnee(source.getKnee());
		pantMeasurement.setCalf(source.getCalf());
		pantMeasurement.setBottom(source.getBottom());
		pantMeasurement.setMeasurement(measurement);
		measurement.setPantMeasurement(pantMeasurement);
	}

	// ✅ ADDED - GREEN START
	@Transactional(readOnly = true)
	public Measurement getMeasurementById(Integer id) {
		Measurement measurement = measurementRepo.findById(id)
				.orElseThrow(() -> new java.util.NoSuchElementException("Measurement not found"));
		// initialize lazy associations while transaction is active
		if (measurement.getShirtMeasurement() != null) {
			measurement.getShirtMeasurement().getId();
		}
		if (measurement.getPantMeasurement() != null) {
			measurement.getPantMeasurement().getId();
		}
		if (measurement.getCustomer() != null) {
			measurement.getCustomer().getCustomerId();
		}
		return measurement;
	}
	// ✅ ADDED - GREEN END
}
