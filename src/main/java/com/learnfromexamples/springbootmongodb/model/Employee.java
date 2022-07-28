package com.learnfromexamples.springbootmongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "employee")
public class Employee {

    @Transient
    public static final String SEQUENCE_NAME = "employee_sequence";

    @Id
    private Long  id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String[] hobbies;
    private Address address;
    private Double salary;
    @DBRef(db = "department")
    private Department department;
}
