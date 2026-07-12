package com.shop.tailors.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "CUSTOMERS")
///@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	
	@Column(nullable = false)
	private String custName;
	
	@Column(nullable = false, unique = true)
	private Long mobileNumber;
	
	@Column(nullable = false)
	private String address;
	
	private Double balence;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Measurement> measurements = new ArrayList<>();

}
