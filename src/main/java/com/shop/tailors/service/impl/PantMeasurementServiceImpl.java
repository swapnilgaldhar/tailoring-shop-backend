package com.shop.tailors.service.impl;

import com.shop.tailors.dto.PantMeasurementDTO;
import com.shop.tailors.entity.Customer;
import com.shop.tailors.entity.Measurement;
import com.shop.tailors.entity.PantMeasurement;
import com.shop.tailors.repository.CustomerRepository;
import com.shop.tailors.repository.MeasurementRepo;
import com.shop.tailors.repository.PantMeasurementRepo;
import com.shop.tailors.service.PantMeasurementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class  PantMeasurementServiceImpl implements PantMeasurementService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MeasurementRepo measurementRepository;

    @Autowired
    private PantMeasurementRepo pantMeasurementRepository;

    //@Autowired
  //  private Measurement measurement;

    @Override
    @Transactional
    public PantMeasurementDTO savePantMeasurement(PantMeasurementDTO pantMeasurementDTO) {

        Customer customer = customerRepository.findById(pantMeasurementDTO.getCustomerId())
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        Measurement measurement = new Measurement();
        measurement.setCustomer(customer);
        measurement.setCreatedDate(LocalDate.now());

        Integer existingPantMeasurement = getExistingPantMeasurement(customer.getCustomerId());

        measurement.setPantMeasurementNo(existingPantMeasurement != null ? existingPantMeasurement + 1 : 1);
        measurementRepository.save(measurement);

        PantMeasurement pantMeasurement = new PantMeasurement();
        pantMeasurement.setMeasurement(measurement);
        pantMeasurement.setWaist(pantMeasurementDTO.getWaist());
        pantMeasurement.setHip(pantMeasurementDTO.getHip());
        pantMeasurement.setThigh(pantMeasurementDTO.getThigh());
        pantMeasurement.setKnee(pantMeasurementDTO.getKnee());
        pantMeasurement.setCalf(pantMeasurementDTO.getCalf());
        pantMeasurement.setBottom(pantMeasurementDTO.getBottom());
        pantMeasurement.setLength(pantMeasurementDTO.getLength());
        pantMeasurement.setNotes(pantMeasurementDTO.getNotes());

     //   measurement.setPantMeasurement(pantMeasurement);
        pantMeasurementRepository.save(pantMeasurement);

        return pantMeasurementDTO;
    }

    private Integer getExistingPantMeasurement(Long customerId) {
        return measurementRepository.findLatestPantMeasurementNoByCustomerId(customerId);
    }

    @Override
    public PantMeasurementDTO getPantMeasurement(Long customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        Long customerid = customer.getCustomerId();
        Measurement measurement = latestPantMeasurement(customerid);

        PantMeasurement pantMeasurement = pantMeasurementRepository
                .getPantMeasurementLatestPantMeasurementNo(measurement.getMeasurementId());

        PantMeasurementDTO pantMeasurementDTO = new PantMeasurementDTO();

        pantMeasurementDTO.setMeasurementId(pantMeasurement.getMeasurement().getMeasurementId());
        pantMeasurementDTO.setCustomerId(customer.getCustomerId());

        pantMeasurementDTO.setWaist(pantMeasurement.getWaist());
        pantMeasurementDTO.setHip(pantMeasurement.getHip());
        pantMeasurementDTO.setThigh(pantMeasurement.getThigh());
        pantMeasurementDTO.setKnee(pantMeasurement.getKnee());
        pantMeasurementDTO.setCalf(pantMeasurement.getCalf());
        pantMeasurementDTO.setBottom(pantMeasurement.getBottom());
        pantMeasurementDTO.setLength(pantMeasurement.getLength());
        pantMeasurementDTO.setNotes(pantMeasurement.getNotes());

        return pantMeasurementDTO;
    }

    private Measurement latestPantMeasurement(Long customerid) {
        Integer latestPantMeasurementNo = measurementRepository.findLatestPantMeasurementNoByCustomerId(customerid);
        log.info("Latest pant measurement number for customer {}: {}", customerid, latestPantMeasurementNo);
        return measurementRepository.findMeasurementByCustomerIdAndLatestPantMeasurementNo(customerid, latestPantMeasurementNo);
    }


}
