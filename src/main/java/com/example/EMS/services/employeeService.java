package com.example.EMS.services;

import com.example.EMS.dao.employeeDao;
import com.example.EMS.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Service Layer:
//Develop a service layer to handle business logic and interact with the repository layer.
//Methods should include:
//getAllEmployees(): List all employees.
//getEmployeeById(Long id): Retrieve employee by ID.
//createEmployee(Employee employee): Add a new employee.
//updateEmployee(Long id, Employee employee): Update employee details.
//deleteEmployee(Long id): Delete employee by ID.
//

@Service
public class employeeService {

    @Autowired
    employeeDao employeedao;


    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            return new ResponseEntity<>(employeedao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Employee> getEmployeeById(Long id) {
        try {
            return new ResponseEntity<>(employeedao.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public ResponseEntity<String> createEmployee(Employee employee) {
        try {
            employeedao.save(employee);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public ResponseEntity<String> deleteEmployee(Long id) {
        try {
            employeedao.deleteById(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public ResponseEntity<String> updateEmployee(Long id, Employee employee) {
        try {
            Optional<Employee> optionalEmployee = employeedao.findById(id);
            if (!optionalEmployee.isPresent()) return null;
            Employee prevEmployee = optionalEmployee.get();

            if(employee.getFirstName()!=null)
            prevEmployee.setFirstName(employee.getFirstName());
            if(employee.getLastName()!=null)
            prevEmployee.setLastName(employee.getLastName());
            if(employee.getEmail()!=null)
            prevEmployee.setEmail(employee.getEmail());
            if(employee.getDepartment()!=null)
            prevEmployee.setDepartment(employee.getDepartment());
            if(employee.getSalary()!=0)
            prevEmployee.setSalary(employee.getSalary());

            employeedao.save(prevEmployee);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
