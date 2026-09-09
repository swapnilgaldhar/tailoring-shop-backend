package com.shop.tailors.controller;

import com.shop.tailors.dto.StichingDetailsDTO;
import com.shop.tailors.entity.StichingOrder;
import com.shop.tailors.service.StichingOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stichingorder")
@CrossOrigin(origins = "http://localhost:5173")
public class StichingOrderController {

    @Autowired
    private StichingOrderService stichingOrderService;

    @PostMapping("/create/stiorder")
    public ResponseEntity<String> createStichingOrder(@RequestBody StichingOrder stichingOrder) {
       StichingOrder stichingOrder1 = stichingOrderService.createStichingOrder(stichingOrder);
        return new ResponseEntity<>("Stiching order created successfully with ID: " + stichingOrder1.getStOrderId(), HttpStatus.CREATED);
    }

    @GetMapping("/get/allorders")
    public ResponseEntity<List<StichingOrder>> getAllStichingOrders() {
        List<StichingOrder> stichingOrders = stichingOrderService.getAllStichingOrders();
        return new ResponseEntity<>(stichingOrders, HttpStatus.OK);
    }

    @GetMapping("/getdetails/{billNo}")
    public ResponseEntity<StichingDetailsDTO> getStichingOrderDetails(@PathVariable("billNo") String billNo) {
        StichingDetailsDTO  stichingDetailsDTO = stichingOrderService.getStichingOrderDetails(billNo);
        if (stichingDetailsDTO != null) {
            return new ResponseEntity<>(stichingDetailsDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/currentStage/{billNo}/{currentStage}")
    public ResponseEntity<String> updateCurrentStage(@PathVariable("billNo") String billNo, @PathVariable String currentStage) {
        stichingOrderService.updateCurrentStage(billNo, currentStage);
        return new ResponseEntity<>("Current stage updated successfully", HttpStatus.OK);
    }
}
