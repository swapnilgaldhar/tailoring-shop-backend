package com.shop.tailors.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "stiching_order")
@Setter
@Getter
public class StichingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long srNo;

    private String stOrderId;
    private long billNo;
    private LocalDate orderDate;
    private String customerId;
    private String customerName;
    private String garmentType;
    private int quantity;
    private String currentStage;
    private LocalDate deliveryDate;
    private String productionNotes;


}
