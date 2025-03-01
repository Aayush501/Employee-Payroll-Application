package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.services.EmployeeServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices services;

    @GetMapping("/uc1")
    public ResponseEntity<String > getEmployee(@RequestParam(required = false, defaultValue = "Employee") String name) {
        log.info("Responding Hello!");
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

    @GetMapping("/uc2/all")
    public ResponseEntity<String> getAllPayrollData() {
        log.info("Fetching All Data And Responding!");
        return new ResponseEntity<>("Fetching All Data : ", HttpStatus.OK);
    }

    @GetMapping("/uc2/get/{ID}")
    public ResponseEntity<String> getSpecific(@PathVariable int id) {
        log.info("Fetching specific data!!");
        log.warn("Make Sure Your Path Variable Is Correct !!");
        return new ResponseEntity<>("Fetching Specific Data : " + services.getSpecificData(id), HttpStatus.OK);
    }

    @PostMapping("/uc2/post")
    public ResponseEntity<String> postData(@Valid @RequestBody EmployeeDTO dto) {
        log.info("posting data !!");
        return new ResponseEntity<>("Posting Data: " + services.addEmployee(dto), HttpStatus.OK);
    }

    @PutMapping("/uc2/put/{ID}")
    public ResponseEntity<String> updateData(@Valid @RequestBody EmployeeDTO dto, @PathVariable String ID) {
        log.info("modifying data !!");
        return new ResponseEntity<>("Modifying Data: " + services.modifyEmployee(dto), HttpStatus.OK);
    }

    @DeleteMapping("/uc2/delete/{ID}")
    public ResponseEntity<String> deleteData(@RequestBody Object body, @PathVariable String ID) {
        log.info("deleting data !!");
        return new ResponseEntity<>("Deleting Data: ", HttpStatus.OK);
    }
}
