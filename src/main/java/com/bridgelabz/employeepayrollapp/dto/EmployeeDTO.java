package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {
    private long ID;

    @NotBlank(message = "Name Cannot Be Blank!!")
    @Size(min = 2, max = 25, message = "name must be between 2 and 25 characters.")
    private String name;
    private double salary;
}
