package com.shop.tailors.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venders")
public class Vender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venderId;

    private String venderName;

    private String venderAddress;

    private String venderPhone;

  //  @OneToMany(mappedBy = "vender",cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<Order> orders;

    @OneToMany(
            mappedBy = "vender",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Order> orders;

}
