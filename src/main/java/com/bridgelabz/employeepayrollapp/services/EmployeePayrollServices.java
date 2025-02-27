package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.PayrollDTO;
import com.bridgelabz.employeepayrollapp.entities.PayrollEntity;
import com.bridgelabz.employeepayrollapp.repository.PayrollRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollServices {

    private static final Logger logger = LoggerFactory.getLogger(EmployeePayrollServices.class);

    @Autowired
    private PayrollRepository repository;

    public ResponseEntity<List<PayrollDTO>> getAll() {


        List<PayrollEntity> allEntity = repository.findAll();

        List<PayrollDTO> allDTO = allEntity.stream().map(entity -> new PayrollDTO(entity.getId(), entity.getName(), entity.getSalary())).toList();

        return ResponseEntity.ok(allDTO);
    }
}
