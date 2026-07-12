package com.shop.tailors.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.shop.tailors.dto.MeasurementRequest;
import com.shop.tailors.entity.Customer;
import com.shop.tailors.entity.Measurement;
import com.shop.tailors.repository.CustomerRepository;
import com.shop.tailors.repository.MeasurementRepo;

class MeasurementServiceTest {

	@Test
	void createsLinkedShirtAndPantMeasurementsForCustomer() {
		CustomerRepository customerRepository = mock(CustomerRepository.class);
		MeasurementRepo measurementRepo = mock(MeasurementRepo.class);
		MeasurementService measurementService = new MeasurementService(measurementRepo, customerRepository);
		Customer customer = new Customer();
		MeasurementRequest request = createRequest();

		when(customerRepository.findById(7)).thenReturn(Optional.of(customer));
		when(measurementRepo.save(any(Measurement.class))).thenAnswer(invocation -> invocation.getArgument(0));

		Measurement measurement = measurementService.createMeasurementFromDto(request);

		assertSame(customer, measurement.getCustomer());
		assertEquals("Fitted jacket", measurement.getNotes());
		assertEquals(40.0, measurement.getShirtMeasurement().getChest());
		assertEquals(15.0, measurement.getShirtMeasurement().getNeck());
		assertSame(measurement, measurement.getShirtMeasurement().getMeasurement());
		assertEquals(42.0, measurement.getPantMeasurement().getWaist());
		assertEquals(39.0, measurement.getPantMeasurement().getLength());
		assertSame(measurement, measurement.getPantMeasurement().getMeasurement());
	}

	private MeasurementRequest createRequest() {
		MeasurementRequest request = new MeasurementRequest();
		request.setCustId(7);
		request.setNotes("Fitted jacket");

		MeasurementRequest.ShirtMeasurements shirt = new MeasurementRequest.ShirtMeasurements();
		shirt.setLength(30.0);
		shirt.setChest(40.0);
		shirt.setWaist(36.0);
		shirt.setHip(38.0);
		shirt.setShoulder(18.0);
		shirt.setSleeve(25.0);
		shirt.setNeck(15.0);
		shirt.setCuff(9.0);
		request.setShirtMeasurements(shirt);

		MeasurementRequest.PantMeasurements pant = new MeasurementRequest.PantMeasurements();
		pant.setLength(39.0);
		pant.setWaist(42.0);
		pant.setHip(44.0);
		pant.setThigh(26.0);
		pant.setKnee(18.0);
		pant.setCalf(16.0);
		pant.setBottom(14.0);
		request.setPantMeasurements(pant);
		return request;
	}
}
