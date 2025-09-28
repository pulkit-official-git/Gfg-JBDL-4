package com.example.batch4iocdi;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Person {
    String name;
    int age;

    Person(String name, int age) {
        System.out.println("Inside Person parameterised constructor");
        this.name = name;
        this.age = age;
    }

    Person() {
        System.out.println("Inside Person default constructor"+ this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
