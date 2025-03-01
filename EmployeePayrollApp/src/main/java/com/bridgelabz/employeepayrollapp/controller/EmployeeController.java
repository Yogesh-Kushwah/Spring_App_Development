package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeRequestDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeeResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    private EmployeeService employeeService;

    // Injecting EmployeeService using @Autowired (Constructor Injection)
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // GET Employee
    @GetMapping("/getById/{id}")
    public EmployeeResponseDTO getEmployee(@PathVariable Long id) {
        log.info("Received GET request for Employee with ID: {}", id);

        // Make a call to getEmployeeById and log the result
        Employee employee = employeeService.getEmployeeById(id);

        EmployeeResponseDTO employeeDetails = new EmployeeResponseDTO( employee.getName() , employee.getSalary());

        log.info("Returning Employee: {}", employee);
        return employeeDetails;
    }

    // POST - Add Employee
    @PostMapping("/create")
    public EmployeeResponseDTO addEmployee(@Valid  @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        log.debug("Creating a EEmployee  with id {} ", employeeRequestDTO.getId());
        Employee employee = employeeService.addEmployee( new Employee(employeeRequestDTO.getId() ,employeeRequestDTO.getName(), employeeRequestDTO.getSalary()));
        EmployeeResponseDTO employeeDetails = new EmployeeResponseDTO( employee.getName() , employee.getSalary());
        log.info("Successfully employee created {}" , employee);
        return employeeDetails;
    }

    // PUT - Update Employee
    @PutMapping("/update/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable Long id ,@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
	   return employeeService.updateEmployee(id ,  employeeRequestDTO);
    }

    // DELETE - Delete Employee
    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}
