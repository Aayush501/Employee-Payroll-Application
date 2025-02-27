package com.bridgelabz.employeepayrollapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/uc1")
    public ResponseEntity<String > getEmployee(@RequestParam(required = false, defaultValue = "Employee") String name) {
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }
}
