package com.shop.tailors.controller;

import com.shop.tailors.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
@CrossOrigin(origins = "http://localhost:5173")
public class ReportController {

    @Autowired
    private BillRepository billingRepository;

    @GetMapping("/todays/sales")
    public ResponseEntity<Double> getSales() {
        Double salesAmount = billingRepository.getTodaysSalesAmount();
        return new ResponseEntity<>(salesAmount, HttpStatus.OK);
    }

    @GetMapping("/monthly/sales")
    public ResponseEntity<Double> getMonthlySales() {
        Double monthlySalesAmount = billingRepository.getMonthlySalesAmount();
        return new ResponseEntity<>(monthlySalesAmount, HttpStatus.OK);
    }

    @GetMapping("/todays/delivery")
    public ResponseEntity<Double> getTodaysDelivery() {
        Double totalDelivery = billingRepository.getTodaysDeliveryAmount();
        return new ResponseEntity<>(totalDelivery, HttpStatus.OK);
    }

    @GetMapping("/todays/collection")
    public ResponseEntity<Double> getTodaysCollection() {
        Double todaysCollection = billingRepository.getTodaysCollectionAmount();
        return new ResponseEntity<>(todaysCollection, HttpStatus.OK);
    }

    @GetMapping("/customers/withbalance")
    public ResponseEntity<Integer> getCustomerCountWithBalance() {
        Integer customerCount = billingRepository.getCustomerCountWithBalence();
        return new ResponseEntity<>(customerCount, HttpStatus.OK);
    }
}
