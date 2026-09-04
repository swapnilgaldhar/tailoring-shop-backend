package com.shop.tailors.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "CUSTOMERS")
@NoArgsConstructor
@Entity
@Getter
@Setter
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

	private LocalDate createdDate=LocalDate.now();

	private LocalDate lastUpdateDate=LocalDate.now();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference("customer-measurements")
	private List<Measurement> measurements;

	@OneToMany(mappedBy = "customer",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonManagedReference("customer-bills")
	private List<Bill> bills;

}
