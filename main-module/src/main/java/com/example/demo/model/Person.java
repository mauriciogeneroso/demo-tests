package com.example.demo.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Person {

    /*

     CREATE TABLE person (
        id varchar,
        name varchar,
        age int,
        PRIMARY KEY (id)
      );
     */

    @PrimaryKey
    private final String id;

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}