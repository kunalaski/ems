package com.example.ems.controllers;

import com.example.ems.model.Employee;
import com.example.ems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee create(@Valid @RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/employee")
    public Iterable<Employee> read() {
        return employeeService.findAll();
    }

    @PutMapping("/employee")
    public ResponseEntity update(@RequestBody Employee employee) {
        if (employeeService.findById(employee.getEmpID()).isPresent())
            return new ResponseEntity(employeeService.save(employee), HttpStatus.OK);
        else
            return new ResponseEntity(employee, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable Integer id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> findById(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    @GetMapping("/wrong")
    public Employee somethingIsWrong() {
        throw new ValidationException("Something is wrong");
    }

}