package com.lundstad.employees.model;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Employee {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;

}
