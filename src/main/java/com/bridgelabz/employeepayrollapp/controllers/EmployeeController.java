package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.dto.PayrollDTO;
import com.bridgelabz.employeepayrollapp.services.EmployeePayrollServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeePayrollServices services;

    @GetMapping("/uc1")
    public ResponseEntity<String > getEmployee(@RequestParam(required = false, defaultValue = "Employee") String name) {
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

    @GetMapping("/uc2/all")
    public ResponseEntity<List<PayrollDTO>> getAllPayrollData() {
        return services.getAll();
    }
}
