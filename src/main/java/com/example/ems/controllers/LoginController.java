package com.example.ems.controllers;

import com.example.ems.model.Employee;
import com.example.ems.model.Login;
import com.example.ems.services.EmployeeService;
import com.example.ems.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    Login create(@Valid @RequestBody Login login) {
        return loginService.save(login);
    }

    @GetMapping("/login")
    Iterable<Login> read() {
        return loginService.findAll();
    }

    @PutMapping("/login")
    ResponseEntity update(@RequestBody Login login) {
        if (loginService.findById(login.getLoginID()).isPresent())
            return new ResponseEntity(loginService.save(login), HttpStatus.OK);
        else
            return new ResponseEntity(login, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/login/{id}")
    void delete(@PathVariable Integer id) {
        loginService.deleteById(id);
    }

    @GetMapping("/login/{id}")
    Optional<Login> findById(@PathVariable Integer id) {

        return loginService.findById(id);

    }
}
