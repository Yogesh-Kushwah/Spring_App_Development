package com.bridgelabz.employeepayrollapp.model;
import jakarta.persistence.*;
import lombok.ToString;

@ToString
// Marks this class as a JPA entity
@Entity
// Specifies the table name in the database
@Table(name = "employees")
public class Employee {

    // Primary Key
    @Id
    private Long id;
    // Employee name
    private double salary;
    // Employee salary
    private String name;

    // Default Constructor for mapper
    public Employee() {
    }

    // Parameterized Constructor to initialize the Employee details
    public Employee(Long id , String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getter and Setter for 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for 'salary'
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
