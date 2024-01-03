package com.example.demojphibernate01.entity.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@RequiredArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

//    @OneToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
////    @JsonBackReference
//    private User user;

}