package com.shop.tailors.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "karagir")
public class Karagir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer karagirId;
    @Column(nullable = false)
    private String karagirName;
    @Column(nullable = false)
    private String karagirPhone;
    @Column(nullable = false)
    private String karagirAddress;
    @Column(nullable = false)
    private String karagirSpeciality;
}
