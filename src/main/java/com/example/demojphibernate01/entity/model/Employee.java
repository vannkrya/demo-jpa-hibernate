package com.example.demojphibernate01.entity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 250)
    private String firstName;

    @Column(nullable = false, length = 250)
    private String lastName;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Transient
    private String temp;

}
