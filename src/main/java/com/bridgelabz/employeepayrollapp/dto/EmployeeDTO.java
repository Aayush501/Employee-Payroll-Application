package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class EmployeeDTO {

    @NotBlank(message = "Name Cannot Be Blank!!")
    @Size(min = 2, max = 25, message = "name must be between 2 and 25 characters.")
    private String name;

    @Min(value = 500, message = "Salary should not be less than 500")
    private double salary;

    @Pattern(regexp = "male|female", message = "gender can only be male or female")
    private String gender;

    @JsonFormat (pattern = "dd MM yyyy")
    @NotNull (message = "startDate Cannot Be Empty")
    @PastOrPresent (message = "Date Should Be Today Or Past")
    private LocalDate startDate;

    @NotBlank (message = "Note Cannot Be Blank")
    private String note;

    @NotBlank (message = "Profile Pic Cannot Be Blank")
    private String profilePic;

    @NotBlank (message = "Department Pic Cannot Be Blank")
    private String department;
}
