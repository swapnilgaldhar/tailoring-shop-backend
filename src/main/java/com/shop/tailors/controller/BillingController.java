package com.shop.tailors.controller;

import com.shop.tailors.dto.BillItemRequestDTO;
import com.shop.tailors.dto.BillRequestDTO;
import com.shop.tailors.entity.Customer;
import com.shop.tailors.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/billing")
@CrossOrigin(origins = "http://localhost:5173")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/createbill")
    public ResponseEntity<BillRequestDTO> createBill(@RequestBody BillRequestDTO billRequestDTO) {
        // Implement the logic to create a bill using billingService
        BillRequestDTO CreatedbillRequestDTO =  billingService.createBill(billRequestDTO); // Assuming you have a method to create a bill in BillingService
        return new ResponseEntity<>(CreatedbillRequestDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getbill/{billnumber}")
    public ResponseEntity<BillRequestDTO> getBill(@PathVariable("billnumber") String billNumber) {
       BillRequestDTO billDetails = billingService.getBillDetails(billNumber);
       return new ResponseEntity<>(billDetails, HttpStatus.OK);
    }

    @PutMapping("/updateDeliveryStatus/{billnumber}/{status}")
    public String updateDeliveryStatus(@PathVariable("billnumber") String billNumber , @PathVariable String status){
        billingService.updateDeliveryStatus(billNumber, status);
        return "Delivery status updated successfully";
    }


}
