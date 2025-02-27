package com.bridgelabz.employeePayrollApp.controller;


import com.bridgelabz.employeePayrollApp.DTO.EmployeeDTO;
import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import com.bridgelabz.employeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
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
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping("/update/{name}")
    public EmployeeModel updateEmployee(@PathVariable String  name, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(name,employeeDTO);
    }

    @DeleteMapping("/delete/{name}")
    public String deleteEmployee(@PathVariable String name) {
        boolean isDeleted = employeeService.deleteEmployee(name);
        return isDeleted ? "Employee deleted successfully" : "Employee not found";
    }

    @GetMapping("/DTO/get/{name}/{salary}")
    public EmployeeModel getEmployee(@PathVariable String name, @PathVariable int salary) {
        return new EmployeeModel(new EmployeeDTO(name, salary)); // Returning employee details based on input
    }

    //UC-05
    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
