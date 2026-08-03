package com.shop.tailors.controller;

import com.shop.tailors.entity.Employee;
import com.shop.tailors.entity.Karagir;
import com.shop.tailors.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/karagir/createkaragir")
    public String createKaragir(@RequestBody Karagir karagir) {

        employeeService.createKaragir(karagir);

        return "Karagir created successfully!";
    }

    @GetMapping("/karagir/getallkaragir")
    public ResponseEntity<List<Karagir>> getAllKaragir() {
        List<Karagir> karagirs = employeeService.getAllKaragir();
        return ResponseEntity.ok(karagirs);
    }

    @PostMapping("/employee/createemployee")
    public String createEmployee(@RequestBody Employee employee){

        employeeService.createEmployee(employee);
        return "Employee created successfully!";
    }

    @GetMapping("/employee/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployee(); // Assuming you have a method to get all employees
        return ResponseEntity.ok(employees);
    }
}
