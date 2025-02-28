package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServices {
    private List<EmployeeModel> employees = new ArrayList<>();

    public String addEmployee(EmployeeDTO dto) {
        EmployeeModel model = new EmployeeModel();
        model.setID(dto.getID());
        model.setName(dto.getName());
        model.setSalary(dto.getSalary());

        employees.add(model);

        String [] modelObject = {Long.toString(model.getID()), model.getName(), Double.toString(model.getSalary())};
        return Arrays.toString(modelObject);
    }

    public String modifyEmployee(EmployeeDTO dto) {
        EmployeeModel model = null;

        for (EmployeeModel employeeModel : employees) {
            if (employeeModel.getID() == dto.getID()) {
                employeeModel.setName(dto.getName());
                employeeModel.setSalary(dto.getSalary());
                model = employeeModel;
                break;
            }
        }

        if(model==null) {
            return "Employee not found !!!";
        }

        String [] modelObject = {Long.toString(model.getID()), model.getName(), Double.toString(model.getSalary())};
        return Arrays.toString(modelObject);
    }
}
