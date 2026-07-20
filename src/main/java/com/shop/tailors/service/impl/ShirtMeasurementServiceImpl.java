package com.shop.tailors.service.impl;

import com.shop.tailors.dto.ShirtMeasurementDTO;
import com.shop.tailors.entity.Customer;
import com.shop.tailors.entity.Measurement;
import com.shop.tailors.entity.ShirtMeasurement;
import com.shop.tailors.repository.CustomerRepository;
import com.shop.tailors.repository.MeasurementRepo;
import com.shop.tailors.repository.ShirtMeasurementRepo;
import com.shop.tailors.service.ShirtMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;
import java.util.NoSuchElementException;

@Service
public class ShirtMeasurementServiceImpl implements ShirtMeasurementService {

    @Autowired
    private MeasurementRepo measurementRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShirtMeasurementRepo shirtMeasurementRepository;

    @Override
    @Transactional
    public ShirtMeasurementDTO saveShirtMeasurement(ShirtMeasurementDTO shirtMeasurementDTO) {

        Customer customer = customerRepository.findById(shirtMeasurementDTO.getCustomerId())
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        Measurement measurement = new Measurement();
        measurement.setCustomer(customer);
        measurement.setCreatedDate(LocalDate.now());

        Integer existingShirtMeasurement = getExistingShirtMeasurement(customer.getCustomerId());

        measurement.setShirtMeasurementNo(existingShirtMeasurement != null ? existingShirtMeasurement + 1 : 1);

        measurementRepository.save(measurement);
        ShirtMeasurement shirtMeasurement = new ShirtMeasurement();

        shirtMeasurement.setMeasurement(measurement);
        shirtMeasurement.setChest(shirtMeasurementDTO.getChest());
        shirtMeasurement.setWaist(shirtMeasurementDTO.getWaist());
        shirtMeasurement.setHip(shirtMeasurementDTO.getHip());
        shirtMeasurement.setShoulder(shirtMeasurementDTO.getShoulder());
        shirtMeasurement.setSleeve(shirtMeasurementDTO.getSleeve());
        shirtMeasurement.setLength(shirtMeasurementDTO.getLength());
        shirtMeasurement.setNeck(shirtMeasurementDTO.getNeck());
        shirtMeasurement.setCuff(shirtMeasurementDTO.getCuff());
        shirtMeasurement.setNotes(shirtMeasurementDTO.getNotes());


        shirtMeasurementRepository.save(shirtMeasurement);
        return shirtMeasurementDTO;
    }



    private Integer getExistingShirtMeasurement(Long customerId) {
        return measurementRepository.findLatestShirtMeasurementNoByCustomerId(customerId);
    }
/*
    @Override
    public ShirtMeasurementDTO getShirtMeasurement(Long customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        Integer existingShirtMeasurement = getExistingShirtMeasurement(customer.getCustomerId());


        ShirtMeasurement shirtMeasurement = shirtMeasurementRepository
                .getShirtMeasurementLatestShirtMeasurementNo(customer.getCustomerId());
              //  .orElseThrow(() -> new NoSuchElementException("Shirt measurement not found for customer"));

        ShirtMeasurementDTO shirtMeasurementDTO = new ShirtMeasurementDTO();
        shirtMeasurementDTO.setMeasurementId(shirtMeasurement.getMeasurement().getMeasurementId());
        shirtMeasurementDTO.setCustomerId(customer.getCustomerId());
        shirtMeasurementDTO.setChest(shirtMeasurement.getChest());
        shirtMeasurementDTO.setWaist(shirtMeasurement.getWaist());
        shirtMeasurementDTO.setHip(shirtMeasurement.getHip());
        shirtMeasurementDTO.setShoulder(shirtMeasurement.getShoulder());
        shirtMeasurementDTO.setSleeve(shirtMeasurement.getSleeve());
        shirtMeasurementDTO.setLength(shirtMeasurement.getLength());
        shirtMeasurementDTO.setNeck(shirtMeasurement.getNeck());
        shirtMeasurementDTO.setCuff(shirtMeasurement.getCuff());
        shirtMeasurementDTO.setNotes(shirtMeasurement.getNotes());

        return shirtMeasurementDTO;
    }

*/


}
