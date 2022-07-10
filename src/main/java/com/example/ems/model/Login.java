package com.example.ems.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "LOGIN")
public class Login {

    @OneToOne(targetEntity=Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;

    @Id
    @GeneratedValue
    @Column(name = "id")
    int loginID;

    String loginUserName;

    String loginPassword;

    char loginRole;

}
