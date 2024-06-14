package com.example.EMS.dao;

import com.example.EMS.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface employeeDao extends JpaRepository<Employee,Long> {

//    List<Employee> SearchById(Long id);
}
