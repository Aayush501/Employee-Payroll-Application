package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFound;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepo;
    private ModelMapper modelMapper = new ModelMapper();

    // using list to store data of all employee
    List<EmployeeModel> employeeList = new ArrayList<>();

    public List<EmployeeDTO> getAllEmployee(){
        employeeList = employeeRepo.findAll();

        if (!employeeList.isEmpty()) {
            List<EmployeeDTO> employeeDTOList = new ArrayList<>();
            log.info("GET ALL EMPLOYEES");

            for(EmployeeModel employeeModel: employeeList){
                employeeDTOList.add(modelMapper.map(employeeModel,EmployeeDTO.class));
            }
            return employeeDTOList;
        } else {
            log.warn("NO EMPLOYEES FOUND");
            return null;
        }
    }

    public EmployeeDTO getEmployee(Long id) throws EmployeeNotFound {
        log.info("GET EMPLOYEE BY ID");
        Optional<EmployeeModel> employeeEntity = employeeRepo.findById(id);
        if (employeeEntity.isPresent()) {
            return modelMapper.map(employeeEntity.get(), EmployeeDTO.class);
        } else {
            log.warn("Employee with ID: {} not found", id);
            throw new EmployeeNotFound();
        }
    }

    public String addEmployee(EmployeeDTO employee){
        EmployeeModel employeeModel = modelMapper.map(employee, EmployeeModel.class);
        employeeRepo.save(employeeModel);

        log.info("Given employee has been added to the database");
        return employee.getName();
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employee) throws EmployeeNotFound {
        Optional<EmployeeModel> existingEmployeeOpt = employeeRepo.findById(id);

        if(existingEmployeeOpt.isPresent()){
            EmployeeModel existEmployee = existingEmployeeOpt.get();
            modelMapper.map(employee, existEmployee);
            EmployeeModel updatedEmployee = employeeRepo.save(existEmployee);
            log.info("UPDATED EMPLOYEE");
            return modelMapper.map(updatedEmployee, EmployeeDTO.class);
        }
        // throw exception if employee is not found
        log.error("Employee can't found");
        throw new EmployeeNotFound();
    }

    public boolean deleteEmployee(long id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            log.info("DELETED EMPLOYEE");
            return true;
        }
        log.warn("EMPLOYEE NOT FOUND");
        return false;
    }
}