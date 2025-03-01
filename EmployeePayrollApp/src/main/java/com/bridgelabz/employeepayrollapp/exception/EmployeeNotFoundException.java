package com.bridgelabz.employeepayrollapp.exception;
// Create a EmployeeNotFoundException class to manage the exception and provide custom message to user
public class EmployeeNotFoundException extends RuntimeException {
    
    public EmployeeNotFoundException(String message) {
        // Pass the message to RuntimeException
        super(message);
    }
}
