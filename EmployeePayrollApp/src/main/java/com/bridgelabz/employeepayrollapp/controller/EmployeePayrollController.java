package com.bridgelabz.employeePayrollApp.controller;


import com.bridgelabz.employeePayrollApp.DTO.EmployeeDTO;
import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import com.bridgelabz.employeePayrollApp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeePayrollController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with ID: {}", id);
        return ResponseEntity.ok("Fetching employee with ID: " + id);
    }

    // UC-04: Create Employee
    @PostMapping("/create")
    public ResponseEntity<EmployeeModel> createEmployee(@Valid  @RequestBody EmployeeDTO employeeDTO) {
        log.info("Creating Employee: {}", employeeDTO);
        EmployeeModel employee = employeeService.createEmployee(employeeDTO);
        return ResponseEntity.ok(employee);
    }

    // Update Employee by Name
    @PutMapping("/update/{name}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable String name,@Valid  @RequestBody EmployeeDTO employeeDTO) {
        log.info("Updating Employee: {}", name);
        EmployeeModel updatedEmployee = employeeService.updateEmployee(name, employeeDTO);

        if (updatedEmployee == null) {
            log.warn("Failed to update - Employee not found: {}", name);
            return ResponseEntity.notFound().build();
        }

        log.info("Employee updated successfully: {}", updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete Employee by Name
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String name) {
        boolean isDeleted = employeeService.deleteEmployee(name);
        log.info("Deleting Employee: {}, Success: {}", name, isDeleted);

        if (isDeleted) {
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Employee not found");
        }
    }

    // UC-05: Get All Employees
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeModel>> getAllEmployees() {
        log.info("Fetching all employees...");
        List<EmployeeModel> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Test Logging
    @GetMapping("/testLogging")
    public ResponseEntity<String> testLogging() {
        employeeService.testLogging();
        return ResponseEntity.ok("Logging has been tested. Check logs for details.");
    }

    // Get Employee from DTO
    @GetMapping("/DTO/get/{name}/{salary}")
    public ResponseEntity<EmployeeModel> getEmployee(@PathVariable String name, @PathVariable int salary) {
        EmployeeModel employee = new EmployeeModel(new EmployeeDTO(name, salary));
        return ResponseEntity.ok(employee);
    }

}
