package com.bridgelabz.employeepayrollapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/uc1")
    public ResponseEntity<String > getEmployee(@RequestParam(required = false, defaultValue = "Employee") String name) {
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

    @GetMapping("/uc2/all")
    public ResponseEntity<String> getAllPayrollData() {
        return new ResponseEntity<>("Fetching All Data : ", HttpStatus.OK);
    }

    @GetMapping("/uc2/get/{ID}")
    public ResponseEntity<String> getSpecific(@PathVariable int id) {
        return new ResponseEntity<>("Fetching All Data : ", HttpStatus.OK);
    }

    @PostMapping("/uc2/post")
    public ResponseEntity<String> postData(@RequestBody Object body) {
        return new ResponseEntity<>("Posting Data: ", HttpStatus.OK);
    }

    @PutMapping("/uc2/put/{ID}")
    public ResponseEntity<String> updateData(@RequestBody Object body, @PathVariable String ID) {
        return new ResponseEntity<>("Modifying Data: ", HttpStatus.OK);
    }

    @DeleteMapping("/uc2/delete/{ID}")
    public ResponseEntity<String> deleteData(@RequestBody Object body, @PathVariable String ID) {
        return new ResponseEntity<>("Deleting Data: ", HttpStatus.OK);
    }
}
