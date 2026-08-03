package com.shop.tailors.repository;

import com.shop.tailors.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
