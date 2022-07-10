package com.example.ems.services;

import com.example.ems.model.Timesheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface TimesheetService extends CrudRepository<Timesheet, Integer> {
}
