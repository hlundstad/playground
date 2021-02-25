package com.lundstad.playground.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor

//@JsonIgnoreProperties(ignoreUnknown=true)
//@JsonIgnoreProperties
@ToString
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
}
