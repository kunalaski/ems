package com.example.ems.controllers;

import com.example.ems.model.Login;
import com.example.ems.model.Timesheet;
import com.example.ems.services.LoginService;
import com.example.ems.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class TimesheetController {

    @Autowired
    TimesheetService timesheetService;

    @PostMapping("/timesheet")
    Timesheet create(@Valid @RequestBody Timesheet timesheet) {
        return timesheetService.save(timesheet);
    }

    @GetMapping("/timesheet")
    Iterable<Timesheet> read() {
        return timesheetService.findAll();
    }

    @PutMapping("/timesheet")
    ResponseEntity update(@RequestBody Timesheet timesheet) {
        if (timesheetService.findById(timesheet.getTimeID()).isPresent())
            return new ResponseEntity(timesheetService.save(timesheet), HttpStatus.OK);
        else
            return new ResponseEntity(timesheet, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/timesheet/{id}")
    void delete(@PathVariable Integer id) {
        timesheetService.deleteById(id);
    }

    @GetMapping("/timesheet/{id}")
    Optional<Timesheet> findById(@PathVariable Integer id) {

        return timesheetService.findById(id);

    }

}
