package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}

