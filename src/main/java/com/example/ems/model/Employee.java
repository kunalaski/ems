package com.example.ems.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
    List<Timesheet> timesheetList;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int empID;

    @Column(name = "name")
    private String empName;

    @Column(name = "contact")
    private long empContact;

    @Column(name = "department")
    private String empDepartment;

    @Column(name = "email")
    private String empEmail;

    @Column(name = "address")
    private String empAddress;

    @Column(name = "role")
    private String empRole;

}
