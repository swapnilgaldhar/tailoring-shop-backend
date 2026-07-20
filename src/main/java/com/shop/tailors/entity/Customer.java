package com.shop.tailors.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "CUSTOMERS")
@NoArgsConstructor
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@Column(nullable = false)
	private String customerName;
	
	@Column(nullable = false, unique = true)
	private Long mobileNumber;
	
	@Column(nullable = false)
	private String address;
	
	private Double balance=0.0;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Measurement> measurements;

}
