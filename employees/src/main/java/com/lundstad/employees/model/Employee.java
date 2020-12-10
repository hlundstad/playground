package com.lundstad.employees.model;
import lombok.Value;

@Value
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private String email;

}
