package com.shop.tailors.service;

import com.shop.tailors.dto.OrderDTO;
import com.shop.tailors.entity.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface OrderService {
    void createOrder(OrderDTO orderDTO);

    List<Order> getAllOrders();

    List<Order> getOrdersByVenderId(Long venderId);

    void updateOrder(Long orderId, LocalDate orderRecivedDate);

    void updateRemainingAmount(Long orderId, Double amount);
}
