package com.shop.tailors.service.impl;

import com.shop.tailors.dto.BlazerMeasurementDTO;
import com.shop.tailors.entity.*;
import com.shop.tailors.repository.BlazerMeasurementRepository;
import com.shop.tailors.repository.CustomerRepository;
import com.shop.tailors.repository.MeasurementRepo;
import com.shop.tailors.service.BlazerMeasurementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class BlazerMeasurementServiceImpl implements BlazerMeasurementService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MeasurementRepo measurementRepository;

    @Autowired
    private BlazerMeasurementRepository blazerMeasurementRepository;


    @Override
    public BlazerMeasurementDTO createBlazerMeasurement(BlazerMeasurementDTO blazerMeasurementDTO) {

        Customer customer = customerRepository.findById(blazerMeasurementDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + blazerMeasurementDTO.getCustomerId()));


        Measurement measurement = new Measurement();
        measurement.setCustomer(customer);
        measurement.setCustomer(customer);
        measurement.setCreatedDate(LocalDate.now());

        Integer existingBlazerMeasurement = getExistingBlazerMeasurement(customer.getCustomerId());
        log.info("Existing blazer measurement number for customer {}: {}", customer.getCustomerId(), existingBlazerMeasurement);
        measurement.setBlazerMeasurementNo(existingBlazerMeasurement != null ? existingBlazerMeasurement + 1 : 1);

        measurementRepository.save(measurement);

        BlazerMeasurement blazerMeasurement = new BlazerMeasurement();

        blazerMeasurement.setMeasurement(measurement);
        blazerMeasurement.setHeight(blazerMeasurementDTO.getHeight());
        blazerMeasurement.setChest(blazerMeasurementDTO.getChest());
        blazerMeasurement.setWaist(blazerMeasurementDTO.getWaist());
        blazerMeasurement.setHip(blazerMeasurementDTO.getHip());
        blazerMeasurement.setShoulder(blazerMeasurementDTO.getShoulder());
        blazerMeasurement.setBicep(blazerMeasurementDTO.getBicep());
        blazerMeasurement.setSleeveLength(blazerMeasurementDTO.getSleeveLength());
        blazerMeasurement.setCuffWidth(blazerMeasurementDTO.getCuffWidth());
        blazerMeasurement.setLapelWidth(blazerMeasurementDTO.getLapelWidth());
        blazerMeasurement.setNotes(blazerMeasurementDTO.getNotes());

        log.info("Saving blazer measurement for customer {}: {}", customer.getCustomerId(), blazerMeasurement);

        blazerMeasurementRepository.save(blazerMeasurement);

        return blazerMeasurementDTO;
    }



    private Integer getExistingBlazerMeasurement(Long customerId) {

      return  measurementRepository.findLatestBlazerMeasurementNoByCustomerId(customerId);
       // returnreturn measurementRepository.findLatestJacketMeasurementNoByCustomerId(customerId);
    }

    @Override
    public BlazerMeasurementDTO getBlazerMeasurement(Long customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
        Long customerid = customer.getCustomerId();
        Measurement measurement = latestBlazerMeasurement(customerid);


        BlazerMeasurement blazerMeasurement = blazerMeasurementRepository
                .getBlazerMeasurementLatestBlazerMeasurementNo(measurement.getMeasurementId());


        BlazerMeasurementDTO blazerMeasurementDTO = new BlazerMeasurementDTO();

        blazerMeasurementDTO.setCustomerId(customer.getCustomerId());
        blazerMeasurementDTO.setHeight(blazerMeasurement.getHeight());
        blazerMeasurementDTO.setChest(blazerMeasurement.getChest());
        blazerMeasurementDTO.setWaist(blazerMeasurement.getWaist());
        blazerMeasurementDTO.setHip(blazerMeasurement.getHip());
        blazerMeasurementDTO.setShoulder(blazerMeasurement.getShoulder());
        blazerMeasurementDTO.setBicep(blazerMeasurement.getBicep());
        blazerMeasurementDTO.setSleeveLength(blazerMeasurement.getSleeveLength());
        blazerMeasurementDTO.setCuffWidth(blazerMeasurement.getCuffWidth());
        blazerMeasurementDTO.setLapelWidth(blazerMeasurement.getLapelWidth());
        blazerMeasurementDTO.setNotes(blazerMeasurement.getNotes());

        return blazerMeasurementDTO;
    }

    private Measurement latestBlazerMeasurement(Long customerid) {
        Integer latestBlazerMeasurementNo = measurementRepository.findLatestBlazerMeasurementNoByCustomerId(customerid);
        log.info("Latest blazer measurement number for customer {}: {}", customerid, latestBlazerMeasurementNo);
        return measurementRepository.findMeasurementByCustomerIdAndLatestBlazerMeasurementNo(customerid, latestBlazerMeasurementNo);
    }

}
