package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    private String gender;
    private String department;

    private double salary;
}
