package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.mapper.EmployeeMapper;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(savedEmployee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(EmployeeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
