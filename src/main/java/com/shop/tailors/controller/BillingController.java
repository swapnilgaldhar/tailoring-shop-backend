package com.shop.tailors.controller;

import com.shop.tailors.dto.BillItemRequestDTO;
import com.shop.tailors.dto.BillRequestDTO;
import com.shop.tailors.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")
@CrossOrigin(origins = "http://localhost:5173")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/createbill")
    public ResponseEntity<BillRequestDTO> createBill(@RequestBody BillRequestDTO billRequestDTO) {
        // Implement the logic to create a bill using billingService
        billingService.createBill(billRequestDTO); // Assuming you have a method to create a bill in BillingService
        return new ResponseEntity<>(billRequestDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getbill/{billnumber}")
    public ResponseEntity<BillRequestDTO> getBill(@PathVariable("billnumber") String billNumber) {
       BillRequestDTO billDetails = billingService.getBillDetails(billNumber);
       return new ResponseEntity<>(billDetails, HttpStatus.OK);
    }

}
