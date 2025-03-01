package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

// DTO (Data Transfer Object) for Employee requests.
// This class is used to transfer employee details from the client to the server.
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeRequestDTO {
    // Data members for the employee details. (id, name, salary)
    // Used lombok annotations to generate getters, setters, toString, constructor, etc.
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]*$", message = "Name must start with an uppercase letter and contain only alphabets and spaces")
    private String name;
    private double salary;
    private String gender;
    private String note;
    private String startDate;
    private String profilePic;
    private List<String> department;

}
