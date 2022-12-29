package com.example.mongo.crud.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private Integer age;

}
