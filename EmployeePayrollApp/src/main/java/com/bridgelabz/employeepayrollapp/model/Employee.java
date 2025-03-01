package com.bridgelabz.employeepayrollapp.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
// Marks this class as a JPA entity
@Entity
// Specifies the table name in the database
@Table(name = "employees")
public class Employee {

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Employee name
    private double salary;

    @Column(nullable = false)
    // Employee salary
    private String name;
    // Employee gender
    private String gender;

    //Employee note
    private String note;

    @Column(nullable=false)
    // Employee startDate
    private LocalDate startDate;

    // Employee profilePic
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department_name")
    // Employee department
    private List<String> department;

    // Default Constructor for mapper
    public Employee() {
    }

    // Parameterized Constructor to initialize the Employee details
    public Employee( String name, double salary, String gender, String note, LocalDate startDate, String profilePic) {
	   this.name = name;
	   this.salary = salary;
	   this.gender = gender;
	   this.note = note;
	   this.startDate = startDate;
	   this.profilePic = profilePic;
    }

}
