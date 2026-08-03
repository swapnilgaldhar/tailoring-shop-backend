package com.shop.tailors.service.impl;

import com.shop.tailors.entity.Employee;
import com.shop.tailors.entity.Karagir;
import com.shop.tailors.repository.EmployeeRepository;
import com.shop.tailors.repository.KaragirRepository;
import com.shop.tailors.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private KaragirRepository karagirRepository;

    @Override
    public void createKaragir(Karagir karagir) {
         karagirRepository.save(karagir);
    }

    @Override
    public List<Karagir> getAllKaragir() {
        return karagirRepository.findAll();
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
