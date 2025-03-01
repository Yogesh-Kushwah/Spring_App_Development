package com.bridgelabz.employeepayrollapp.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Salary can not be null")
    @Min(value=10000, message = "Salary must be greater than 10000")
    private double salary;

    @Pattern(regexp = "^(Male|male|female|Female|other|Other)$", message = "Gender must be Male, Female, or Other")
    @NotEmpty(message = "Gender cannot be empty")
    private String gender;
    @NotEmpty(message = "Message Must have some key points")
    private String note;

    @NotEmpty(message = "Start date cannot be empty")
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Start date must be in the format DD-MM-YYYY")
    private String startDate;

    @NotEmpty(message = "profilePic must have url of Image")
    private String profilePic;

    @NotEmpty(message = "List of Department must have 1 Department present")
    private List<String> department;

}
