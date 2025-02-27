package com.bridgelabz.employeePayrollApp.service;

import com.bridgelabz.employeePayrollApp.DTO.EmployeeDTO;
import com.bridgelabz.employeePayrollApp.model.EmployeeModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    //Add employee to the list
    List<EmployeeModel> employeeList = new ArrayList<>();
    public EmployeeModel createEmployee(EmployeeDTO employeeDTO){
        EmployeeModel employee = new EmployeeModel(employeeDTO);
        employeeList.add(employee);
        log.info("Employee Created: {} ", employee);
        return employee;
    }
    //list of all the employee
    public List<EmployeeModel> getAllEmployees(){
        return employeeList;
    }
    // Update Employee
    public EmployeeModel updateEmployee(String name, EmployeeDTO employeeDTO) {
        log.info("Searching and updating the employee with name: {} and salary: {}", employeeDTO.getName(), employeeDTO.getSalary());
        for (EmployeeModel employee : employeeList) {
            if (employee.getName().equalsIgnoreCase(name)) {
                employee.setName(employeeDTO.getName());
                employee.setSalary(employeeDTO.getSalary());
                return employee;
            }
        }
        return null;
    }
    // Delete Employee
    public boolean deleteEmployee(String name) {
        log.info("Searching and deleting the employee with name: {}", name);
        return employeeList.removeIf(emp -> emp.getName().equalsIgnoreCase(name));
    }
}
