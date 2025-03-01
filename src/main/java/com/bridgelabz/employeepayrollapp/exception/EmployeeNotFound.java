package com.bridgelabz.employeepayrollapp.exception;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound() {
        super("Sorry, The Employee Does Not Exist !!! Please Ensure The Parameters You Are Passing, Are Valid !!!");
    }
}
