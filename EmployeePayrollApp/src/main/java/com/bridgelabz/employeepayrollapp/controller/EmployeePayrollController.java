package com.bridgelabz.employeePayrollApp.controller;


import com.bridgelabz.employeePayrollApp.DTO.EmployeeDTO;
import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import com.bridgelabz.employeePayrollApp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeePayrollController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable Long id) {
        return "Fetching employee with ID: " + id;
    }
    //UC-04
    @PostMapping("/create")
    public EmployeeModel createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.info("Creating Employee: {}", employeeDTO);
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/update/{name}")
    public EmployeeModel updateEmployee(@PathVariable String  name, @RequestBody EmployeeDTO employeeDTO) {
        log.info("Updating Employee: {}", name);
        return employeeService.updateEmployee(name,employeeDTO);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteEmployee(@PathVariable String name) {
        boolean isDeleted = employeeService.deleteEmployee(name);
        log.info("Deleting Employee: {}, Success: {}", name, isDeleted);
        return isDeleted ? "Employee deleted successfully" : "Employee not found";
    }

    @GetMapping("/DTO/get/{name}/{salary}")
    public EmployeeModel getEmployee(@PathVariable String name, @PathVariable int salary) {
        return new EmployeeModel(new EmployeeDTO(name, salary)); // Returning employee details based on input
    }

    //UC-05
    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees() {
        log.info("Fetching all employees...");
        return employeeService.getAllEmployees();
    }

}
