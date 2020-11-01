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
public class Product {


//    public Product(Integer id, String name, double price) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        System.out.println("id: "+id + " name: "+ name + " price: "+price);
//    }
//    @JsonIgnoreProperties({ "id"})
    private Integer id;

    private String name;

    private double price;
}
