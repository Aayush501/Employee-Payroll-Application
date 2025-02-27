package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // Generates getters, setters, toString, equals, and hashCode
@AllArgsConstructor
public class PayrollDTO {
    private Integer id;
    private String name;
    private Double salary;
}
