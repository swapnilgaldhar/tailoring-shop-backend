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
    private String karagirName;
    private String karagirPhone;
    private String karagirAddress;
    private String karagirSpeciality;
}
