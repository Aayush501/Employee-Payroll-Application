package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {
    private long ID;

    @NotBlank(message = "Name Cannot Be Blank!!")
    private String name;
    private double salary;
}
