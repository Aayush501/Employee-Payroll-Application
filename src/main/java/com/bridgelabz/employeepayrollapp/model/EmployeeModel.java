package com.bridgelabz.employeepayrollapp.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeModel {
    private long ID;
    private String name;
    private double salary;
    private String gender;
    private String startDate;
    private String note;
    private String profilePic;
    private String department;
}
