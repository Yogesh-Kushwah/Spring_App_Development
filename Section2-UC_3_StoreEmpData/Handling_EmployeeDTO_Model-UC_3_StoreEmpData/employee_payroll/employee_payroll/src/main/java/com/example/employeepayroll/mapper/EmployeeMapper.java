package com.example.employeepayroll.mapper;


import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.model.Employee;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }

    public static Employee toEntity(EmployeeDTO employeeDTO) {
        return new Employee(null, employeeDTO.getName(), employeeDTO.getSalary());
    }
}
