package com.shop.tailors.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bill_items")
@Getter
@Setter
public class BillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billItemId;

    private String itemName;

    private int quantity;

    private Double rate;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "bill_number")
    @JsonBackReference("bill-items")
    private Bill bill;
}
