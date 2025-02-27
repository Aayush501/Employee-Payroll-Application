package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServices {
    public String addEmployee(EmployeeDTO dto) {
        EmployeeModel model = new EmployeeModel();
        model.setID(dto.getID());
        model.setName(dto.getName());
        model.setSalary(dto.getSalary());

        String [] modelObject = {Long.toString(model.getID()), model.getName(), Double.toString(model.getSalary())};
        return Arrays.toString(modelObject);
    }

    public String modifyEmployee(EmployeeDTO dto) {
        EmployeeModel model = new EmployeeModel();
        model.setID(dto.getID());
        model.setName(dto.getName());
        model.setSalary(dto.getSalary());

        String [] modelObject = {Long.toString(model.getID()), model.getName(), Double.toString(model.getSalary())};
        return Arrays.toString(modelObject);
    }
}
