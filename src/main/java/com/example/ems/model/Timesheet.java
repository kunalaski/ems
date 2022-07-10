package com.example.ems.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "TIMESHEET")
public class Timesheet {

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @Id
    @GeneratedValue
    @Column(name = "id")
    int timeID;

    String empName;

    int timeTotalHours;

    Date timeDate;

    String timeTask;

    String timeDesc;

}
