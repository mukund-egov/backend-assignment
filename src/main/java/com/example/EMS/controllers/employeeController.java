package com.example.EMS.controllers;


import com.example.EMS.models.Employee;
import com.example.EMS.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//Controller Layer:
//Develop a REST controller to handle HTTP requests and map them to the service layer.
//Endpoints should include:
//GET /employees: Get all employees.
//GET /employees/{id}: Get employee by ID.
//POST /employees: Create a new employee.
//PUT /employees/{id}: Update an existing employee.
//DELETE /employees/{id}: Delete an employee by ID.


@RestController
@RequestMapping("/employees")
public class employeeController {

    @Autowired
    employeeService employeeservice;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return employeeservice.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return employeeservice.getEmployeeById(id);
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        return employeeservice.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return employeeservice.deleteEmployee(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeservice.updateEmployee(id,employee);
    }












}

