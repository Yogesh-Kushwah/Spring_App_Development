package com.example.SpringEmployeePayrollApp.service;

import com.example.SpringEmployeePayrollApp.model.Employee;
import com.example.SpringEmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void deleteEmployee(Long id){
        List<Employee>emp=repository.findAll();
        for(int i=0;i< repository.count();i++){
            if(emp.get(i).getId().equals(id)){
                repository.delete(emp.get(i));
            }
        }
    }
}