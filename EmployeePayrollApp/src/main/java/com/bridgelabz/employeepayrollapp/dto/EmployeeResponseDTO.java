package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//DTO (Data Transfer Object) used to send employee details as a response.
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO{
    // Defined Data members for the employee details. (name, salary)
    // Used lombok annotations to generate getters, setters, toString, constructor, etc.
    private String name;
    private String gender;
    private String note;
    private String startDate;
    private String profilePic;
    private List<String> department;

    public List<String> getDepartment(){
        return department;
    }
    private void setDepartment(){
        this.department = department;
    }
}
