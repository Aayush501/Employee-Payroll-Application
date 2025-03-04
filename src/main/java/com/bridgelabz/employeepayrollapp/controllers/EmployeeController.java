package com.bridgelabz.employeepayrollapp.controllers;


import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFound;
import com.bridgelabz.employeepayrollapp.services.EmployeeServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeService;

    @GetMapping("/uc1")
    public ResponseEntity<String > getEmployee(@RequestParam(required = false, defaultValue = "Employee") String name) {
        log.info("Responding Hello!");
        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
    }

    @GetMapping("/uc2/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        // print all employees name
        log.info("All employees are printed");
        return new ResponseEntity<>(employeeService.getAllEmployee() , HttpStatus.OK);
    }

    @GetMapping("/uc2/get/{ID}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) throws EmployeeNotFound {
        // searching in list if the id is present in tha list
        EmployeeDTO name = employeeService.getEmployee(id);

        // return name of the employee if exist in list

        log.info("Employee with name {} is printed", name);
        return new ResponseEntity<>(name, HttpStatus.OK);

    }

    // adding new employee
    @PostMapping("/uc2/post")
    public ResponseEntity<String> postEmployee(@Valid @RequestBody EmployeeDTO employee){
        // print name of added employee
        log.info("{} has been added to the list", employee.getName());
        return new ResponseEntity<>("Employee created : " + employeeService.addEmployee(employee), HttpStatus.CREATED);
    }



    @PutMapping("/uc2/put/{ID}")
    public ResponseEntity<EmployeeDTO> putEmployee(@PathVariable Long id,
                                                   @Valid @RequestBody EmployeeDTO employee) throws EmployeeNotFound {

        // update employee given by data given by user
        EmployeeDTO name = employeeService.updateEmployee(id, employee);

        // print name of employee record updated

        log.info("Employee info has been updated.");
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @DeleteMapping("/uc2/delete/{ID}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) throws EmployeeNotFound {
        // deleting the employee
        boolean isDeleted = employeeService.deleteEmployee(id);

        if(isDeleted){
            log.info("Employee data has been deleted.");
            return new ResponseEntity<>("Employee has been deleted.", HttpStatus.OK);
        }
        else{
            log.info("Employee data has not been deleted.");
            return new ResponseEntity<>("Employee has not been delted.", HttpStatus.BAD_REQUEST);
        }
    }
}