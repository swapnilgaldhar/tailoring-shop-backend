package com.shop.tailors.service.impl;

import com.shop.tailors.dto.SherwaniMeasurementDTO;
import com.shop.tailors.entity.Customer;
import com.shop.tailors.entity.Measurement;
import com.shop.tailors.entity.SherwaniMeasurement;
import com.shop.tailors.repository.CustomerRepository;
import com.shop.tailors.repository.MeasurementRepo;
import com.shop.tailors.repository.SherwaniMeasurementRepository;
import com.shop.tailors.service.SherwaniMeasurementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class SherwaniMeasurementServiceImpl implements SherwaniMeasurementService {

    @Autowired
    private MeasurementRepo measurementRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SherwaniMeasurementRepository sherwaniMeasurementRepository;

    @Override
    @Transactional
    public SherwaniMeasurementDTO createSherwaniMeasurement(SherwaniMeasurementDTO sherwaniRequest) {
        Customer customer = customerRepository.findById(sherwaniRequest.getCustomerId())
                .orElseThrow(() -> new NoSuchElementException("Customer not found with ID: " + sherwaniRequest.getCustomerId()));

        Measurement measurement = new Measurement();
        measurement.setCustomer(customer);
        measurement.setCreatedDate(LocalDate.now());

        Integer existingSherwaniMeasurement = getExistingSherwaniMeasurement(customer.getCustomerId());
        log.info("Existing sherwani measurement number for customer {}: {}", customer.getCustomerId(), existingSherwaniMeasurement);
        measurement.setSherwaniMeasurementNo(existingSherwaniMeasurement != null ? existingSherwaniMeasurement + 1 : 1);

        measurementRepository.save(measurement);

        SherwaniMeasurement sherwaniMeasurement = new SherwaniMeasurement();
        sherwaniMeasurement.setMeasurement(measurement);
        sherwaniMeasurement.setChest(sherwaniRequest.getChest());
        sherwaniMeasurement.setWaist(sherwaniRequest.getWaist());
        sherwaniMeasurement.setHip(sherwaniRequest.getHip());
        sherwaniMeasurement.setShoulder(sherwaniRequest.getShoulder());
        sherwaniMeasurement.setSleeve(sherwaniRequest.getSleeve());
        sherwaniMeasurement.setLength(sherwaniRequest.getLength());
        sherwaniMeasurement.setNeck(sherwaniRequest.getNeck());
        sherwaniMeasurement.setCuff(sherwaniRequest.getCuff());
        sherwaniMeasurement.setStand(sherwaniRequest.getStand());
        sherwaniMeasurement.setNotes(sherwaniRequest.getNotes());

        log.info("Saving sherwani measurement for customer {}: {}", customer.getCustomerId(), sherwaniMeasurement);
        sherwaniMeasurementRepository.save(sherwaniMeasurement);

        sherwaniRequest.setMeasurementId(measurement.getMeasurementId());
        return sherwaniRequest;
    }

    private Integer getExistingSherwaniMeasurement(Long customerId) {
        return measurementRepository.findLatestSherwaniMeasurementNoByCustomerId(customerId);
    }

    public SherwaniMeasurementDTO getSherwaniMeasurement(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found with ID: " + customerId));

        Measurement measurement = latestSherwaniMeasurement(customer.getCustomerId());
        if (measurement == null) {
            throw new NoSuchElementException("Measurement not found for customer");
        }

        SherwaniMeasurement sherwaniMeasurement = measurement.getSherwaniMeasurement();
        if (sherwaniMeasurement == null) {
            throw new NoSuchElementException("Sherwani measurement not found for customer");
        }

        SherwaniMeasurementDTO sherwaniResponse = new SherwaniMeasurementDTO();
        sherwaniResponse.setMeasurementId(measurement.getMeasurementId());
        sherwaniResponse.setCustomerId(customer.getCustomerId());
        sherwaniResponse.setChest(sherwaniMeasurement.getChest());
        sherwaniResponse.setWaist(sherwaniMeasurement.getWaist());
        sherwaniResponse.setHip(sherwaniMeasurement.getHip());
        sherwaniResponse.setShoulder(sherwaniMeasurement.getShoulder());
        sherwaniResponse.setSleeve(sherwaniMeasurement.getSleeve());
        sherwaniResponse.setLength(sherwaniMeasurement.getLength());
        sherwaniResponse.setNeck(sherwaniMeasurement.getNeck());
        sherwaniResponse.setCuff(sherwaniMeasurement.getCuff());
        sherwaniResponse.setStand(sherwaniMeasurement.getStand());
        sherwaniResponse.setNotes(sherwaniMeasurement.getNotes());

        return sherwaniResponse;
    }

    private Measurement latestSherwaniMeasurement(Long customerId) {
        Integer latestSherwaniMeasurementNo = measurementRepository.findLatestSherwaniMeasurementNoByCustomerId(customerId);
        log.info("Latest sherwani measurement number for customer {}: {}", customerId, latestSherwaniMeasurementNo);
        if (latestSherwaniMeasurementNo == null) {
            return null;
        }
        return measurementRepository.findMeasurementByCustomerIdAndLatestSherwaniMeasurementNo(customerId, latestSherwaniMeasurementNo);
    }
}