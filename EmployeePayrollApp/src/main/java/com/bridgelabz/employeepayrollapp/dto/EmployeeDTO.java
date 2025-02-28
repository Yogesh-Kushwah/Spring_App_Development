package com.bridgelabz.employeepayrollapp.dto;


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

