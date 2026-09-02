package com.shop.tailors.service.impl;

import com.shop.tailors.dto.OrderDTO;
import com.shop.tailors.entity.Order;
import com.shop.tailors.entity.Vender;
import com.shop.tailors.repository.OrderRepository;
import com.shop.tailors.repository.VenderRepository;
import com.shop.tailors.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class OrderserviceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private VenderRepository venderRepository;

    @Override
    public void createOrder(OrderDTO orderDTO) {

        Vender vender = venderRepository.findByVenderId(orderDTO.getVenderId());

        Order order = new Order();

        if (vender != null) {
            order.setUpdatedDate(java.time.LocalDateTime.now());
            order.setVender(vender);
            order.setOrderDescription(orderDTO.getOrderDescription());
            order.setOrderAmount(orderDTO.getOrderAmount());
            order.setCheckNumber(orderDTO.getCheckNumber());
            order.setOrderDate(orderDTO.getOrderDate());
            order.setPaidAmount(orderDTO.getPaidAmount());
            order.setPaymentMethod(orderDTO.getPaymentMethod());
            order.setOrderRecivedDate(orderDTO.getOrderRecivedDate());
            log.info("Order received date: {}", orderDTO.getOrderRecivedDate());
            order.setInvoiceNo(orderDTO.getInvoiceNo());
            order.setRemainingAmount(orderDTO.getOrderAmount() - orderDTO.getPaidAmount());
            order.setVenderName(orderDTO.getVenderName());
           //order.setOrderRecivedDate(orderDTO.getOrderRecivedDate());

        }
        else{
            throw new RuntimeException("Vender not found with ID: " + orderDTO.getVenderId());
        }
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByVenderId(Long venderId) {
        return orderRepository.findByVenderId(venderId);
    }

    @Override
    public void updateOrder(Long orderId, LocalDate orderRecivedDate) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));


        if (existingOrder != null) {
            existingOrder.setUpdatedDate(java.time.LocalDateTime.now());
            existingOrder.setOrderRecivedDate(orderRecivedDate);

        } else {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
        orderRepository.save(existingOrder);
    }

    @Override
    public void updateRemainingAmount(Long orderId, Double amount) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        if (existingOrder != null) {
            existingOrder.setUpdatedDate(java.time.LocalDateTime.now());
            existingOrder.setRemainingAmount(existingOrder.getRemainingAmount() - amount);
        } else {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
        orderRepository.save(existingOrder);
    }

}
