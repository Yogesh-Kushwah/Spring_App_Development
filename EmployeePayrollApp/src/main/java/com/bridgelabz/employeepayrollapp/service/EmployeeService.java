package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeRequestDTO;
import com.bridgelabz.employeepayrollapp.dto.EmployeeResponseDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
	   this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(@Valid EmployeeRequestDTO employeeData) {
        Employee employee = new Employee(employeeData.getName() , employeeData.getSalary() , employeeData.getGender() , employeeData.getNote() , employeeData.getStartDate(), employeeData.getProfilePic());
	   employee.setDepartment(employeeData.getDepartment());
	   log.debug("Creating a Employee With Name :{}", employee.getName());
	   // Add employee to the list

        Employee savedEmployee = employeeRepository.save(employee);
	   log.info("Successfully a employee Created {}", employee);
	   return savedEmployee;
    }

    public Employee getEmployeeById(Long id) {
	   log.debug("Searching for Employee By Id {}" , id);
	   // Return employee if found, otherwise return null
	   return  employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
	   // Return all employees in the list
	   return employeeRepository.findAll();
    }

    // Created a method to get employees of specific department
    public List<Employee> getEmployeesByDepartment(String department) {
	   return employeeRepository.findByDepartment(department);
    }


    public EmployeeResponseDTO updateEmployee(Long id, @Valid  EmployeeRequestDTO updatedEmployee) {

	   Employee employee = employeeRepository.findById(id).orElse(null);

	   if(employee != null) {
		  employee.setName(updatedEmployee.getName());
		  employee.setProfilePic(updatedEmployee.getProfilePic());
		  employee.setNote(updatedEmployee.getNote());
		  employee.setSalary(updatedEmployee.getSalary());
		  employee.setGender(updatedEmployee.getGender());
		  employee.setDepartment(updatedEmployee.getDepartment());
		  employee.setStartDate(updatedEmployee.getStartDate());
		  employeeRepository.save(employee);
		  log.info("Successfully Employee Details Updated ......");
		  return new EmployeeResponseDTO(updatedEmployee.getName(), updatedEmployee.getGender(), updatedEmployee.getNote(), updatedEmployee.getStartDate(), updatedEmployee.getProfilePic(), updatedEmployee.getDepartment());
	   }
	   // Return null if no matching employee is found
	   return null;
    }

    public boolean deleteEmployee(Long id) {
	   log.debug("Deleting the Employee Whose id is {}" , id);
	   // Remove employee with the given ID
	   if((employeeRepository.existsById(id))) {
		  employeeRepository.deleteById(id);
		  return true;
	   }
	   // return false for employee not found with given id
	   return false;
    }
}
