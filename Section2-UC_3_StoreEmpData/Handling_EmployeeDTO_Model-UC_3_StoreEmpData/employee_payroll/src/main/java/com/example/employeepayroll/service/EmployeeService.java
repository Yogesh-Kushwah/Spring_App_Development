package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.mapper.EmployeeMapper;
import com.example.employeepayroll.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1); // Generates unique IDs

    // Add Employee (Stores in memory)
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        employee.setId(idCounter.getAndIncrement()); // Assign unique ID
        employeeList.add(employee);
        return EmployeeMapper.toDTO(employee);
    }

    // Get all employees (Retrieve from memory)
    public List<EmployeeDTO> getAllEmployees() {
        return employeeList.stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    // Get Employee by ID
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .map(EmployeeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Update Employee
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployeeDTO) {
        Optional<Employee> optionalEmployee = employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst();

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(updatedEmployeeDTO.getName());
            employee.setSalary(updatedEmployeeDTO.getSalary());
            return EmployeeMapper.toDTO(employee);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}
