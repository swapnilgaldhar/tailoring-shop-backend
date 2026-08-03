package com.shop.tailors.service;

import com.shop.tailors.entity.Employee;
import com.shop.tailors.entity.Karagir;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    void createKaragir(Karagir karagir);

    List<Karagir> getAllKaragir();

    void createEmployee(Employee employee);

    List<Employee> getAllEmployee();
}
