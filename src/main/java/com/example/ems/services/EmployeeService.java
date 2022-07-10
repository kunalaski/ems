package com.example.ems.services;

import com.example.ems.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService extends CrudRepository<Employee, Integer> {

}
