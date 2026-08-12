package com.shop.tailors.controller;

import com.shop.tailors.dto.PantMeasurementDTO;
import com.shop.tailors.dto.ShirtMeasurementDTO;
import com.shop.tailors.service.PantMeasurementService;
import com.shop.tailors.service.ShirtMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurement")
@CrossOrigin(origins = "http://localhost:5173")
public class MeasurementController {

	@Autowired
	private ShirtMeasurementService shirtMeasurementService;

	@Autowired
    private PantMeasurementService pantMeasurementService;



	@PostMapping("/create/shirt/measurement")
	public ResponseEntity<ShirtMeasurementDTO> createShirtMeasurement(@RequestBody ShirtMeasurementDTO shirtRequest) {
		try {
			ShirtMeasurementDTO savedMeasurement = shirtMeasurementService.saveShirtMeasurement(shirtRequest);
			return new ResponseEntity<>(savedMeasurement, HttpStatus.CREATED);
		} catch (java.util.NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/create/pant/measurement")
	public ResponseEntity<PantMeasurementDTO> createPantMeasurement(@RequestBody PantMeasurementDTO pantRequest) {
		try {
			PantMeasurementDTO savedMeasurement = pantMeasurementService.savePantMeasurement(pantRequest);
			return new ResponseEntity<>(savedMeasurement, HttpStatus.CREATED);
		} catch (java.util.NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/get/shirt/measurement/{id}")
	public ResponseEntity<ShirtMeasurementDTO> getShirtMeasurement(@PathVariable("id") Long customerId) {

		try {
			ShirtMeasurementDTO shirtMeasurement = shirtMeasurementService.getShirtMeasurement(customerId);
			return new ResponseEntity<>(shirtMeasurement, HttpStatus.OK);
		} catch (java.util.NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/get/pant/measurement/{id}")
	public ResponseEntity<PantMeasurementDTO> getPantMeasurement(@PathVariable("id") Long customerId) {

		try {
			PantMeasurementDTO pantMeasurement = pantMeasurementService.getPantMeasurement(customerId);
			return new ResponseEntity<>(pantMeasurement, HttpStatus.OK);
		} catch (java.util.NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}


}
