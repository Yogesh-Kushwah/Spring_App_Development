package com.bridgelabz.employeePayrollApp.DTO;


import jakarta.persistence.Entity;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {
    private String name;
    private double salary;

}

