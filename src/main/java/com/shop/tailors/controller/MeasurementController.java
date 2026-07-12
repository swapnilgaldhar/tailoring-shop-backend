package com.shop.tailors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.tailors.dto.MeasurementRequest;

import com.shop.tailors.entity.Measurement;
import com.shop.tailors.service.MeasurementService;

@RestController
@RequestMapping("/measurement")
@CrossOrigin()
public class MeasurementController {

	@Autowired
	private MeasurementService measurementService;

	@PostMapping("/create/measurement")
	public ResponseEntity<Measurement> createMeasurement(@RequestBody MeasurementRequest request) {
		try {
			Measurement newMeasurement = measurementService.createMeasurementFromDto(request);
			return new ResponseEntity<>(newMeasurement, HttpStatus.CREATED);
		} catch (java.util.NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Measurement> getMeasurementById(@PathVariable Integer id) {
		try {
			Measurement measurement = measurementService.getMeasurementById(id);
			return new ResponseEntity<>(measurement, HttpStatus.OK);
		} catch (java.util.NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// ✅ ADDED - GREEN START
	@GetMapping("/{id}")
	public ResponseEntity<Measurement> getMeasurementById(@PathVariable Integer id) {
		try {
			Measurement measurement = measurementService.getMeasurementById(id);
			return new ResponseEntity<>(measurement, HttpStatus.OK);
		} catch (java.util.NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	// ✅ ADDED - GREEN END
}
