package com.shop.tailors.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bills")
@Getter
@Setter
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billNumber;

    private LocalDate billDate;

    private Double totalAmount;

    private Double discountPer;

    private Double discountAmount;

    private  String paymentMode;

    private LocalDate deliveryDate;

    private String notes;

    private Double paidAmount;

    private Double balanceAmount;

    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference("customer-bills")
    private Customer customer;

    @OneToMany(mappedBy = "bill",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference("bill-items")
    private List<BillItem> billItems = new ArrayList<>();
}
