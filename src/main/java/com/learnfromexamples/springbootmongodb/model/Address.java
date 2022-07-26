package com.learnfromexamples.springbootmongodb.model;

import lombok.Data;

@Data
public class Address {
    private String houseNumber;
    private String apartmentName;
    private String street;
    private String city;
    private String  country;
    private String pincode;
}
