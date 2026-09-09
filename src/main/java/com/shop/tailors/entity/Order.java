package com.shop.tailors.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "invoice_no", unique = true, nullable = false)
    private Long invoiceNo;

    @Column(name = "order_description" ,nullable = false)
    private String orderDescription;

    @Column(name = "order_amount" ,nullable = false)
    private Double orderAmount;

    @Column(name = "paid_amount" ,  nullable = false)
    private Double paidAmount;

    @Column(name = "remaining_amount" , nullable = false)
    private Double remainingAmount;

    @Column(name = "payment_method" , nullable = false)
    private String paymentMethod;

    @Column(name = "check_number" ,  unique = true)
    private String checkNumber;

    @Column(name = "order_date" , nullable = false)
    private LocalDate orderDate;

    @Column(name = "updated_date" , nullable = false)
    private LocalDateTime updatedDate;

    private LocalDate orderRecivedDate;

    private String venderName;

    //@ManyToOne
   // @JoinColumn(name = "vender_id")
    //private Vender vender;
//
    @ManyToOne
    @JoinColumn(name = "vender_id")
    @JsonBackReference
    private Vender vender;
}

