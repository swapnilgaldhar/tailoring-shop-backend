package com.shop.tailors.service.impl;

import com.shop.tailors.dto.JacketMeasurementDTO;
import com.shop.tailors.entity.Customer;
import com.shop.tailors.entity.JacketMeasurement;
import com.shop.tailors.entity.Measurement;
import com.shop.tailors.repository.CustomerRepository;
import com.shop.tailors.repository.JacketMeasurementRepo;
import com.shop.tailors.repository.MeasurementRepo;
import com.shop.tailors.service.JacketMeasurementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class JacketMeasurementImpl implements JacketMeasurementService {

    @Autowired
    private JacketMeasurementRepo jacketMeasurementRepo;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MeasurementRepo measurementRepository;


    @Override
    public JacketMeasurementDTO createJacketMeasurement(JacketMeasurementDTO jacketMeasurmentDTO) {

        Customer customer = customerRepository.findById(jacketMeasurmentDTO.getCustomerId())
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        Measurement measurement = new Measurement();
        measurement.setCustomer(customer);
        measurement.setCreatedDate(LocalDate.now());

        Integer existingJacketMeasurement = getExistingJacketMeasurement(customer.getCustomerId());
        log.info("Existing jacket measurement number for customer {}: {}", customer.getCustomerId(), existingJacketMeasurement);
        measurement.setJacketMeasurementNo(existingJacketMeasurement != null ? existingJacketMeasurement + 1 : 1);

        measurementRepository.save(measurement);

        JacketMeasurement jacketMeasurement = new JacketMeasurement();

        jacketMeasurement.setMeasurement(measurement);
        jacketMeasurement.setChest(jacketMeasurmentDTO.getChest());
        jacketMeasurement.setWaist(jacketMeasurmentDTO.getWaist());
        jacketMeasurement.setHip(jacketMeasurmentDTO.getHip());
        jacketMeasurement.setShoulder(jacketMeasurmentDTO.getShoulder());
        jacketMeasurement.setLength(jacketMeasurmentDTO.getLength());
        jacketMeasurement.setStandCollar(jacketMeasurmentDTO.getStandCollar());
        jacketMeasurement.setNote(jacketMeasurmentDTO.getNote());


        log.info("Saving jacket measurement for customer {}: {}", customer.getCustomerId(), jacketMeasurement);
        jacketMeasurementRepo.save(jacketMeasurement);
        return jacketMeasurmentDTO;

    }



    private Integer getExistingJacketMeasurement(Long customerId) {
        return measurementRepository.findLatestJacketMeasurementNoByCustomerId(customerId);
    }

    @Override
    public JacketMeasurementDTO getJacketMeasurement(Long customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
        log.info("Retrieved customer {}: {}", customerId, customer);

        Long customerid = customer.getCustomerId();

        Measurement measurement = latestJacketMeasurement(customerid);

        log.info("Measurement : {}", measurement);

        JacketMeasurement jacketMeasurement =
                jacketMeasurementRepo.getJacketMeasurementLatestMeasurementNo(
                        measurement.getMeasurementId());

        log.info("Jacket Measurement : {}", jacketMeasurement);

        log.info("Retrieved customer {}: {}", customerId, customer);

        if (measurement == null) {
            throw new NoSuchElementException("Measurement not found");
        }


        log.info("Retrieved jacket measurement for customer {}: {}", customerId, jacketMeasurement);
        if (jacketMeasurement == null) {
            throw new NoSuchElementException("Shirt measurement not found for customer");
        }
        JacketMeasurementDTO jacketMeasurementDTO = new JacketMeasurementDTO();
        jacketMeasurementDTO.setCustomerId(customer.getCustomerId());
        jacketMeasurementDTO.setChest(jacketMeasurement.getChest());
        jacketMeasurementDTO.setWaist(jacketMeasurement.getWaist());
        jacketMeasurementDTO.setHip(jacketMeasurement.getHip());
        jacketMeasurementDTO.setShoulder(jacketMeasurement.getShoulder());
        jacketMeasurementDTO.setLength(jacketMeasurement.getLength());
        jacketMeasurementDTO.setStandCollar(jacketMeasurement.getStandCollar());
        jacketMeasurementDTO.setNote(jacketMeasurement.getNote());

        return jacketMeasurementDTO;
    }

    private Measurement latestJacketMeasurement(Long customerid) {
        Integer latestJacketMeasurementNo = measurementRepository.findLatestJacketMeasurementNoByCustomerId(customerid);
        log.info("Latest jacket measurement number for customer {}: {}", customerid, latestJacketMeasurementNo);
        return measurementRepository.findMeasurementByCustomerIdAndLatestJacketMeasurementNo(customerid, latestJacketMeasurementNo);
    }
}
