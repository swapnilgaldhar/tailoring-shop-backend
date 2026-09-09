package com.shop.tailors.controller;

import com.shop.tailors.dto.OrderDTO;
import com.shop.tailors.entity.Order;
import com.shop.tailors.entity.Vender;
import com.shop.tailors.service.OrderService;
import com.shop.tailors.service.VenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderAndVenderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private VenderService venderService;

    //create vender
    @PostMapping("/vender/createvender")
    public ResponseEntity<String> createVender(@RequestBody Vender vender){
        // Implementation for creating a vender
        venderService.createVender(vender);
        return ResponseEntity.ok("Vender created successfully");
    }

    //get all venders
    @GetMapping("/vender/getallvender")
    public ResponseEntity<List<Vender>> getAllVender(){
        List<Vender> venders = venderService.getAllVenders();
        return new ResponseEntity<>(venders, HttpStatus.OK);
    }

    //get vender by venderId
    @GetMapping("/vender/getvenderbyid/{venderId}")
    public ResponseEntity<Vender> getVenderById(@PathVariable("venderId") int venderId){
        Vender vender = venderService.getAllVenders().stream()
                .filter(v -> v.getVenderId() == venderId)
                .findFirst()
                .orElse(null);
        if (vender != null) {
            return new ResponseEntity<>(vender, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/order/createorder")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO){

        orderService.createOrder(orderDTO);
        return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/order/getallorders")
    public ResponseEntity<List<Order>> getAllOrders(){

        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/order/getallorders/venderid/{venderId}")
    public ResponseEntity<List<Order>> getOrdersByVenderId(@PathVariable Long venderId){

        List<Order> orders = orderService.getOrdersByVenderId(venderId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @PutMapping("/order/update/orderreciveddate/{orderId}/{orderRecivedDate}")// update orderreceived date.
    public ResponseEntity<String> updateOrder(@PathVariable Long orderId, @PathVariable LocalDate orderRecivedDate) {
        // Implementation for updating an order
        orderService.updateOrder(orderId, orderRecivedDate);
        return ResponseEntity.ok("Order updated successfully");
    }

    @PutMapping("/order/update/remainingamount/{amount}/{orderId}")
    public ResponseEntity<String> updateRemainingAmount(@PathVariable Double amount, @PathVariable Long orderId) {
        // Implementation for updating remaining amount
        orderService.updateRemainingAmount(orderId, amount);
        return ResponseEntity.ok("Remaining amount updated successfully");
    }
}
