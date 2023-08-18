package com.vic.backendvicbuildup.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Person")
@Data
public class Person {

    //Para más de una palabra debo usar el guion bajo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Person_Id", unique = true, nullable = false)
    private int person_Id;

    private String email;
    private String first_Name;
    private String last_Name;
    private int age;
    private Long phone;

}
