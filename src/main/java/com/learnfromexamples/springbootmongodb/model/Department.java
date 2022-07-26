package com.learnfromexamples.springbootmongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "department")
public class Department {
    @Transient
    public static final String SEQUENCE_NAME = "department_sequence";

    @Id
    private Long  id;
    private String departmentId;
    private String departmentName;
}
